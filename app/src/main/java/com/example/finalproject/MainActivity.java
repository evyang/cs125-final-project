package com.example.finalproject;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> tasks;
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
        //Intent intent = new Intent(this, )
        profile.setOnClickListener(unused -> startActivity(new Intent(this, Profile.class)));

        Button calendar = findViewById(R.id.calendar);
        calendar.setOnClickListener(unused -> startActivity(new Intent(this, Calendar.class)));

    }
    private void connect() {
        //LinearLayout task = findViewById(R.id.taskList);
        //task.setVisibility(View.VISIBLE);
    }
    private void addTask() {
        TextView e = findViewById(R.id.name);
        String eventName= e.getText().toString();
        if (!(eventName.equals(""))) {
            tasks.add(eventName);
            totalTask++;
            //e.setText("");
            updatePlayersUI();
        }
    }
    private void updatePlayersUI() {
        LinearLayout tasksList = findViewById(R.id.taskList);
        tasksList.removeAllViews();
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
            String t = tasks.get(i);
            View taskView = getLayoutInflater().inflate(R.layout.chunk_tasks,
                    tasksList, false);
            TextView eN = taskView.findViewById(R.id.taskName);
            //TextView eD = inviteeView.findViewById(R.id.date);
            eN.setText(t);
            //eD.setText(task.getDate());
            Button delete = taskView.findViewById(R.id.deleteTask);
            delete.setOnClickListener(unused -> {
                tasks.remove(t);
                updatePlayersUI();
            });
            Button done = taskView.findViewById(R.id.taskComplete);
            done.setOnClickListener(unused -> {
                completeTask = completeTask + 1;
                eN.setPaintFlags(eN.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            });
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
