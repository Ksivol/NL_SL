package com.example.nl_sl

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel(){

    private val _state: MutableStateFlow<String> = MutableStateFlow("")
    val state: StateFlow<String> = _state.asStateFlow()
}