package com.Gokul.chatAPI.Config;

import com.Gokul.chatAPI.DTO.ChatMessage;
import com.Gokul.chatAPI.MessageType;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {
    private SimpMessageSendingOperations messageSendingOperations;


    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {

        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");

        if (username != null) {

            var chatMessage = new ChatMessage();
            chatMessage.setSender(username);
            chatMessage.setType(chatMessage.setType(MessageType.LEAVE));
            messageSendingOperations.convertAndSend("/topic/public",chatMessage);
        }
    }
}




