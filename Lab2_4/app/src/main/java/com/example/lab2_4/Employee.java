package com.example.lab2_4;

public class Employee {
    private String ID;
    private String Name;
    private boolean Position;

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public String getFullName() {
        return Name;
    }

    public void setFullName(String name) {
        this.Name = name;
    }

    public void setPosition(boolean position) {
        this.Position = position;
    }

    public boolean isManager() {
        return Position;
    }
}
