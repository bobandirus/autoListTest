package com.example.sb823249.autolisttest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by sb823249 on 18/07/2017.
 */

public class DBTools extends SQLiteOpenHelper{
    public DBTools (Context application){
        super(application, "food.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        String createDatabase = "CREATE TABLE food (specificId INGEGER PRIMARY KEY, d TEXT, a TEXT, b TEXT, c TEXT)";
        database.execSQL(createDatabase);
        String insert_1  =  "INSERT INTO food (specificId, d, a, b, c) values (1, 'werdna', 'sgge', 'oyam', 'dihcro')";
        database.execSQL(insert_1);
        String insert_2  =  "INSERT INTO food (specificId, d, a, b, c) values (2, 'atiwas', 'nocab', 'oyam', 'eeffoc')";
        database.execSQL(insert_2);
        String insert_3  =  "INSERT INTO food (specificId, d, a, b, c) values (3, 'nadroj', 'sgge', 'puhctek', 'sffad')";
        database.execSQL(insert_3);
        String insert_4  =  "INSERT INTO food (specificId, d, a, b, c) values (4, 'airam', 'seotamot', 'oyam', 'selppa')";
        database.execSQL(insert_4);
        String insert_5  =  "INSERT INTO food (specificId, d, a, b, c) values (5, 'namlak', 'seotamot', 'oyam', 'arennug')";
        database.execSQL(insert_5);
        String insert_6  =  "INSERT INTO food (specificId, d, a, b, c) values (6, 'riatsala', 'sgge', 'puhctek', 'spartylf')";
        database.execSQL(insert_6);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
        String query = "DROP TABLE IF EXISTS food";
        db.execSQL(query);
        onCreate(db);
    }

    public ArrayList<String> theHeadings(){
      ArrayList<String> theHeadings = new ArrayList<>();
        String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'food' ORDER BY ORDINAL_POSITION";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do {
                //ArrayList<String> names = new ArrayList<>();
                String name = new StringBuilder(cursor.getString(0)).toString();
                theHeadings.add(name);
            }while (cursor.moveToNext());

            /**do {
             String[] names = new String[0];
             String name = new StringBuilder(cursor.getString)
             }**/
        }
        return theHeadings;
    }

    public ArrayList<String> theOptions(String column){
        ArrayList<String> theOptions = new ArrayList<>();
        String query = "SELECT DISTINCT " + column + "FROM food";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do{
                String name = new StringBuilder(cursor.getString(0)).toString();
                theOptions.add(name);
            }while (cursor.moveToNext());
        }
        return theOptions;
    }


}
