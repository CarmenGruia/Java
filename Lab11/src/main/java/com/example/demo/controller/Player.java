package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Player> players = new ArrayList<>();
    public int id;
    public String name;
    public Player(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name=name;
    }
}
