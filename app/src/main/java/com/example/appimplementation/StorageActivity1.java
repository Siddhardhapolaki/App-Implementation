package com.example.appimplementation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StorageActivity1 extends AppCompatActivity {

    EditText savetofileedit1;
    TextView fromfiletxt1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_storage1);

        Button morestorageoptionsbutton;
        Button internalprivate,frominternalprivate;
        Button internalcache,frominternalcache;
        Button externalcache,fromexternalcache;
        Button externalprivate,fromexternalprivate;
        Button externalpublic,fromexternalpublic;


        savetofileedit1=findViewById(R.id.SaveToFileId1);
        fromfiletxt1=findViewById(R.id.DataFromFileTxtId1);
        morestorageoptionsbutton=findViewById(R.id.more_options);
        internalprivate=findViewById(R.id.internal_privateButton);
        frominternalprivate=findViewById(R.id.frominternalprivateButton);
        internalcache=findViewById(R.id.internalcacheButton);
        frominternalcache=findViewById(R.id.frominternalcacheButton);
        externalcache=findViewById(R.id.externalcacheButton);
        fromexternalcache=findViewById(R.id.fromexternalcacheButton);
        externalprivate=findViewById(R.id.externalprivateButton);
        fromexternalprivate=findViewById(R.id.fromexternalprivateButton);
        externalpublic=findViewById(R.id.externalpublicButton);
        fromexternalpublic=findViewById(R.id.fromexternalpublicButton);








        //implementation
       morestorageoptionsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StorageActivity1.this,StorageActivity2.class));
            }
        });

       internalprivate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               String data=savetofileedit1.getText().toString();

               FileOutputStream fileoutput=null;
               File filelocation=null;
               try {
                     filelocation=getFilesDir();
                   fileoutput=openFileOutput("internal private file.txt",MODE_PRIVATE);
                   fileoutput.write(data.getBytes());
               }catch (FileNotFoundException e)
               {
                   Toast.makeText(StorageActivity1.this,"file not found ",Toast.LENGTH_SHORT).show();
               }
               catch (IOException e)
               {
                   Toast.makeText(StorageActivity1.this,"IO exception ",Toast.LENGTH_SHORT).show();
               }
               finally{
                   try {
                       fileoutput.close();
                   }catch(IOException e)
                   {
                       Toast.makeText(StorageActivity1.this,"IO exception while closing",Toast.LENGTH_SHORT).show();
                   }
               }
               Toast.makeText(StorageActivity1.this,"data saved at"+filelocation+" ",Toast.LENGTH_SHORT).show();
           }
       });

       frominternalprivate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               FileInputStream fileinput=null;
               try {

                   fileinput=openFileInput("internal private file.txt");
                   int read=-1;
                   StringBuffer buffer=new StringBuffer();
                   while((read=fileinput.read())!=-1)
                   {
                       buffer.append((char)read);
                   }
                   fromfiletxt1.setText(buffer);

               }catch (FileNotFoundException e)
               {
                   Toast.makeText(StorageActivity1.this,"file not found ",Toast.LENGTH_SHORT).show();
               }
               catch (IOException e)
               {
                   Toast.makeText(StorageActivity1.this,"IO exception ",Toast.LENGTH_SHORT).show();
               }
               finally{
                   try {
                       fileinput.close();
                   }catch(IOException e)
                   {
                       Toast.makeText(StorageActivity1.this,"IO exception while closing",Toast.LENGTH_SHORT).show();
                   }
               }
               Toast.makeText(StorageActivity1.this,"retrived data ",Toast.LENGTH_SHORT).show();

           }
       });


       internalcache.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               File folder =getCacheDir();
               File myFile=new File(folder,"internal cache file.txt");
               saveToFile(myFile);
           }
       });

      frominternalcache.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              File folder=getCacheDir();
              File myFile=new File(folder,"internal cache file.txt");
              dataFromFile(myFile);
          }
      });


      externalcache.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              File folder =getExternalCacheDir();
              File myFile=new File(folder,"external cache file.txt");
              saveToFile(myFile);
          }
      });

     fromexternalcache.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             File folder=getExternalCacheDir();
             File myFile=new File(folder,"external cache file.txt");
             dataFromFile(myFile);
         }
     });


     externalprivate.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             File folder =getExternalFilesDir("external folder");
             File myFile=new File(folder,"external private file.txt");
             saveToFile(myFile);
         }
     });

     fromexternalprivate.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             File folder =getExternalFilesDir("external folder");
             File myFile=new File(folder,"external private file.txt");
             dataFromFile(myFile);
         }
     });


     externalpublic.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
             File myFile=new File(folder,"external public file.txt");
             saveToFile(myFile);
         }
     });

     fromexternalpublic.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
             File myFile=new File(folder,"external public file.txt");
             dataFromFile(myFile);

         }
     });
    }


    /*MODE_PRIVATE:cannot read by other apps
          MODE_APPEND: keep appending data to the existing contents

          openFileOutput(filename,mode):used to write data in file
                  openFileInput(filename):used to read data in file


          */

    /*
    we strore data in file in bytes
     */


    /*
    for to write in external storeage
    1.add permission in manifest:WRITE_EXTERNAL_STORAGE
    2.check external storage to see if it MOUNTED,READ_ONLY,or failure using getExternalStorageState()
    3.get files directory by calling
     {

     getExternalStorageFilesDir(string type)
     getExternalStoragepublicDirectory(String type)
     getExternalStorageDirectory()
     getExternalCacheDirectory()
     }
     */
    public void saveToFile(File myFile)
    {

        String data=savetofileedit1.getText().toString();

        FileOutputStream fileoutput=null;
        try {

        fileoutput=new FileOutputStream(myFile);
            fileoutput.write(data.getBytes());
        }catch (FileNotFoundException e)
        {
            Toast.makeText(this,"file not found ",Toast.LENGTH_SHORT).show();
        }
        catch (IOException e)
        {
            Toast.makeText(this,"IO exception ",Toast.LENGTH_SHORT).show();
        }
        finally{
            try {
                fileoutput.close();
            }catch(IOException e)
            {
                Toast.makeText(this,"IO exception while closing",Toast.LENGTH_SHORT).show();
            }
        }
        Toast.makeText(this,"data saved at"+myFile+" ",Toast.LENGTH_SHORT).show();
    }



    /*
    data in file is in bytes,retrive it
     */
    public void dataFromFile(File myFile)
    {
        FileInputStream fileinput=null;
        try {

            fileinput=new FileInputStream(myFile);
            int read=-1;
            StringBuffer buffer=new StringBuffer();
            while((read=fileinput.read())!=-1)
            {
            buffer.append((char)read);
            }
            if(buffer!=null)
            fromfiletxt1.setText(buffer);
            else
                Toast.makeText(this,"No data ",Toast.LENGTH_SHORT).show();

        }catch (FileNotFoundException e)
        {
            Toast.makeText(this,"file not found ",Toast.LENGTH_SHORT).show();
        }
        catch (IOException e)
        {
            Toast.makeText(this,"IO exception ",Toast.LENGTH_SHORT).show();
        }
        finally{
            try {
                fileinput.close();
            }catch(IOException e)
            {
                Toast.makeText(this,"IO exception while closing",Toast.LENGTH_SHORT).show();
            }
        }
        Toast.makeText(this,"retrived data ",Toast.LENGTH_SHORT).show();

    }
}