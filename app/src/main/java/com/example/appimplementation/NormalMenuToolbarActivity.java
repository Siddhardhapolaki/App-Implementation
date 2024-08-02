package com.example.appimplementation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class NormalMenuToolbarActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mnuinflator=getMenuInflater();
        mnuinflator.inflate(R.menu.menu_for_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.menu_group) {
            Toast.makeText(this, "group", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id==R.id.menu_settings) {
            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
            return true;
        }

        else return super.onOptionsItemSelected(item);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_menu_toolbar);

    }
}