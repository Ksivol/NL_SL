package com.example.nl_sl.presentation.fragments

import androidx.appcompat.app.AppCompatActivity
import com.example.nl_sl.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

object FragmentManager {
    val currentFrag: MutableStateFlow<BaseFragment?> = MutableStateFlow(null)

    fun AppCompatActivity.setFragment(newFrag: BaseFragment) {
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.placeHolder, newFrag)
        transaction.commit()
        currentFrag.update { newFrag }
    }
}