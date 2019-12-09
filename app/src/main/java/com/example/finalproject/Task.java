package com.example.finalproject;

public class Task {
    private String name;
    private boolean state;

    public Task (String setName){
        name = setName;
        state = false;
    }

    public void setName(String nameInput) {
        name = nameInput;
    }
    public void setState(Boolean stateInput) {
        state = stateInput;
    }
    public String getName() {
        return name;
    }
    public boolean getState() {
        return state;
    }
}
