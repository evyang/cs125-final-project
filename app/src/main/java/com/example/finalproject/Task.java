package com.example.finalproject;

public final class Task {
    private String name;
    private String date;

    public Task(final String setName, final String setDate) {
        name = setName;
        date = setDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String setName) {
        this.name = setName;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String setDate) {
        this.date = setDate;
    }
}
