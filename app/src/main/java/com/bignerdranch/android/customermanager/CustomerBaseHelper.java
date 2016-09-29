package com.bignerdranch.android.customermanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jamila Hasikic on 9/24/2016.
 */

public class CustomerBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "customers.db";


    public CustomerBaseHelper(Context context) {

        super(context, DATABASE_NAME, null, VERSION);
        SQLiteDatabase myDb = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Customers.NAME + "(" +
                "_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Customers.NewCustomer.FIRST_NAME + "," +
                Customers.NewCustomer.LAST_NAME + "," +
                Customers.NewCustomer.SESSIONS + ")"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + Customers.NAME);
        onCreate(db);

    }
    // insert information into database.
    public void insertData( String fname, String lname, String sessions){
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Customers.NewCustomer.FIRST_NAME,fname);
        values.put(Customers.NewCustomer.LAST_NAME,lname);
        values.put(Customers.NewCustomer.SESSIONS, sessions);
        myDb.insert(Customers.NAME, null, values);
        myDb.close();
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
