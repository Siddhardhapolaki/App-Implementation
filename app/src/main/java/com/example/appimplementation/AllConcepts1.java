package com.example.appimplementation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AllConcepts1 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allconcepts1);

        //initilizations
        Button customfontbut,textwatcherbut,alltypesviewssbut;
        Button listviewsbut;
        Button storagebutton;

        customfontbut=findViewById(R.id.customfontbutton);
        textwatcherbut=findViewById(R.id.textwatcherbutton);
        alltypesviewssbut=findViewById(R.id.alltypesviewsbutton);
        listviewsbut=findViewById(R.id.listviewsbutton);
        storagebutton=findViewById(R.id.storagebutton);






        //implementations

        customfontbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(AllConcepts1.this, ResultOfCustomFontActivity.class));
            }
        });


        textwatcherbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllConcepts1.this,TextWatcherActivity.class));

            }
        });

        alltypesviewssbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllConcepts1.this,DifferentViewsActivity.class));

            }
        });

       listviewsbut.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(AllConcepts1.this,ListViewsActivity.class));

           }
       });


      storagebutton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(AllConcepts1.this, StorageActivity1.class));
          }
      });
    }
}