package com.bignerdranch.android.customermanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jamila on 9/25/2016.
 */

public class CustomerDbHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "customers.db";


    public CustomerDbHandler(Context context) {

        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Customers.NAME + "(" +
                "_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Customers.NewCustomer.FIRST_NAME + ", " +
                Customers.NewCustomer.LAST_NAME + ", " +
                Customers.NewCustomer.SESSIONS + ")"
        );
    }


        @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" +  Customers.NewCustomer.TABLE_NAME);
        onCreate(db);

    }
    // insert information into database.
    public void addCustomer( String fname, String lname, String sessions, SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(Customers.NewCustomer.FIRST_NAME,fname);
        values.put(Customers.NewCustomer.LAST_NAME,lname);
        values.put(Customers.NewCustomer.SESSIONS, sessions);
        db.insert(Customers.NewCustomer.TABLE_NAME, null, values);
        db.close();
    }

    /*public void deleteCustomer(String customerName){

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE  FROM " + TABLE_CUSTOMER + "WHERE" + COL_LAST + "=\"" + customerName + "\";");
    }*/
    //get information from database
    public Cursor getCustomerInfo(SQLiteDatabase db){
        Cursor cursor;
        String[] customerInfo = {Customers.NewCustomer.FIRST_NAME, Customers.NewCustomer.LAST_NAME, Customers.NewCustomer.SESSIONS };
        cursor = db.query(Customers.NAME, customerInfo, null, null, null, null, null );
        return cursor;
    }

}
