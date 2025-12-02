package com.example.nl_sl.presentation.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isGone
import com.example.nl_sl.R
import com.example.nl_sl.databinding.ActivityMainBinding
import com.example.nl_sl.presentation.fragments.utils.FragmentManager.setFragment
import com.example.nl_sl.presentation.fragments.notenew.NewNoteFragment
import com.example.nl_sl.presentation.fragments.note.NoteFragment
import com.example.nl_sl.presentation.utils.viewBindings

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBindings(viewBindingFactory = ActivityMainBinding::inflate)

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
        supportFragmentManager.addOnBackStackChangedListener {
            supportFragmentManager.findFragmentById(R.id.placeHolder)?.let {
                val bool = it is NewNoteFragment
                binding.bNav.isGone = bool
            }
        }
    }

    private fun setBottomNavListener() {
        binding.bNav.selectedItemId = R.id.notes
        binding.bNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> {
                    true
                }

                R.id.notes -> {
                    setFragment(NoteFragment())
                    true
                }

                R.id.shop_list -> {
                    true
                }

                R.id.new_item -> {
                    setFragment(NewNoteFragment())
                    false
                }

                else -> false
            }
        }
    }
}