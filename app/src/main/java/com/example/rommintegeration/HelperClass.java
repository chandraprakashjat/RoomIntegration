package com.example.rommintegeration;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.rommintegeration.database_entity.Student;
import com.example.rommintegeration.room_database.DatabaseClass;

import java.util.List;


public class HelperClass
{

    public DatabaseClass databaseClass;

    public  static  HelperClass instance;

    public static HelperClass getInstance(Context context)
    {
      if(instance == null)
      {
       instance = new HelperClass(context);
      }

      return instance;
    }

    public HelperClass(Context context)
    {
        //instance of ROOM
//     databaseClass = Room.databaseBuilder(context,
//             DatabaseClass.class,"Database.db")
//             .fallbackToDestructiveMigration()
//             .build();

        databaseClass = Room.databaseBuilder(context,
                DatabaseClass.class,"Database.db")
                .addMigrations(migration1_2,migration2_3,migration3_4,migration4_5,migration5_6,migration6_7,migration7_8,migration8_9,migration9_10)
                .build();


    }






    Migration  migration1_2 = new Migration(1,2) {  //Add column
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database)
        {
           database.execSQL("ALTER TABLE Student ADD COLUMN detail TEXT");
        }
    };


    Migration  migration2_3 = new Migration(2,3) {  //Add two column
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database)
        {
            database.execSQL("ALTER TABLE Student ADD COLUMN add1 TEXT");
            database.execSQL("ALTER TABLE Student ADD COLUMN add2 TEXT");
        }
    };




    Migration  migration3_4 = new Migration(3,4) {   //Rename table
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database)
        {
            database.execSQL("ALTER TABLE Student RENAME TO S ");
        }
    };



    //remove precolumn from table
    Migration  migration4_5 = new Migration(4,5) {  //Remove column
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database)
        {


            //  Step:- 1 create new table =

            String table = "TestNew "+"( user_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, user_name TEXT, user_phone TEXT )";

            database.execSQL(" CREATE TABLE "+table );


            // Step :- 2take previous record copy

            database.execSQL("INSERT INTO TestNew "+ "(user_id,user_name,user_phone) "+"SELECT"+" user_id,user_name,user_phone "+ "FROM "+"S");


            //Step :- 3drop previous table


            database.execSQL("DROP TABLE IF EXISTS"+" S ");



            //Step :-4 RENAME TABLE AGAIN

            database.execSQL("ALTER TABLE TestNew RENAME TO S");
        }
    };



    Migration migration5_6 = new Migration(5,6) {    //Add column
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database)
        {


            database.execSQL("ALTER TABLE S ADD COLUMN country_name TEXT");

        }
    };

    Migration migration6_7 = new Migration(6,7) {     //Rename table
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {


            database.execSQL("ALTER TABLE S RENAME TO S1");
        }
    };


    Migration migration7_8 = new Migration(7,8) {  //Remove column from table
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database)
        {

            //Create Table

            String test = "Demo ( user_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, user_name TEXT )";

            database.execSQL("CREATE TABLE "+test);


            //copy

            database.execSQL("INSERT INTO Demo (user_id,user_name) SELECT user_id,user_name From S1");


            //DROP

            database.execSQL("DROP TABLE IF EXISTS "+ "S1");

            //
            database.execSQL("ALTER TABLE  Demo RENAME TO S1");

        }
    };


    Migration migration8_9 = new Migration(8,9) {  //Normal version upgrade
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {



        }
    };


    Migration migration9_10 = new Migration(9,10) {    //For add new table
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database)
        {


            String newTable = "employe ( e_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, e_name TEXT )";
            database.execSQL("CREATE TABLE "+newTable);
        }
    };

    //Mark:-
    public void insertIntoStudent(final Student  student)
    {

    class Test extends AsyncTask<Void, Void, Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {
            databaseClass.DaoClass().insert(student);
            return null;
        }
    }

    new Test().execute();

  }




    //Mark:- update Record
    public void updateStudent( final Student student,final int id)
    {
        class Test extends AsyncTask<Void, Void, Void>
        {

            @Override
            protected Void doInBackground(Void... voids) {
                //databaseClass.DaoClass().update(student.getUserName(),student.getUserPhone(),id);

                databaseClass.DaoClass().update(student);
                return null;
            }
        }

        new Test().execute();
    }

    //Mark:- update Record
    public void deleteStudent( final Student student)
    {
        class Test extends AsyncTask<Void, Void, Void>
        {

            @Override
            protected Void doInBackground(Void... voids) {
                //databaseClass.DaoClass().update(student.getUserName(),student.getUserPhone(),id);

                databaseClass.DaoClass().deleteRecord(student.getUserId(),student.getUserName());

                List<Student> data = databaseClass.DaoClass().getAllRecord();

                Log.e("Get ALL record",data.size()+"");
                return null;
            }
        }

        new Test().execute();
    }


    //Mark:- update Record
    public void getRecordFor( final String late)
    {
        class Test extends AsyncTask<Void, Void, Void>
        {

            @Override
            protected Void doInBackground(Void... voids) {
                //databaseClass.DaoClass().update(student.getUserName(),student.getUserPhone(),id);



                List<Student> data = databaseClass.DaoClass().getRecord( "%"+late+"%");

                Log.e("GetRecord size",data.size()+"");
                return null;
            }
        }

        new Test().execute();
    }


    public void getAllRecord()
    {


    }
}
