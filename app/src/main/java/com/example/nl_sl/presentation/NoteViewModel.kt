package com.example.nl_sl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.nl_sl.domain.model.NoteItemModel
import com.example.nl_sl.domain.usecase.GetAllNotesUseCase
import com.example.nl_sl.domain.usecase.InsertNoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NoteViewModel(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val insertNoteUseCase: InsertNoteUseCase
) : ViewModel() {
    private val _noteItemListStateFlow: MutableStateFlow<List<NoteItemModel>> = MutableStateFlow(listOf())
    val noteItemListStateFlow: StateFlow<List<NoteItemModel>> = _noteItemListStateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            getAllNotesUseCase().collect {
                _noteItemListStateFlow.emit(it)
            }
        }
    }
    class Factory(
        private val getAllNotesUseCase: GetAllNotesUseCase,
        private val insertNoteUseCase: InsertNoteUseCase
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return NoteViewModel(getAllNotesUseCase, insertNoteUseCase) as T
            } else {
                throw IllegalArgumentException("Unknown viewModel class")
            }
        }
    }
}