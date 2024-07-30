package com.example.appimplementation;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TextWatcherActivity extends AppCompatActivity implements TextWatcher {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_watcher);


       //initilizations

        EditText textwatcherEdittxt;
        textwatcherEdittxt=findViewById(R.id.textwatcheredittxt);

        //implementations

       textwatcherEdittxt.addTextChangedListener(this);
    }


    public void setTextMethod(String s)
    {
        TextView textwatchertxtview;
        textwatchertxtview=findViewById(R.id.textwatchertxtview);

        textwatchertxtview.setText(s);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
       setTextMethod("before text changed");
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    setTextMethod("on text changed");

    }

    @Override
    public void afterTextChanged(Editable s) {
      setTextMethod("after text changed");

    }

}