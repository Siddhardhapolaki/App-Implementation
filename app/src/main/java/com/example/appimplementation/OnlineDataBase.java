package com.example.appimplementation;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class OnlineDataBase {
    Connection con;
    Context context;

    public OnlineDataBase(Context context) {
        this.context=context;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://ip_address:3306/First_data_base", "root", "password");
        }catch (SQLException sql)
        {
            Log.d("1st exception", sql.getMessage());
            Toast.makeText(context, "sql exception exception,no connection established due to no ipadress"+sql, Toast.LENGTH_SHORT).show();

        } catch (ClassNotFoundException ex) {
            Toast.makeText(context, "class not found exception", Toast.LENGTH_SHORT).show();
        }
    }

    public long addDataToDataBase(String id,String name,String age,String course)
    {

        long rows = 0;
          try{
            PreparedStatement stm=con.prepareStatement("insert into table1 values(?,?,?,?)");


                stm.setInt(1, Integer.parseInt(id));
                stm.setString(2,name);
                stm.setInt(3,Integer.parseInt(age));
                stm.setString(4,course);

                 rows=stm.executeUpdate();
                 return rows;
               
            } catch (SQLException ex) {
            Toast.makeText(context, "sql exception", Toast.LENGTH_SHORT).show();

        }catch(Exception e){
              Log.d("2nd exception", e.getMessage());
            Toast.makeText(context, " exception"+e, Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                if(con !=null)
                 con.close();
            } catch (SQLException e) {
                Toast.makeText(context, "sql exception while closing", Toast.LENGTH_SHORT).show();
            }
        }

         return rows;
    }



    public StringBuffer getFromOnlineDataBase(String name)
    {
        StringBuffer buff=null;
     try{
         PreparedStatement state=con.prepareStatement("select ? from table1");
         state.setString(1,name);
         ResultSet rs=state.executeQuery();
          buff=new StringBuffer();
         while(rs.next())
         {
             buff.append(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+"\n");
         }
         if(con != null)
           con.close();
     } catch(SQLException sql)
     {
         Toast.makeText(context, "sql exception while closing", Toast.LENGTH_SHORT).show();

     } catch(Exception e)
     {
         Toast.makeText(context, "Exception occured", Toast.LENGTH_SHORT).show();

     }
         return buff;
    }
    }

