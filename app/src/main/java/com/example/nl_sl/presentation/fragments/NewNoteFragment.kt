package com.example.nl_sl.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import com.example.nl_sl.R
import com.example.nl_sl.databinding.FragmentNewNoteBinding
import com.example.nl_sl.presentation.main.MainActivity


class NewNoteFragment : BaseFragment() {
    private var _binding: FragmentNewNoteBinding? = null

    private val binding: FragmentNewNoteBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this, object :
            OnBackPressedCallback(enabled = true) {
            override fun handleOnBackPressed() {
                val mainActivity = requireActivity() as MainActivity
                mainActivity.bottomMenu?.isGone = false
                parentFragmentManager.popBackStack()
            }
        })
    }

    override fun onClickNew() {

    }

}