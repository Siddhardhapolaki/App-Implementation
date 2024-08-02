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

public class ExtraOptionsAndMenuInToolBarActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mnuinflator=getMenuInflater();
        mnuinflator.inflate(R.menu.extraoptions_and_menu_for_toolbar,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.extraoptions_menu_camera ) {
            Toast.makeText(this, "outside camera", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id==R.id.extraoptions_menu_book) {
            Toast.makeText(this, "menu book", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id==R.id.extraoptions_menu_group) {
            Toast.makeText(this, " group", Toast.LENGTH_SHORT).show();
            return true;
        }else if(id==R.id.extraoptions_menu_camera2) {
            Toast.makeText(this, "inside camera", Toast.LENGTH_SHORT).show();
            return true;
        }else if(id==R.id.extraoptions_menu_search) {
            Toast.makeText(this, "outside search", Toast.LENGTH_SHORT).show();
            return true;
        }else if(id==R.id.extraoptions_menu_search2) {
            Toast.makeText(this, "inside search", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id==R.id.extraoptions_menu_settings) {
            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
            return true;
        }


        else return super.onOptionsItemSelected(item);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_extra_options_and_menu_in_tool_bar);


    }
}