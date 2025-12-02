package com.example.nl_sl.presentation.fragments.utils

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment {
    constructor(@LayoutRes containerId: Int) : super(containerId)
    constructor() : super()

    abstract fun onClickNew()
}