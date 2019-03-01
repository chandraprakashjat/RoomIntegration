package com.example.sqlitetoroom;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.sqlitetoroom.Database.EmployeDatabase;
import com.example.sqlitetoroom.room.EmployeHelper;


import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
              //  EmployeDatabase obj = new EmployeDatabase(MainActivity.this);
              // obj.insert(new Employe( (int)System.currentTimeMillis(),String.valueOf(System.currentTimeMillis())));

             new a().execute();
            }
        });
    }


      class  a extends AsyncTask
      {

          @Override
          protected Object doInBackground(Object[] objects) {

             List <Employe> i = EmployeHelper.getInstance(MainActivity.this).databaseNew.EmployeDao().getRecord();

             Log.e("Detail",i.size()+"");
              return null;
          }
      }
}
