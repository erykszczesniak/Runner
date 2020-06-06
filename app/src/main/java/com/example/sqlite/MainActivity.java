package com.example.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText editName, editlastname, editage ,editpb;
    Button btnData;
    private SQLiteDatabase sql;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        editName = (EditText)findViewById(R.id.editText_name);
        editlastname = (EditText)findViewById(R.id.editText_lastname);
        editage = (EditText)findViewById(R.id.editText_age);
        editpb = (EditText)findViewById(R.id.editText_pb);
        btnData = (Button)findViewById(R.id.button_add);
        AddData();
    }
    private void AddData() {
        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String lastname = editlastname.getText().toString();
                String age = editage.getText().toString();
                String personalbest = editpb.getText().toString();

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(MainActivity.this, "Please enter the Name", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(lastname)) {
                    Toast.makeText(MainActivity.this, "Please enter the LastName", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(age)) {
                    Toast.makeText(MainActivity.this, "Please enter the age", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(personalbest)) {
                    Toast.makeText(MainActivity.this, "Please enter the personal best", Toast.LENGTH_LONG).show();
                    return;
                }
                boolean isInserted = db.insertData(name, lastname, age, personalbest);
                if (isInserted == true) {
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();

                }
            }
        });
    }


                }
