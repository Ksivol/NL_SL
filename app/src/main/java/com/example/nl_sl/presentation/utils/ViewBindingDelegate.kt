package com.example.nl_sl.presentation.utils

import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <T : ViewBinding> Fragment.viewBindings(
    viewBindingFactory: (View) -> T,
): FragmentViewBindingDelegate<T> {
    return FragmentViewBindingDelegate(viewBindingFactory = viewBindingFactory)
}

fun <T : ViewBinding> AppCompatActivity.viewBindings(
    viewBindingFactory: (LayoutInflater) -> T,
): ActivityViewBindingDelegate<T> {
    return ActivityViewBindingDelegate(viewBindingFactory = viewBindingFactory)
}

class ActivityViewBindingDelegate<T : ViewBinding>(
    private val viewBindingFactory: (LayoutInflater) -> T
) : ReadOnlyProperty<AppCompatActivity, T>, LifecycleEventObserver {
    private var binding: T? = null

    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {
        return binding
            ?: viewBindingFactory(thisRef.layoutInflater).also {
                binding = it
                thisRef.lifecycle.addObserver(this)
            }
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_DESTROY)
            binding = null
    }
}

class FragmentViewBindingDelegate<T : ViewBinding>(
    private val viewBindingFactory: (View) -> T
) : ReadOnlyProperty<Fragment, T>, LifecycleEventObserver {
    private var binding: T? = null

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return binding
            ?: viewBindingFactory(thisRef.requireView()).also {
                binding = it
                thisRef.lifecycle.addObserver(this)
            }
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_DESTROY)
            binding = null
    }
}
