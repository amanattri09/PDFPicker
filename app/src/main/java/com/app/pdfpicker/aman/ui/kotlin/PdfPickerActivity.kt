package com.app.pdfpicker.aman.ui.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.app.pdfpicker.aman.R
import com.app.pdfpicker.aman.databinding.ActivityMainBinding
import com.app.pdfpicker.aman.ui.common.BaseActivity

class PdfPickerActivity : BaseActivity<ActivityMainBinding>() {

    var resultPdf  = registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.tvPickedFileUri.text = it?.let {
            it.path
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater))
        setListeners()
    }

    private fun setListeners() {
        binding.btnPickPdf.setOnClickListener {
            resultPdf.launch("application/pdf")
        }
    }
}