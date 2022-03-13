package com.app.pdfpicker.aman.ui.common

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

open abstract class BaseActivity<Binding : ViewBinding> : AppCompatActivity() {
    lateinit var binding: Binding
    fun setContentView(binding: Binding) {
        this.binding = binding
        setContentView(binding.root)
    }
}