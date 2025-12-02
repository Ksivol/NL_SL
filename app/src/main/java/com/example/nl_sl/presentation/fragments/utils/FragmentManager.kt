package com.example.nl_sl.presentation.fragments.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.nl_sl.R

object FragmentManager {
    var currentFrag: BaseFragment? = null

    fun AppCompatActivity.setFragment(newFrag: BaseFragment) {
        this.supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.placeHolder, newFrag)
            addToBackStack(newFrag::class.qualifiedName)
        }
        currentFrag = newFrag
    }
}