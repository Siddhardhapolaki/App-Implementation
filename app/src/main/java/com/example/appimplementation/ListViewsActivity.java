package com.example.appimplementation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListViewsActivity extends AppCompatActivity {

    //initilaization of textvieww


    static int FLAGG = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_views);

        //initilizations

        Button normallistviewbut,customimgtextviewlistviewbut,customimgand2textListviewbutton;
        Button customlistview150optbutton,customlistview175optbutton,customlistviewwithbaseadapter;
        ListView listview;
        TextView selecteditemshowntxtview;

        normallistviewbut=findViewById(R.id.NormalListviewbutton);
        listview=findViewById(R.id.listview);
        selecteditemshowntxtview=findViewById(R.id.selecteditemshowntxtview);
        customimgtextviewlistviewbut=findViewById(R.id.customimgandtextListviewbutton);
        customimgand2textListviewbutton=findViewById(R.id.customimgand2textListviewbutton);
        customlistview150optbutton=findViewById(R.id.customlistview150optbutton);
        customlistview175optbutton=findViewById(R.id.customlistview175optbutton);
        customlistviewwithbaseadapter=findViewById(R.id.customlistviewwithbaseadapter);
        //extra

        String data1[]= {"title 1", "title 2", "title 3", "title 4", "title 5", "title 6", "title 7", "title 8", "title 9", "title 10", "title 11", "title 12", "title 13", "title 14", "title 15"};
        //implementations

        normallistviewbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // listview.setVisibility(View.VISIBLE);
                ArrayAdapter adapter1 = new ArrayAdapter(ListViewsActivity.this, android.R.layout.simple_list_item_1,data1); // here it is default layout,
                listview.setAdapter(adapter1);
                 FLAGG =0;
            }
        });

        //onitemclicklistner

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView temptxtview;
                if(FLAGG==0)
                 temptxtview = (TextView) view;
                else if(FLAGG==1)
                    temptxtview = (TextView) view.findViewById(R.id.txt1incustomlistview);
                else
                    temptxtview = (TextView) view.findViewById(R.id.txt2incustomlistview);

                selecteditemshowntxtview.setText(temptxtview.getText());
            }
        });


        customimgtextviewlistviewbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayAdapter adapter3=new ArrayAdapter<>(ListViewsActivity.this,R.layout.custom_listview_with_imgandtextview,R.id.txt1incustomlistview,data1 );
                listview.setAdapter(adapter3);
                FLAGG =1;
            }


        });

        customimgand2textListviewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res =getResources();
                String[] Titles=res.getStringArray(R.array.titles);
                String[] Descriptions=res.getStringArray(R.array.descriptions);
                int[] images={R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage};
                cusadapter1 adapter4=new cusadapter1(ListViewsActivity.this,Titles,images,Descriptions);
                listview.setAdapter(adapter4);
                FLAGG =2;
            }
        });

        customlistview150optbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res =getResources();
                String[] Titles=res.getStringArray(R.array.titles);
                String[] Descriptions=res.getStringArray(R.array.descriptions);
                int[] images={R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage};
                cusadapter2 adapter5=new cusadapter2(ListViewsActivity.this,Titles,images,Descriptions);
                listview.setAdapter(adapter5);
                FLAGG =2;
            }
        });

        customlistview175optbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res =getResources();
                String[] Titles=res.getStringArray(R.array.titles);
                String[] Descriptions=res.getStringArray(R.array.descriptions);
                int[] images={R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage};
                cusadapter3 adapter6=new cusadapter3(ListViewsActivity.this,Titles,images,Descriptions);
                listview.setAdapter(adapter6);
                FLAGG =2;
            }
        });

        customlistviewwithbaseadapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<SingleRowData> list =new  ArrayList<SingleRowData>();

                Resources res =getResources();
                String[] Titles=res.getStringArray(R.array.titles);
                String[] Descriptions=res.getStringArray(R.array.descriptions);
                int[] images={R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage,R.drawable.ironman,R.drawable.ic_launcher_background,R.drawable.mysqlimage};
                for(int i=0;i<Titles.length;i++){
                    list.add(new SingleRowData(Titles[i],Descriptions[i],images[i]));
                }
                listview.setAdapter(new CustomBaseAdapter(ListViewsActivity.this,list));
                FLAGG=2;
            }
        });
    }

    class cusadapter1 extends ArrayAdapter<String>
    {
         Context context;
         int[] imgs;
         String []titlesarray;
         String[] desc;
       TextView showinglogtxtview;

        public cusadapter1(@NonNull Context context, @NonNull String[] titles,@NonNull int[] imgs,@NonNull String[] desc) {
            super(context,R.layout.custom_listview_withimgand2textviews,R.id.txt2incustomlistview,titles);
            this.context=context;
            this.imgs=imgs;
            this.titlesarray=titles;
            this.desc=desc;
            showinglogtxtview=findViewById(R.id.showinglogtxtview);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflator=getLayoutInflater();
             String text="position:"+position+"\nrow created everytime";

            View eachrow=inflator.inflate(R.layout.custom_listview_withimgand2textviews,parent,false);  // or  inflate(R.layout.custom_listview_withimgand2textviews,null);   are same
            ImageView myimg=eachrow.findViewById(R.id.img2incustom);
            TextView mytitle=eachrow.findViewById(R.id.txt2incustomlistview);
            TextView myDescripton=eachrow.findViewById(R.id.txt3incustomlistview);

            myimg.setImageResource(imgs[position]);
            mytitle.setText(titlesarray[position]);
            myDescripton.setText(desc[position]);
            showinglogtxtview.setText(text);

            return eachrow;

        }
    }
    class cusadapter2 extends ArrayAdapter<String>
    {
        Context context;
        int[] imgs;
        String []titlesarray;
        String[] desc;
        TextView showinglogtxtview;

        public cusadapter2(@NonNull Context context, @NonNull String[] titles,@NonNull int[] imgs,@NonNull String[] desc) {
            super(context,R.layout.custom_listview_withimgand2textviews,R.id.txt2incustomlistview,titles);
            this.context=context;
            this.imgs=imgs;
            this.titlesarray=titles;
            this.desc=desc;
            showinglogtxtview=findViewById(R.id.showinglogtxtview);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View eachrow=convertView;
            String text=null;
            if(eachrow==null) {
                LayoutInflater inflator = getLayoutInflater();
                eachrow = inflator.inflate(R.layout.custom_listview_withimgand2textviews,parent,false);  // or  inflate(R.layout.custom_listview_withimgand2textviews,null);   are same
                text="position:"+position+"\n firsttime row created";

            }
            ImageView myimg=eachrow.findViewById(R.id.img2incustom);
            TextView mytitle=eachrow.findViewById(R.id.txt2incustomlistview);
            TextView myDescripton=eachrow.findViewById(R.id.txt3incustomlistview);
            text="position:"+position+"\n recycled row used";
            myimg.setImageResource(imgs[position]);
            mytitle.setText(titlesarray[position]);
            myDescripton.setText(desc[position]);
            showinglogtxtview.setText(text);
            return eachrow;

        }
    }

    class cusadapter3 extends ArrayAdapter<String>
    {
        Context context;
        int[] imgs;
        String []titlesarray;
        String[] desc;
        //initilaization of textvieww
        TextView showinglogtxtview;
        public cusadapter3(@NonNull Context context, @NonNull String[] titles,@NonNull int[] imgs,@NonNull String[] desc) {
            super(context,R.layout.custom_listview_withimgand2textviews,R.id.txt2incustomlistview,titles);
            this.context=context;
            this.imgs=imgs;
            this.titlesarray=titles;
            this.desc=desc;
            showinglogtxtview=findViewById(R.id.showinglogtxtview);


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View eachrow=convertView;
            MyViewHolder holder=null;
            String text=null;
            if(eachrow==null) {
                LayoutInflater inflator = getLayoutInflater();
                eachrow = inflator.inflate(R.layout.custom_listview_withimgand2textviews,parent,false);  // or  inflate(R.layout.custom_listview_withimgand2textviews,null);   are same
                holder = new MyViewHolder(eachrow);
                eachrow.setTag(holder);
               text="position:"+position+"\n firsttime row created";

            }else {
                holder = (MyViewHolder) eachrow.getTag();
                 text="position:"+position+"\n recycled row used";
            }
                holder.myimg.setImageResource(imgs[position]);
                holder.mytitle.setText(titlesarray[position]);
                holder.mydescripton.setText(desc[position]);
                showinglogtxtview.setText(text);
                return eachrow;



        }
    }
    class MyViewHolder{
        public ImageView myimg;
        public TextView mytitle;
        public  TextView mydescripton;

        MyViewHolder(View v)
        {
             myimg = v.findViewById(R.id.img2incustom);
             mytitle = v.findViewById(R.id.txt2incustomlistview);
            mydescripton = v.findViewById(R.id.txt3incustomlistview);
        }
    }

    class CustomBaseAdapter extends BaseAdapter
    {
         ArrayList<SingleRowData> list;
         Context context;
        TextView showinglogtxtview;
        CustomBaseAdapter(Context context,ArrayList<SingleRowData> list)
        {
             this.list=list;
             this.context=context;
            showinglogtxtview=findViewById(R.id.showinglogtxtview);
        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflator=getLayoutInflater();
            String text="position:"+position+"\nrow created everytime";

            View eachrow=inflator.inflate(R.layout.custom_listview_withimgand2textviews,parent,false);  // or  inflate(R.layout.custom_listview_withimgand2textviews,null);   are same
            ImageView myimg=eachrow.findViewById(R.id.img2incustom);
            TextView mytitle=eachrow.findViewById(R.id.txt2incustomlistview);
            TextView myDescripton=eachrow.findViewById(R.id.txt3incustomlistview);
             SingleRowData temp=list.get(position);
            myimg.setImageResource(temp.img);
            mytitle.setText(temp.title);
            myDescripton.setText(temp.desc);
            showinglogtxtview.setText(text);
            return eachrow;
        }
    }

    class SingleRowData
    {
        String title;
        String desc;
        int img;
        SingleRowData(String title,String desc,int img){
            this.img=img;
            this.title=title;
            this.desc=desc;
        }
    }
}