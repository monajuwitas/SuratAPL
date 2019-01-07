package com.example.monajuwitas.suratapl.Utils;

import android.graphics.Typeface;
import android.widget.TextView;

public class Utils {
    public static void setFontSignika_Bold(TextView textView) {
        Typeface tf = Typeface.createFromAsset(textView.getContext()
                .getAssets(), "fonts/MFthin.otf");

        textView.setTypeface(tf);

    }

}
