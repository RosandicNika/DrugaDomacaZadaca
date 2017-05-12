package com.example.nika.mytodoapp;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DBHandler mHelper;
    private static final String TAG="MainActivity";
    private ListView TaskListView;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelper= new DBHandler(this);
        TaskListView = (ListView) findViewById(R.id.list_todo);
        updateUI();

    }

    private void updateUI(){
        ArrayList<String> taskList= new ArrayList<>();
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHandler.TaskEntry.TABLE_TASK_DETAIL,
                new String[]{DBHandler.TaskEntry.KEY_TASK, DBHandler.TaskEntry.KEY_DATE},
                null, null, null, null, null);
        while(cursor.moveToNext()) {
            int idx = cursor.getColumnIndex(DBHandler.TaskEntry.KEY_TASK);
            taskList.add(cursor.getString(idx));
        }


        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<String>(this, R.layout.task, R.id.task_date,taskList);
            TaskListView.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(taskList);
            mAdapter.notifyDataSetChanged();
        }
        cursor.close();
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }}
