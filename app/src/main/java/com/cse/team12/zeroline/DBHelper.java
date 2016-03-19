package com.cse.team12.zeroline;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ftwpk on 3/16/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String databaseName = "Zero.sqlite";
    private static final int VERSION = 1;
    private static final String PLACES_TABLE_NAME = "places";
    public static final String PLACES_COLUMN_ID = "id";
    public static final String PLACES_COLUMN_NAME = "name";
    public static final String PLACES_COLUMN_PHONE = "phone";
    public static final String PLACES_COLUMN_ADDRESS = "address";
    public static final String PLACES_COLUMN_TYPE = "place_type";
    public DBHelper(Context context)
    {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {

        db.execSQL("create table places " + "(id integer primary key, name tex, phone text, address text, place_type text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public boolean insertPlace (String name, String phone, String address, String place_type) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("address", address);
        contentValues.put("place_type", place_type);
        db.insert("places", null, contentValues);
        return true;
    }
    public Cursor getPlaces(String place_type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "select * from places where place_type="+place_type+"", null);
        return res;
    }
}
