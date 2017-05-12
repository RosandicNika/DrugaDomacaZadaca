package com.example.nika.mytodoapp;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Button;
import android.os.Bundle;
import android.graphics.Color;

import java.util.Calendar;
import java.util.Date;


/**
 * Created by NIKA on 5/8/2017.
 */

@TargetApi(21)
public class TaskActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edit=new EditText(this);
        edit.setHint("task,yyyy-mm-dd");
        final EditText edit2= edit;




        Log.d(TAG, "Add a new task");

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Add a new task")
                .setView(edit2)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] both = (String.valueOf(edit2)).split(",");
                        Intent intent=new Intent();
                        intent.putExtra("entry",both);
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        Intent intent=new Intent();
                        setResult(RESULT_CANCELED,intent);
                        finish();
                    }
                }).create();
        dialog.show();

        Button nbutton = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        nbutton.setBackgroundColor(Color.parseColor("#FF9E80"));
        Button pbutton = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        pbutton.setBackgroundColor(Color.parseColor("#FF9E80"));

    }

}