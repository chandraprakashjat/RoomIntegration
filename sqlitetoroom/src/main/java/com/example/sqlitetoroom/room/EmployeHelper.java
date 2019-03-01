package com.example.sqlitetoroom.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

public class EmployeHelper
{

    private static volatile EmployeHelper instance;
   public EmployeDatabaseNew databaseNew;



    public static EmployeHelper getInstance(Context context)
    {

        if(instance == null)
        {
          instance = new  EmployeHelper(context);
        }

        return instance;
    }


    public EmployeHelper(Context context)
    {
       databaseNew = Room.databaseBuilder(context,EmployeDatabaseNew.class,"EMPLOYE")
               .addMigrations(migration1_2)
               .build();
    }



    Migration migration1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database)
        {



        }
    };
}
