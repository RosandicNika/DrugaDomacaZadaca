package com.example.nika.mytodoapp;

/**
 * Created by NIKA on 5/12/2017.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;


public class DBHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION=1;
    private static final String DB_NAME="taskDB";

    public class TaskEntry implements BaseColumns {
        public static final String TABLE_TASK_DETAIL= "taskDetails";
        public static final String KEY_TASK= "task";
        public static final String KEY_DATE= "date";
    }

    public DBHandler(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TASK_DETAIL_TABLE = " CREATE TABLE "+TaskEntry.TABLE_TASK_DETAIL+ "("
                + TaskEntry.KEY_TASK + " STRING PRIMARY KEY,"
                + TaskEntry.KEY_DATE + " TEXT "
                + ")";
        db.execSQL(CREATE_TASK_DETAIL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TaskEntry.TABLE_TASK_DETAIL);
        onCreate(db);
    }
}