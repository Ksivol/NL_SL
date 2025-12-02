package com.example.nl_sl.presentation.fragments.note

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.nl_sl.R
import com.example.nl_sl.data.repository.NoteRepositoryImpl
import com.example.nl_sl.databinding.FragmentNoteBinding
import com.example.nl_sl.domain.usecase.GetAllNotesUseCase
import com.example.nl_sl.domain.usecase.InsertNoteUseCase
import com.example.nl_sl.presentation.fragments.utils.BaseFragment
import com.example.nl_sl.presentation.main.MainApp
import com.example.nl_sl.presentation.utils.viewBindings
import kotlinx.coroutines.launch

class NoteFragment : BaseFragment(R.layout.fragment_note) {
    private val binding: FragmentNoteBinding by viewBindings(FragmentNoteBinding::bind)

    private val viewModel: NoteViewModel by lazy {
        ViewModelProvider(
            this, factory = NoteViewModel.Factory(
                getAllNotesUseCase = GetAllNotesUseCase(
                    noteRepository = NoteRepositoryImpl(
                        noteDao = (requireContext().applicationContext as MainApp).database.getDao()
                    )
                ),
                insertNoteUseCase = InsertNoteUseCase(
                    noteRepository = NoteRepositoryImpl(
                        noteDao = (requireContext().applicationContext as MainApp).database.getDao()
                    )
                )
            )
        )[NoteViewModel::class.java]
    }

    override fun onClickNew() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.noteItemListStateFlow.collect {}
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}