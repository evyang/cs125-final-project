package com.example.finalproject;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity {
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_calendar);

        //LinearLayout homeLayout = findViewById(R.id.homeLayout);
        //homeLayout.setVisibility(View.GONE);
        Button addTask = findViewById(R.id.addTask);
        addTask.setVisibility(View.GONE);
    }

}
