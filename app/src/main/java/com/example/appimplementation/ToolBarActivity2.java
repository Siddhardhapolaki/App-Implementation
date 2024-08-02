package com.example.appimplementation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ToolBarActivity2 extends AppCompatActivity {
    int noOfTomesButtonClicked=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar2);

        Button disableandenabletoolbarButton;



        disableandenabletoolbarButton=findViewById(R.id.disableandenabetoolbarbutton);






        disableandenabletoolbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(noOfTomesButtonClicked%2==0) {
                    getSupportActionBar().hide();
                    disableandenabletoolbarButton.setText("click to see tool bar");
                    noOfTomesButtonClicked++;
                }else {
                    getSupportActionBar().show();
                    disableandenabletoolbarButton.setText("click to hide tool bar");
                    noOfTomesButtonClicked+=1;
                }


            }
        });
        }
    }
