package com.example.nl_sl.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.nl_sl.data.repository.NoteRepositoryImpl
import com.example.nl_sl.databinding.FragmentNoteBinding
import com.example.nl_sl.domain.usecase.GetAllNotesUseCase
import com.example.nl_sl.domain.usecase.InsertNoteUseCase
import com.example.nl_sl.presentation.NoteViewModel
import com.example.nl_sl.presentation.main.MainApp
import kotlinx.coroutines.launch

class NoteFragment : BaseFragment() {
    private var _binding: FragmentNoteBinding? = null
    private val binding: FragmentNoteBinding
        get() = _binding!!

    private val viewModel: NoteViewModel by lazy {
        ViewModelProvider(
            this, factory = NoteViewModel.Factory(
                getAllNotesUseCase = GetAllNotesUseCase(
                    noteRepository = NoteRepositoryImpl(
                        noteDao = (requireContext() as MainApp).database.getDao()
                    )
                ),
                insertNoteUseCase = InsertNoteUseCase(
                    noteRepository = NoteRepositoryImpl(
                        noteDao = (requireContext() as MainApp).database.getDao()
                    )
                )
            )
        )[NoteViewModel::class.java]
    }

    override fun onClickNew() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.noteItemListStateFlow.collect {

                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        @JvmStatic
        fun newInstance() = NoteFragment()
    }
}