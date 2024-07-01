package com.Gokul.chatAPI.DTO;


import com.Gokul.chatAPI.MessageType;
import lombok.Builder;


public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageType getType() {
        return type;
    }

    public MessageType setType(MessageType type) {
        this.type = type;
        return type;
    }
};