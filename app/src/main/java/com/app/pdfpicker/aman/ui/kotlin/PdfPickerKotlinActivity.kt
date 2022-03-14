package com.app.pdfpicker.aman.ui.kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.app.pdfpicker.aman.databinding.ActivityMainBinding
import com.app.pdfpicker.aman.ui.common.BaseActivity

class PdfPickerKotlinActivity : BaseActivity<ActivityMainBinding>() {

    var resultPdf  = registerForActivityResult(ActivityResultContracts.GetContent()) {
            binding.tvPickedFileUri.text = it?.let {
                ""+it.path
            }
        }

    companion object{
        fun start(activity: Activity){
            Intent(activity,PdfPickerKotlinActivity::class.java).run {
                activity.startActivity(this)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater))
        setListeners()
    }

    private fun setListeners() {
        binding.btnPickPdf.setOnClickListener {
            //"application/pdf" is mime type for pdf you can add different mime types for picking different kind of files
            //e.g image/*
            resultPdf.launch("application/pdf")
        }
    }
}