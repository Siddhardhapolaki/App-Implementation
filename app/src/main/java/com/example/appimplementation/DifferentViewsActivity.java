package com.example.appimplementation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class DifferentViewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different_views);


        //initilizations
        TextView checkboxtxtview,tooglebuttontxtview,spinnertxtview;
        ToggleButton togglebuttonview;
        CheckBox checkboxview;
        Spinner spinnerviewusingjava,spinnerviewusingxml;

        checkboxtxtview=findViewById(R.id.checkboxtxtview);
        tooglebuttontxtview=findViewById(R.id.toggleviewtxtview);
        togglebuttonview=findViewById(R.id.toggleButtonview);
        checkboxview=findViewById(R.id.checkboxview);
        spinnerviewusingjava=findViewById(R.id.spinnerviewusingjava);
        spinnerviewusingxml=findViewById(R.id.spinnerviewusingxml);
        spinnertxtview=findViewById(R.id.spinnertxtview);


        String data[]={"data1","data2","data3","data4","data5"};

        //implentations

        checkboxview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkboxview.isChecked()){
                    checkboxtxtview.setText("selected");
                }else{
                    checkboxtxtview.setText(" un selected");

                }
            }
        });


        togglebuttonview.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //on is considered as positive button and another as negative button
                if(isChecked)
                {
                    tooglebuttontxtview.setText("is checked");
                }else {
                    tooglebuttontxtview.setText("is un checked");

                }
            }
        });


        //implementation of spinner view it have 2 methods --
        //1.using data from resources in string values folder and using entries attribute in xml(using xml)
        //2.using data from a array(using java) we use adapter for this

        //using java
        ArrayAdapter<String> ad1=new ArrayAdapter(this, android.R.layout.simple_spinner_item,data);
        ad1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerviewusingjava.setAdapter(ad1);

      spinnerviewusingjava.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                       spinnertxtview.setText(data[position]+"  using java");
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {
                    spinnertxtview.setText("Nothing Selected");
          }
      });

      //using xml
      ArrayAdapter<CharSequence> ad2=ArrayAdapter.createFromResource(this, R.array.titles, android.R.layout.simple_spinner_item);
      ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      spinnerviewusingxml.setAdapter(ad2);
        spinnerviewusingxml.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 spinnertxtview.setText((CharSequence) parent.getItemAtPosition(position));


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnertxtview.setText("Nothing Selected");
            }
        });


    }
}