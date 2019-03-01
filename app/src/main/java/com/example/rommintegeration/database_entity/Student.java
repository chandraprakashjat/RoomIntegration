package com.example.rommintegeration.database_entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity (tableName = "S1")
public class Student implements Serializable {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name = "user_id")
    private int userId;
    @ColumnInfo (name = "user_name")
    private String userName;





    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



}
