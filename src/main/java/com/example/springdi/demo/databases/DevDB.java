package com.example.springdi.demo.databases;

public class DevDB implements  BaseDB{

    @Override
    public String getDatabase() {
        return "Development Database URL";
    }
}
