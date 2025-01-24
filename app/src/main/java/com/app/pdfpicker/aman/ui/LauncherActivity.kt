package com.app.pdfpicker.aman.ui

import android.os.Bundle
import com.app.pdfpicker.aman.databinding.ActivityLauncherBinding
import com.app.pdfpicker.aman.ui.common.BaseActivity
import com.app.pdfpicker.aman.ui.java.PdfPickerJavaActivity

class LauncherActivity : BaseActivity<ActivityLauncherBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityLauncherBinding.inflate(layoutInflater))
        setListener();
        // just to run workflow
    }

    private fun setListener() {
        binding.btnPickPdfJava.setOnClickListener {
            PdfPickerJavaActivity.start(LauncherActivity@this);
        }
        binding.btnPickPdfKOTLIN.setOnClickListener {
            com.app.pdfpicker.aman.ui.kotlin.PdfPickerKotlinActivity.start(LauncherActivity@this)
        }
    }
}