package com.example.appimplementation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StorageActivity2 extends AppCompatActivity {


    EditText savetofileedit2,keytoretrivevalue;
    TextView fromfiletxt2;
    Context context;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_storage2);
          context=this;
        Button tosharedpreference,fromsharedpreference;
        Button tosqlite,fromsqllite,updatesqlite;
        Button senddatatoOnlineDB,getDatafromOnlineDB;



        savetofileedit2=findViewById(R.id.SaveToFileId2);
        keytoretrivevalue=findViewById(R.id.enterkeytoretrive);
        fromfiletxt2=findViewById(R.id.DataFromFileTxtId2);
        tosharedpreference=findViewById(R.id.tosharedPreferences);
        fromsharedpreference=findViewById(R.id.fromsharedpreferences);
        tosqlite=findViewById(R.id.tosqlitebutton);
        fromsqllite=findViewById(R.id.fromsqlitebutton);
        updatesqlite=findViewById(R.id.updatesqliteButton);
        senddatatoOnlineDB=findViewById(R.id.sendtoOnlineDbButton);
        getDatafromOnlineDB=findViewById(R.id.getfromOnlineDbButton);



        //implementation

        tosharedpreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=savetofileedit2.getText().toString();
                saveToSharedPreference(str);
            }
        });


        fromsharedpreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataFromSharedPreference();
            }
        });



        tosqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                      sendDataToSqlite();
            }
        });

        fromsqllite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retriveDataFromSqlite();
            }
        });

        updatesqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });


        senddatatoOnlineDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   addtoOnline();


            }
        });

        getDatafromOnlineDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          getFromOnline();

            }
        });

    }

    /*
       shared preferences :

       stores boolens,floats,ints,strings,app settings etc here
       stores as kwy value pairs

       if we have only one preference file - access  file by getPreferences(int mode)
       if we have several files use-  getSharedPreferences(String name,int mode)

       mode:
       1. MODE_PRIVATE:only app can access it
       2. MODE_WORLD_READABLE: any app can read the file
       3. MODE_WORLD_WRITEABLE: any app can write to the file
       4. MODE_MULTI_PROCESS: multiple process can modify the same shared preference file
        */
    public void saveToSharedPreference(String str)
    {

        SharedPreferences shaPre=getSharedPreferences("my preference file",MODE_PRIVATE);
        SharedPreferences.Editor editor=shaPre.edit();
        String arr[]=str.split(":");
        editor.putString(arr[0],arr[1]);
        editor.commit();

        Toast.makeText(this,"data sent",Toast.LENGTH_SHORT).show();
    }

    public void dataFromSharedPreference()
    {

        SharedPreferences shaPreference=getSharedPreferences("my preference file",MODE_PRIVATE);

        String r=keytoretrivevalue.getText().toString();
        String res= shaPreference.getString(r,"DEFAULT");
        if(res.equals("DEFAULT"))
        {
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        }
    else {
        fromfiletxt2.setText(res);
            Toast.makeText(this, "data retrived", Toast.LENGTH_SHORT).show();
        }

    }

/*
sqlite is present in user device

 */
MySqliteDbClass mysqlite;
    public void sendDataToSqlite()
    {

        String st=savetofileedit2.getText().toString();
        String arr1[]=st.split(",");
         mysqlite=new MySqliteDbClass(this);//it is object of physical db in our device
        //to make other properties and lifecycle to work  use getWritableDatabase()

       SQLiteDatabase sqliteDb= mysqlite.getWritableDatabase();//now lifecycles will starts work
        long rows=mysqlite.insertUserData(arr1[0],arr1[1],arr1[2]);
        if(rows>=1)
        {
            Toast.makeText(this," "+rows+"effected",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this," No rows effected,unsuccessful",Toast.LENGTH_SHORT).show();

    }

    public  void retriveDataFromSqlite()
    {
        String value=keytoretrivevalue.getText().toString();
        /*
        method 1:
        String query="select name from tablename"
        Cursor cursor=db.rawQuery(query,String[] selectionArgs)
        we can add ? ? marks in query string and can give values to that query in selectionArgs)

        method 2:
         Cursor query(String table,String[] columns,string selection,String[] selectionArgs,String groupBy,String having,String orderBy)
         table: table name
         columns:list of columns to process
         remaining all :used to satisfy all other conditions
         */


         StringBuffer buff=mysqlite.getUserData(value);
         fromfiletxt2.setText(buff);

    }


    public void updateData()
    {
        String value=keytoretrivevalue.getText().toString();
        String[] data=value.split(":");

        long rows=mysqlite.updateUserData(data[0],data[1]);
        if(rows>=1)
        {
            Toast.makeText(this," "+rows+"effected",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this," No rows effected,unsuccessful",Toast.LENGTH_SHORT).show();


    }


    //online db
    OnlineDataBase database;
    public void addtoOnline()
    {
        String s2=savetofileedit2.getText().toString();
        String arr3[]=s2.split(",");
         database=new OnlineDataBase(context);

        long rows=database.addDataToDataBase(arr3[0],arr3[1],arr3[2],arr3[3]);
        if(rows>=1)
        {
            Toast.makeText(this," "+rows+"effected,successful",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this," No rows effected,unsuccessful",Toast.LENGTH_SHORT).show();

    }

    public void getFromOnline()
    {
        String name=keytoretrivevalue.getText().toString();
        database=new OnlineDataBase(context);
        StringBuffer buffer=database.getFromOnlineDataBase(name);
        fromfiletxt2.setText(buffer);


    }
}