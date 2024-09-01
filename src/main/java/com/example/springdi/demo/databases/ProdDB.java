package com.example.springdi.demo.databases;

public class ProdDB implements  BaseDB{

    @Override
    public String getDatabase() {
        return "Production Database URL";
    }
}
