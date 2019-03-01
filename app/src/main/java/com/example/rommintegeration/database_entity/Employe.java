package com.example.rommintegeration.database_entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "employe")
public class Employe implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "e_id")
    private int e_id;

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    @ColumnInfo(name = "e_name")
    private String e_name;

}
