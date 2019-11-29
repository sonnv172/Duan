package com.example.duan_1.themnguoichoi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "AAA";
    public static final int VERSION = 1;
    public Database(Context context) {
        super(context, DATABASE_NAME, null,VERSION);
    }

    @Override
    public void onCreate(
        SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(DAO.SQL_SON);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists " + DAO.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
