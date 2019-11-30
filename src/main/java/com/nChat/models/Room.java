package com.nChat.models;

import java.util.ArrayList;

public class Room {
    private final int maxUserNum = 8;

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    private int roomNum;

    public ArrayList<User> getUsers() {
        return users;
    }

    private ArrayList<User> users = new ArrayList<User>();

    public Room(int roomNum) {
        this.roomNum = roomNum;
    }

    public boolean addUser(User user) {
        if (users.size() < maxUserNum) {
            users.add(user);

            return true;
        }
        return false;
    }
}
