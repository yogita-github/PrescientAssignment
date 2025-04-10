package com.demo.service;

import com.demo.beans.ChatRoom;
import com.demo.beans.Message;
import com.demo.beans.User;
import com.demo.dao.ChatRoomDao;

public class ChatServiceImpl implements ChatService {
    private ChatRoomDao chatRoomDao;

    public ChatServiceImpl(ChatRoomDao chatRoomDao) {
        this.chatRoomDao = chatRoomDao;
    }

    @Override
    public void sendMessage(User sender, User receiver, String content) {
        ChatRoom chatRoom = chatRoomDao.getChatRoom();
        Message message = new Message(sender.getUsername(), receiver.getUsername(), content);
        chatRoom.addMessage(message);
        System.out.println(message);
    }
}
