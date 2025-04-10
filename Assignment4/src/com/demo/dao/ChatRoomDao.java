package com.demo.dao;

import com.demo.beans.ChatRoom;
import com.demo.beans.User;

public interface ChatRoomDao {
    void addUser(User user);
    void removeUser(User user);
    ChatRoom getChatRoom();
}
