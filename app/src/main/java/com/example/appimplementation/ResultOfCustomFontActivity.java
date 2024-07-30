package com.example.appimplementation;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class ResultOfCustomFontActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_custom_font);

        //initilizations

        TextView customfonttxt=findViewById(R.id.customfonttxtview);


        //explanation
        /*
        we need to create a assets file in resources and in it create a font and in it put a customfont file ,extension is ttf or otf
         */

        //implentation
        Typeface typeface= ResourcesCompat.getFont(this,R.font.cralter_serif_rough);
        customfonttxt.setTypeface(typeface);
    }
}