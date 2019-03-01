package com.example.sqlitetoroom.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.sqlitetoroom.Employe;


import java.util.ArrayList;

public class EmployeDatabase extends SQLiteOpenHelper
{
    private static String DATABASE_NAME = "EMPLOYE";
   public static  int DATABASE_VERSION =1;


    private String employe = "Employe";
    private Context context;



    private String table = employe + "( id INTEGER PRIMARY KEY NOT NULL , name TEXT )";


    public EmployeDatabase(Context context)
    { super(context, DATABASE_NAME, null, DATABASE_VERSION);

    this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
      db.execSQL("CREATE TABLE IF NOT EXISTS "+ table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {






        Log.e("Onupgrad","sdkj");
        ArrayList<Employe> list = new ArrayList<>();



            Cursor c = db.query(employe,null,null,null,null,null,null);


            if( c!=null && c.getCount()>0)
            {

                while (c.moveToNext())
                {




                    String name= c.getString(c.getColumnIndex("e_name"));

                    list.add(new Employe((int)(System.currentTimeMillis()),name));


                }

            }


            if(list!=null)
            {

                for(Employe e:list)
                {
                    final Employe e1 = e;
                    class A extends AsyncTask<Void,Void,Void>
                    {



                        @Override
                        protected Void doInBackground(Void... voids) {

                            //EmployeHelper.getInstance(context).databaseNew.EmployeDao().insert(e1);
                            return null;
                        }
                    }

                   new A().execute();

                    //Save value to databaseNew
                }
            }





            //Mark:-

            db.execSQL("DROP TABLE IF EXISTS "+ employe);

            context.deleteDatabase(DATABASE_NAME);



    }



    public void insert( Employe e)
    {


        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name",e.getName());


            database.insert(employe,"name",contentValues);





    }
}
