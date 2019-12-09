package com.example.finalproject;

import android.content.Intent;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> tasks;
    private static int completeTask;
    private static int totalTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        completeTask = 0;
        totalTask = 0;
        tasks = new ArrayList<>();
        Button addTask = findViewById(R.id.add);
        addTask.setOnClickListener(unused -> addTask());

        Button profile = findViewById(R.id.profile);

        profile.setOnClickListener(unused -> startActivity(new Intent(this, Profile.class)));

        Button calendar = findViewById(R.id.calendar);
        calendar.setOnClickListener(unused -> startActivity(new Intent(this, Calendar.class)));

    }

    private void addTask() {
        TextView e = findViewById(R.id.name);
        String eventName= e.getText().toString();
        if (!(eventName.equals(""))) {
            tasks.add(new Task(eventName));
            totalTask++;
            //e.setText("");
            updatePlayersUI();
        }
    }
    private void updatePlayersUI() {
        LinearLayout tasksList = findViewById(R.id.taskList);
        tasksList.removeAllViews();
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            String name = t.getName();
            View taskView = getLayoutInflater().inflate(R.layout.chunk_tasks,
                    tasksList, false);
            TextView eN = taskView.findViewById(R.id.taskName);
            eN.setText(name);
            Button delete = taskView.findViewById(R.id.deleteTask);
            delete.setOnClickListener(unused -> {
                tasks.remove(t);
                updatePlayersUI();
            });
            Button done = taskView.findViewById(R.id.taskComplete);
            done.setOnClickListener(unused -> {
                completeTask = completeTask + 1;
                eN.setPaintFlags(eN.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                t.setState(true);
                MediaPlayer applause = MediaPlayer.create(MainActivity.this, R.raw.audienceapplause);
                applause.start();
            });
            if (t.getState()) {
                eN.setPaintFlags(eN.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
            tasksList.addView(taskView);
        }
    }
    public static int getCompleteTask() {
        return completeTask;
    }
    public static int getTotalTask() {
        return totalTask;
    }
}
