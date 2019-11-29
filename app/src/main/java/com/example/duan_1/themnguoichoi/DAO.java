package com.example.duan_1.themnguoichoi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DAO {

    private SQLiteDatabase db;
    private Database database;
    public static final String TABLE_NAME = "TRUONG";
    public static final String SQL_SON ="CREATE TABLE [TRUONG] (\n"+
            "[T1] TEXT  NULL PRIMARY KEY,\n"+
            "[T2] TEXT  NULL,\n"+
            "[T3] TEXT  NULL,\n"+
            "[T4] FLOAT  NULL,\n"+
            "[T5] FLOAT  NULL\n"+
            ")";
    public static final String TAG="DAO";

    public DAO(Context context) {
        database = new Database(context);
        db = database.getWritableDatabase();
    }
    public int Them(Model list){
        ContentValues contentValues=new ContentValues();
        contentValues.put("T1",list.getT1());
        contentValues.put("T2",list.getT2());
        contentValues.put("T3",list.getT3());

        if (check(list.getT1())){
            int result = db.update(TABLE_NAME,contentValues,"t1=?", new String[]{list.getT1()});
            if (result == 0){
                return -1;
            }
        }else {
            try {
                if (db.insert(TABLE_NAME, null, contentValues) == -1) {
                    return -1;
                }
            } catch (Exception ex) {
                Log.e(TAG, ex.toString());
            }
        }
        return 1;
    }
    public boolean check(String strPrimaryKey){
        //SELECT
        String[] columns = {"t1"};
        //WHERE clause
        String selection = "t1=?";
        //WHERE clause arguments
        String[] selectionArgs = {strPrimaryKey};
        Cursor c = null;
        try{
            c = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
            c.moveToFirst();
            int i = c.getCount();
            c.close();
            if(i <= 0){
                return false;
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Model> getAllT(){

        List<Model> list= new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            Model s=new Model();
            s.setT1(c.getString(0));
            s.setT2(c.getString(1));
            s.setT3(c.getString(2));
            list.add(s);
            Log.d("//=====",s.toString());
            c.moveToNext();
        }
        c.close();
        return list;
    }
    public int Delete (String T1){
        int result = db.delete(TABLE_NAME,"t1=?",new String[]{T1});
        if (result == 0)
            return -1;
        return 1;
    }
    public int checkLogin(String username, String password){
        int result = db.delete(TABLE_NAME,"t2=? AND t3=?",new String[]{username,password});
        if (result == 0)
            return -1;
        return 1;
    }

}
