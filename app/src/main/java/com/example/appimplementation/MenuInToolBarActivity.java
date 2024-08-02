package com.example.appimplementation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuInToolBarActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_in_tool_bar);

        /*
        to create a menu in tool bar we need to make separate menu in menu folder in res
         */

        Button nestedmenuoptions,menuandotheroptionintoolbar,normalmenuintoolbar;



        menuandotheroptionintoolbar=findViewById(R.id.optionsAndMenuInToolbar);
        nestedmenuoptions=findViewById(R.id.nestedmenuoptionsbutton);
        normalmenuintoolbar=findViewById(R.id.normalmenuintoolBarbutton);


        normalmenuintoolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuInToolBarActivity.this, NormalMenuToolbarActivity.class));
            }
        });



        menuandotheroptionintoolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuInToolBarActivity.this,ExtraOptionsAndMenuInToolBarActivity.class));

            }
        });


        nestedmenuoptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuInToolBarActivity.this,NestedOptionsInNestedOptionsActivity.class));

            }
        });

    }
}

