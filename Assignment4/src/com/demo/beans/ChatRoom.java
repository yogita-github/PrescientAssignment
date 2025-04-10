package com.demo.beans;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private List<User> users = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<User> getUsers() {
        return users;
    }
}
