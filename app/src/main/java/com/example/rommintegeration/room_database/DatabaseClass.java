package com.example.rommintegeration.room_database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.rommintegeration.DAO.DaoClass;
import com.example.rommintegeration.database_entity.Employe;
import com.example.rommintegeration.database_entity.Student;

@Database( entities = {Student.class, Employe.class}, version = 10)
public abstract class DatabaseClass extends RoomDatabase
{

   public abstract DaoClass DaoClass();
}
