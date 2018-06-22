package com.bjethwan.cp1.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NationDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "nation.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_NATION_TABLE =
            "CREATE TABLE countries (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "country TEXT NOT NULL," +
                    "continent TEXT );";

    public NationDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
