package com.example.sqlitetoroom.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.sqlitetoroom.Employe;


@Database(entities = {Employe.class},version = 2)
public abstract  class EmployeDatabaseNew extends RoomDatabase
{
    public abstract EmployeDao EmployeDao();
}
