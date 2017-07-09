package com.example.admin.exercrisesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 6/22/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="DuLieuTaiKhoan.db";
    private static final String TABLE_NAME="DuLieuTaiKhoan";
    private static final int VERSION=1;
    private static final String COLUMN_ID="id";
    private static final String COLUMN_PASSWORD="pass";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_IP="ip";
    private static final String COLUMN_PHONE="phone";
    private static final String TABLE_CREATE="create table if not exists "+TABLE_NAME+" ( "+COLUMN_ID+" text primary key not null, pass text not null," +
            " name text not null, ip text not null, phone text)";
    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
    public void insertTK(TaiKhoan tk){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ID,tk.getTenTK());
        values.put(COLUMN_PASSWORD,tk.getMatKhau());
        values.put(COLUMN_NAME,tk.getTenChuTK());
        values.put(COLUMN_IP,tk.getDiaChi());
        values.put(COLUMN_PHONE,tk.getSoDT());
        long id = db.insert(TABLE_NAME,null,values);
        db.close();
    }
}
