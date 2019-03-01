package com.example.rommintegeration.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.rommintegeration.database_entity.Student;

import java.util.List;

@Dao
public interface DaoClass
{
    @Insert
    public void insert(Student student);


    @Insert
    public void insert(Student ... student);

//    @Query("UPDATE S1 SET  user_name = :name, user_phone = :phone where user_name = :id")
//    public void update(String name, String phone, int id);

    @Update
    public void update(Student student);



    //Mark for delete any row(entire row) that record matching with module
    @Delete
    public  void delete( Student student);

    @Query("Delete From S1")
    public  void delete( );


    @Query("DELETE FROM S1 WHERE user_id = :userId AND user_name LIKE :userName")
    public void deleteRecord(int userId,String userName);




    //MarkL :- get record
    @Query("SELECT * FROM S1")
    public List<Student> getAllRecord();


    @Query("SELECT * FROM S1 WHERE user_name LIKE :userName ")  //iqual to user_name = :userName
    public List<Student> getRecord(String userName);

//    @Query("SELECT * FROM S1 WHERE user_name LIKE :userName OR user_phone LIKE '%'|| :userName || '%' AND user_name = :userName")  //for like pass :-
//    public List<Student> getRecordLike(String userName);



}
