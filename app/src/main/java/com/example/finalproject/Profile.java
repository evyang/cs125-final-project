package com.example.finalproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        upDateUI();
        // add the textView
        // taskNumer = size()
        // edit textview string "total tasks: " + taskNumber

    }
    private void upDateUI() {
        TextView totalTask = findViewById(R.id.taskTotal);
        TextView completeTask = findViewById(R.id.taskComplete);
        completeTask.setText("Total Completed Tasks : " + (MainActivity.getCompleteTask()));
        totalTask.setText("Total Tasks of All Time : " + (MainActivity.getTotalTask()));
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
