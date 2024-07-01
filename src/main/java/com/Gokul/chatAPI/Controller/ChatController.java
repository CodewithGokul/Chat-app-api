package com.Gokul.chatAPI.Controller;

import com.Gokul.chatAPI.DTO.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @MessageMapping("/chat.message")
    @SendTo("/topic/public")                    //Queue
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){
            return chatMessage;
    }
    @MessageMapping("/chat.adduser")            //Adduser to The Queue
    @SendTo("/topic/public")
    public ChatMessage addUser(
                                @Payload ChatMessage chatMessage,
                                SimpMessageHeaderAccessor headAccessor){

        headAccessor.getSessionAttributes().put("username",chatMessage.getSender());
        return chatMessage;

    }
}
      