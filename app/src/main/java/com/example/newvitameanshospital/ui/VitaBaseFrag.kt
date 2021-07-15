package com.example.newvitameanshospital.ui

import android.content.Context
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner

abstract class VitaMainFragPart<T : ViewDataBinding> {

    protected lateinit var view: View
    protected lateinit var lifecycleOwner: LifecycleOwner
    protected lateinit var context: Context
    protected lateinit var binding: T
    open fun onCreateView(view: View, lifecycleOwner: LifecycleOwner) {
        this.view = view
        this.context = view.context
        this.lifecycleOwner = lifecycleOwner
        binding = DataBindingUtil.bind(view)!!
    }

    abstract fun onViewCreated()

    open fun onDestroyView() {
        binding.unbind()
    }
}
