package com.seg2505.tuto4;

import static android.provider.Contacts.SettingsColumns.KEY;

import static org.xmlpull.v1.XmlPullParser.TEXT;

import android.content.Context;
import android.database.Cursor;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME ="productDB.db";
    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME ="productname";
    public static final String COLUMN_SKU = "SKU";
    public static final String COLUMN_KEY = "KEY";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE" +
                TABLE_PRODUCTS +
                "("+
                "COLUMN_ID"+
                " INTEGER PRIMARY KEY,"+
                COLUMN_PRODUCTNAME+"TEXT," +
                COLUMN_SKU +
                "INTEGER" +
                ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);

    }
}
