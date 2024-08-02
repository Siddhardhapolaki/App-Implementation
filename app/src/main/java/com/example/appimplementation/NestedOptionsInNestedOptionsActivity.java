package com.example.appimplementation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NestedOptionsInNestedOptionsActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mnuinflator=getMenuInflater();
        mnuinflator.inflate(R.menu.nested_options_in_options_in_menu_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       int id=item.getItemId();
       String str;
       if(id==R.id.nested_menu_book)
       {
           str="Upper menubook";
       }
       else if(id==R.id.nested_menu_camera)str="camera under menu book";
       else if(id==R.id.nested_under_camera_menu_search)str="search under camera";
       else if(id==R.id.nested_under_camera_menu_group)str="group under camera";
       else if(id==R.id.nested_menu_settings)str="settings under menu book";
       else if(id==R.id.nested_under_settings_menu_search)str="search under settings";
       else if(id==R.id.nested_under_settings_menu_camera)str="camera under settings";
       else
        return super.onOptionsItemSelected(item);

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nested_options_in_nested_options);


    }
}