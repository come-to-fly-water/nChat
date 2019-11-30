package com.nChat.models;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nChat.game.Server;

import java.util.*;

public class State {
    private static final State instance = new State();
    private final int roomMaxNum = 100;
    private final int roonUserNum = 8;
    private ArrayList<Room> rooms;
    //默认最大房间数一百
    //当前房间状态,1代表已使用，0代表未使用
    private int[] roomState = new int[100];

    private State() {
    }

    public static State getInstance() {
        return instance;
    }

    private ArrayList<Server> sessions = new ArrayList<Server>();

    private ArrayList<User> users = new ArrayList<User>();

    public String CreateRoom(String jsonInfo) {
        JSONObject jsonObject = JSON.parseObject(jsonInfo);
        String userID = jsonObject.getString("userID");
        String avatarUrl = jsonObject.getString("avatarUrl");
        for (int i = 0; i < roomMaxNum; i++) {
            if (roomState[i] == 0) {
                User user = new User(userID, avatarUrl);
                roomState[i] = 1;
                rooms.add(new Room(i));
                rooms.get(i).addUser(user);
                JSONObject object = new JSONObject();
                object.put("roomNumber", i);
                return object.toJSONString();
            }
        }
        return "-1";
    }

    public String searchRoom(String json) {
        int roomNum = 0;
        String userID = null;
        String avatarUrl = null;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomNum() == roomNum) {
                if (rooms.get(i).addUser(new User(userID, avatarUrl))) {
                    users = rooms.get(i).getUsers();
                    JSONObject object = new JSONObject();
                    String[] userInfo = new String[10];
                    for (int j = 0; j < users.size(); j++) {
                        userInfo[j] = "id:\" " + users.get(i).getId() + "\", url: " + users.get(j).getAvatarUrl() + "\"";
                    }
                    object.put("avatars", userInfo.toString());
                    return object.toJSONString();
                }
            }
        }
        return "-1";
    }
}

