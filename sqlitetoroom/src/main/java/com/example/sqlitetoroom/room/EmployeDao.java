package com.example.sqlitetoroom.room;



import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.sqlitetoroom.Employe;

import java.util.List;

@Dao
public interface EmployeDao
{
    @Insert
    public void insert(Employe employe);


    @Query("select * from Employe")
    public List<Employe> getRecord();
}
