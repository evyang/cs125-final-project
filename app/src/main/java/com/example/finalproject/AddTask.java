package com.example.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//import org.json.JSONObject;

import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Iterator;
import java.util.List;
//import java.util.ListIterator;


public class AddTask extends AppCompatActivity {

    private List<Task> tasks;

    protected void onCreate(Bundle saveInstanceState) {
        tasks = new ArrayList<>();
        super.onCreate(saveInstanceState);
        setContentView(R.layout.popup_newtask);
        setTitle("Add Task");

        Button addTask = findViewById(R.id.addingTask);
        Button cancelTask = findViewById(R.id.cancelTask);
        addTask.setOnClickListener(unused -> addTask());
        cancelTask.setOnClickListener(unused -> finish());
    }
    private void addTask() {
        TextView e = findViewById(R.id.event);
        String eventName = e.getText().toString();
        TextView d = findViewById(R.id.date);
        String date = d.getText().toString();
        if (!(eventName.equals(""))) {
            tasks.add(new Task(eventName, date));
            //e.setText("");
            updatePlayersUI();
        }
        finish();
    }
    private void updatePlayersUI() {
        LinearLayout playersList = findViewById(R.id.taskList);
        playersList.removeAllViews();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            View inviteeView = getLayoutInflater().inflate(R.layout.chunk_tasks,
                    playersList, false);
            TextView eN = inviteeView.findViewById(R.id.taskName);
            //TextView eD = inviteeView.findViewById(R.id.date);
            eN.setText(task.getName());
            //eD.setText(task.getDate());
        }
    }
}
