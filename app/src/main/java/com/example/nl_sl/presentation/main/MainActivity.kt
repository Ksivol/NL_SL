package com.example.nl_sl.presentation.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.nl_sl.R
import com.example.nl_sl.databinding.ActivityMainBinding
import com.example.nl_sl.presentation.NoteViewModel
import com.example.nl_sl.presentation.fragments.FragmentManager
import com.example.nl_sl.presentation.fragments.FragmentManager.setFragment
import com.example.nl_sl.presentation.fragments.NewNoteFragment
import com.example.nl_sl.presentation.fragments.NoteFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: NoteViewModel by lazy { ViewModelProvider(this).get(NoteViewModel::class.java) }
    var bottomMenu: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setBottomNavListener()
        supportFragmentManager.registerFragmentLifecycleCallbacks(object :
            androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks() {
            override fun onFragmentResumed(
                fm: androidx.fragment.app.FragmentManager,
                f: Fragment
            ) {
                super.onFragmentResumed(fm, f)
                setSelectedMenuItem(f)
            }
        }, false)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                //viewModel.state.collect {}
            }
            FragmentManager.currentFrag.collect { fragment ->
                fragment?.let { setSelectedMenuItem(it) }
            }
        }
    }

    private fun setBottomNavListener() {
        //binding.bNav.selectedItemId = R.id.notes
        binding.bNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> {}
                R.id.notes -> {
                    //setFragment(NoteFragment.newInstance())
                }

                R.id.shop_list -> {}
                R.id.new_item -> {
                    setFragment(NewNoteFragment())
                    //binding.bNav.isGone = true
                }
            }
            true
        }

    }

    fun setSelectedMenuItem(fragment: Fragment) {
        val id: Int = when (fragment) {
            is NoteFragment -> R.id.notes
            is NewNoteFragment -> R.id.new_item
            else -> R.id.notes
        }
        binding.bNav.selectedItemId = id
    }
}