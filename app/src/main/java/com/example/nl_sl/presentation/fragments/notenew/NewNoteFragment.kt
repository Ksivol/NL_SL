package com.example.nl_sl.presentation.fragments.notenew

import android.os.Bundle
import android.view.View
import com.example.nl_sl.R
import com.example.nl_sl.databinding.FragmentNewNoteBinding
import com.example.nl_sl.presentation.fragments.utils.BaseFragment
import com.example.nl_sl.presentation.utils.viewBindings

class NewNoteFragment : BaseFragment(R.layout.fragment_new_note) {
    private val binding: FragmentNewNoteBinding by viewBindings(FragmentNewNoteBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title.setText("Poop")
    }

    override fun onClickNew() {

    }
}