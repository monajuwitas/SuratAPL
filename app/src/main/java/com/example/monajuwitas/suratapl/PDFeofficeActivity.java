package com.example.monajuwitas.suratapl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFeofficeActivity extends AppCompatActivity {
    PDFView pdfview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfeoffice);
        pdfview = (PDFView) findViewById(R.id.pdfVieweoffice);
        pdfview.fromAsset("EOffice.pdf").enableSwipe(true).load();
    }
}
