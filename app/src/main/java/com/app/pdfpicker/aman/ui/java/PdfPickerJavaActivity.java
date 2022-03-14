package com.app.pdfpicker.aman.ui.java;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.app.pdfpicker.aman.R;

public class PdfPickerJavaActivity extends AppCompatActivity {

    private ActivityResultLauncher<String> pdfPickerLauncher;

    public static void start(Activity activity){
        Intent intent=new Intent(activity, PdfPickerJavaActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();
        setObservers();
    }

    private void setObservers() {
        pdfPickerLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), (Uri uri) -> {
            ((TextView) findViewById(R.id.tvPickedFileUri)).setText("" + uri.getPath());
        });
    }

    private void setListeners() {
        findViewById(R.id.btnPickPdf).setOnClickListener((View view) -> {
            //"application/pdf" is mime type for pdf you can add different mime types for picking different kind of files
            //e.g image/*
            pdfPickerLauncher.launch("application/pdf");
        });
    }

}
