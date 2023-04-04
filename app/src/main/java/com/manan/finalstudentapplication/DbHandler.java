package com.manan.finalstudentapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DbHandler extends SQLiteOpenHelper {

    private  static  final String DB_NAME="Manan";
    private static final int DB_VERSION=1;
    private static final String TABLE_NAME="STUDENTOFMCA";
    private static final String TABLE_STUDENT_NAME="STUDENT_NAME";
//    private static final String TABLE_STUDENT_ID="STUDENT_ID";
    private static final String TABLE_STUDENT_ENROLLMENT="STUDENT_ENROLLMENT";
    private static final String TABLE_STUDENT_AGE="STUDENT_AGE";
    private static final String TABLE_STUDENT_GENDER="STUDENT_GENDER";
    public DbHandler(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + TABLE_STUDENT_NAME +" TEXT,"+ TABLE_STUDENT_ENROLLMENT +" TEXT,"+ TABLE_STUDENT_AGE +" TEXT,"+ TABLE_STUDENT_GENDER +" TEXT"+")");

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.close();
        onCreate(db);


    }

    public void addalldata(String Name,String Enrollment,String Age,String Gender){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE_STUDENT_NAME,Name);
        contentValues.put(TABLE_STUDENT_ENROLLMENT,Enrollment);
        contentValues.put(TABLE_STUDENT_AGE,Age);
        contentValues.put(TABLE_STUDENT_GENDER,Gender);
        db.insert(TABLE_NAME,null,contentValues);
        db.close();

    }
    public ArrayList<Studentinfomodel> displaydata()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor= db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        ArrayList<Studentinfomodel>arr = new ArrayList<>();
        while (cursor.moveToNext())
        {
            arr.add(new Studentinfomodel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
        }

        cursor.close();
        return  arr;

    }
}
