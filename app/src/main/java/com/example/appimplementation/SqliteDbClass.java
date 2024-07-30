package com.example.appimplementation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class MySqliteDbClass extends SQLiteOpenHelper {

    private static  SQLiteDatabase DATABASE_Reference;
    private static final String DATABASE_NAME="myDataBase";
    private static final String TABLE_NAME="myDBTable";
    private static final int DATABASE_VERSION=1;
    private static final String UID="id";
    private static final String NAME="Name";
    private static final String Grade="grade";
    private static final String Age="age";
    private static  final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+Age+" VARCHAR(255),"+Grade+" VARCHAR(255))";
    private static  final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;
    public Context context;

    //public SqliteDbClass(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
    public MySqliteDbClass(Context context) {

    // super(context, name, factory, version);
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
        Toast.makeText(context,"constructor called",Toast.LENGTH_SHORT).show();

    }


    /*
    oncreate :called when db created first time
    onupgrade:called when db need to upgrade,use to add table,drop table,for this and etc we need to upgrade version
    Db name should be unique
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Toast.makeText(context,"oncreate called",Toast.LENGTH_SHORT).show();
       DATABASE_Reference=db;
        //create table
        try {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context,"table created",Toast.LENGTH_SHORT).show();

        }catch(SQLException sql){
            Toast.makeText(context,"SQLException occured",Toast.LENGTH_SHORT).show();
        }
        }

/*
 when version is changed automatically onupgrade method will called  so
 from implementation from onipgrade method our table droped

 if we want to add a new column like address
 first write query for table creation it must have that address column also
 then change version so onUpgrade method called here we drop taht previous table
 we need to call on create methid again from onUpgrade method to create table for second time to add address column
 */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context,"upgrade called",Toast.LENGTH_SHORT).show();
        try{
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (SQLException sql)
        {
            Toast.makeText(context,"SQLException occured",Toast.LENGTH_SHORT).show();

        }


    }

    public long insertUserData(String name,String age, String grade)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(MySqliteDbClass.NAME,name);
        contentValues.put(MySqliteDbClass.Age,age);
        contentValues.put(MySqliteDbClass.Grade,grade);

        //from above it adds data in contentvalues
        //to add it in data base use insert method


        /*
        we stored the db object in DATABASE_Reference above
        we can also get directly here by

          MySqliteDbClass helper=new MySqliteDbClass(context)
          SQLiteDatabase db=helper.getWritableDatabase()
         */
        long rows=DATABASE_Reference.insert(MySqliteDbClass.TABLE_NAME,null,contentValues);
//2nd parameter in insert method is nullcolumnhack ,it used to specify the name of any 1 column in your table that can be null
        return rows;
    }

    public StringBuffer getUserData(String value)
    {
        //select Name,age,grade from table
        String[] columns={MySqliteDbClass.NAME,MySqliteDbClass.Age,MySqliteDbClass.Grade};
        Cursor cursor=DATABASE_Reference.query(MySqliteDbClass.TABLE_NAME,columns,MySqliteDbClass.NAME+"="+value,null,null,null,null);

        String name,Age,grade;
        StringBuffer buffer=new StringBuffer();
        while(cursor.moveToNext())
        {
             name=cursor.getString(1);
             Age=cursor.getString(2);
            grade=cursor.getString(3);
            buffer.append("name:"+name+"age:"+Age+"grade:"+grade+"\n ");

        }
        return buffer;
    }



    public long updateUserData(String name,String age)
    {
        /*
     update(String table,Contentvalues values,String whereclause,String[] whereArgs)
     table: table name
     values: stored vales used to change data
     whereclause: string where it contain where statement
     whereArgs: we can write ? in whereclause and we can give values to  ?  here
         */
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(MySqliteDbClass.Age,age);
        String [] whereArgs={name};

        long rows=DATABASE_Reference.update(MySqliteDbClass.TABLE_NAME,contentvalues,MySqliteDbClass.NAME+"=?",whereArgs);

        return rows;
    }
}
