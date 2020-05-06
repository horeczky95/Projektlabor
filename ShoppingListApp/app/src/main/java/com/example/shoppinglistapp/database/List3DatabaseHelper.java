package com.example.shoppinglistapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class List3DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "List3DatabaseHelper";

    private static final String TABLE_NAME = "Lista3";
    private static final String COL1 = "ID";
    private static final String COL2 = "Név";
    private static final String COL3 = "Egység_ár";
    private static final String COL4 = "Darab_szám";

    public List3DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME +
                " (ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " + COL2 + " VARCHAR(30) NOT NULL, " +
                COL3 + " INT NOT NULL, " + COL4 + " INT NOT NULL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String name, String price, String piece) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, price);
        contentValues.put(COL4, piece);

        Log.d(TAG, "addData: Adding " + name +
                ", " + price + ", " + piece + " to " + TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1) {
            return false;
        } else {
            return  true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public Cursor getAllPrice() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT SUM(" + COL3 + " * " + COL4 + ") FROM " + TABLE_NAME, null);
        return data;
    }

    public boolean updateItem(String ID, String newName, String newPrice, String newPiece) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1, ID);
        cv.put(COL2, newName);
        cv.put(COL3, newPrice);
        cv.put(COL4, newPiece);
        db.update(TABLE_NAME, cv, "ID = ?", new String[] {ID});
        return true;
    }

    public boolean updateName(String ID, String newName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1, ID);
        cv.put(COL2, newName);
        db.update(TABLE_NAME, cv, "ID = ?", new String[] {ID});
        return true;
    }

    public boolean updatePrice(String ID, String newPrice) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1, ID);
        cv.put(COL3, newPrice);
        db.update(TABLE_NAME, cv, "ID = ?", new String[] {ID});
        return true;
    }

    public boolean updatePiece(String ID, String newPiece) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1, ID);
        cv.put(COL4, newPiece);
        db.update(TABLE_NAME, cv, "ID = ?", new String[] {ID});
        return true;
    }

    public void deleteItem(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COL1 + " = '" + ID + "'";
        Log.d(TAG, "deleteItem: query: " + query);
        Log.d(TAG, "deleteItem: Deleting: " + ID + "from database.");
        db.execSQL(query);
    }

}
