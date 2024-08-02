package com.example.appimplementation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ToolBarActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tool_bar1);


        Button toolbarenableAndDisablethrougjava;
        Button toolbarcreteddirectlyinxml;



        toolbarenableAndDisablethrougjava = findViewById(R.id.gototoolbaractivity);
         toolbarcreteddirectlyinxml=findViewById(R.id.toolbarcreteddirectlyinxml);

        /* themes
         default button colors and shapes all are decided by the applied themes

         */




        /*  Toolbar
         to unable and disable toolbar
         process 1: to disable
             Theme.MaterialComponents.DayNight.DarkActionBar make this as the Theme.MaterialComponents.DayNight.NoActionBar
                     but it makes all activities in the app to disable the toolbar
         process 2:  to diable but from specified activity
             add a new style theme in themes and set that style to specified activity in manifest in that activity
                  here there is problem here that in process 1 we created custom toolbar and applied in its layout using "include" so in this same activity there will no change to
                  this activity so to see the change we see in another activity or remove the include in this activity
          process 3: enble and disbale using java
                   so to this i creating a new activity to see changes on click buttons
         */






        //to create a custom toolbar we have some methods/processes
        /*
        process 1:
           1.make a layout of tool bar in layout folder .
           2.include that created toobar activity in this page activity
           3.in this java activity write find view by ID
           4.still we get the normal tool bar because in themes there is default toolabar which is in active
           5.to make that default tool bar disable make that reference of toolbar to NoActionBar from DarkActionBar in main theme style
               but here problem with 5 th step is when we changed in main themem it applied to all activities that all activities get NoActionBar
               to rectify that make a new style in themes and apply that style to specified activity in manifest
               so make main theme to DarkActionBar and create a new style theme NoActionBar and apply to this activty
               so every activity in this app get tool bar but not to this specified activity
               but now every activity except this activity got default tool bar even now our created custom toolbar layout also got a tool bar

         process 2:
             1.in above we created tool bar as separete layout and applied to activity in that xml file
             2.here we we will directly create toolbar as view in xml file (no separte layout)

           NOTE:
            in procees 1 we created in separete layout and included in this page xml
            iin process 2 we directly created toolbar in xml (both are same)
         */



        toolbarenableAndDisablethrougjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToolBarActivity1.this,ToolBarActivity2.class));
            }
        });


        toolbarcreteddirectlyinxml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToolBarActivity1.this,ToolBarActivityUsingXml.class));

            }
        });




    }
}