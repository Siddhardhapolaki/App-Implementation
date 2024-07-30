package com.example.appimplementation;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NormalListViewUsingListActivityClass extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_list_view_using_list_class);
        String data2[]= {"title 1", "title 2", "title 3", "title 4", "title 5", "title 6", "title 7", "title 8", "title 9", "title 10", "title 11", "title 12", "title 13", "title 14", "title 15"};
         ListView l=getListView();
        ArrayAdapter adapter2=new ArrayAdapter(this, android.R.layout.simple_list_item_1,data2);
        l.setAdapter(adapter2);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        TextView txtview=(TextView)v;
        Toast.makeText(this,txtview.getText(),Toast.LENGTH_SHORT);
    }
}