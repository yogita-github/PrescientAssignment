package com.demo.service;

import com.demo.beans.User;
import com.demo.beans.Message;

public interface ChatService {
    void sendMessage(User sender, User receiver, String content);
}
