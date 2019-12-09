package com.example.finalproject;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        TextView setName = findViewById(R.id.newName);
        setName.setVisibility(View.GONE);
        Button enterName = findViewById(R.id.enterName);
        enterName.setVisibility(View.GONE);
        TextView textName = findViewById(R.id.textName);
        textName.setVisibility(View.GONE);
        TextView editNameText = findViewById(R.id.editNameText);
        editNameText.setVisibility(View.GONE);
        upDateUI();
        Button editName = findViewById(R.id.editName);
        editName.setOnClickListener(unused -> editName());
        Button home = findViewById(R.id.home);
        home.setOnClickListener(unused -> finish());
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

    public void editName() {
        ImageView profilePic = findViewById(R.id.imageView3);
        Button editName = findViewById(R.id.editName);
        TextView profileTitle = findViewById(R.id.profileTitle);
        TextView totalTask = findViewById(R.id.taskTotal);
        TextView completeTask = findViewById(R.id.taskComplete);
        EditText setName = findViewById(R.id.newName);
        Button enterName = findViewById(R.id.enterName);
        TextView editNameText = findViewById(R.id.editNameText);
        editNameText.setVisibility(View.VISIBLE);
        TextView textName = findViewById(R.id.textName);
        totalTask.setVisibility(View.GONE);
        completeTask.setVisibility(View.GONE);
        profilePic.setVisibility(View.GONE);
        editName.setVisibility(View.GONE);
        profileTitle.setVisibility(View.GONE);
        setName.setVisibility(View.VISIBLE);
        setName.setText("");
        enterName.setVisibility(View.VISIBLE);
        textName.setVisibility(View.VISIBLE);
        enterName.setOnClickListener(unused -> {
            String newName = setName.getText().toString();
            if (newName.trim().equals("")) {
                newName = "Geoff Challen";
            }
            totalTask.setVisibility(View.VISIBLE);
            editName.setVisibility(View.VISIBLE);
            editNameText.setVisibility(View.GONE);
            completeTask.setVisibility(View.VISIBLE);
            profilePic.setVisibility(View.VISIBLE);
            profileTitle.setVisibility(View.VISIBLE);
            setName.setVisibility(View.GONE);
            enterName.setVisibility(View.GONE);
            textName.setVisibility(View.GONE);
            profileTitle.setText(newName);
        });
    }
}
