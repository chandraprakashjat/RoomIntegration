package com.example.rommintegeration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rommintegeration.database_entity.Student;

public class MainActivity extends AppCompatActivity {


    EditText name,phone,age;
    Button bInsert,bUpdate,bDelete,bQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = findViewById(R.id.editText7);
        phone = findViewById(R.id.editText9);
        age = findViewById(R.id.editText10);



        bInsert = findViewById(R.id.button_insert);
        bUpdate = findViewById(R.id.button_update);
        bDelete = findViewById(R.id.button_delete);
        bQuery = findViewById(R.id.button_query);


        bInsert.setOnClickListener(new View.OnClickListener()
                                   {
                                       @Override
                                       public void onClick(View v)
                                       {
                                           String name1 = name.getText().toString();
                                           String phone1 = phone.getText().toString();
                                           long id = System.currentTimeMillis();
                                           if (!TextUtils.isEmpty(age.getText()))
                                           {
                                               id = Long.parseLong(age.getText().toString());
                                           }


                                           Student student = new Student();
                                           student.setUserName(name1);
                                          // student.setUserPhone(phone1);




                                           (HelperClass.getInstance(MainActivity.this)).insertIntoStudent(student);




                                       }
                                   }
        );


        bUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Student student = new Student();
                student.setUserId(23);
                student.setUserName("test");
                //student.setUserPhone("9874456");
                HelperClass.getInstance(MainActivity.this).updateStudent(student,Integer.parseInt(age.getText().toString())
                );
            }
        });


        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setUserId(Integer.parseInt(age.getText().toString()));
                student.setUserName(name.getText().toString());
                //student.setUserPhone("9874456");
                HelperClass.getInstance(MainActivity.this).deleteStudent(student
                );
            }
        });

        bQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelperClass.getInstance(MainActivity.this).getRecordFor(name.getText().toString()
                );
            }
        });

    }




}
