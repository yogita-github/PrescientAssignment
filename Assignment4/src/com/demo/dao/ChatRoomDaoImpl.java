package com.demo.dao;

import com.demo.beans.ChatRoom;
import com.demo.beans.User;

public class ChatRoomDaoImpl implements ChatRoomDao {
    private ChatRoom chatRoom = new ChatRoom();

    public void addUser(User user) {
        chatRoom.addUser(user);
    }

    public void removeUser(User user) {
        chatRoom.removeUser(user);
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }
}
