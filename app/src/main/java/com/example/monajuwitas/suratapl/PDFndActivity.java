package com.example.monajuwitas.suratapl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFndActivity extends AppCompatActivity {
    PDFView pdfview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfnd);
        pdfview = (PDFView) findViewById(R.id.pdfViewnd);
        pdfview.fromAsset("SPT.pdf").enableSwipe(true).load();
    }
}
