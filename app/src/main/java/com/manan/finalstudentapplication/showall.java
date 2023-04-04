package com.manan.finalstudentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class showall extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Studentinfomodel> arr = new ArrayList<>();
    DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showall);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.recycle1);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dbHandler = new DbHandler(this);


        ArrayList<Studentinfomodel> arr = dbHandler.displaydata();
        studentinfoadapater studentinfoadapater = new studentinfoadapater(this,arr);
        recyclerView.setAdapter(studentinfoadapater);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));





    }
}