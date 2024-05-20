package com.gi.Chat.Application.Api.config;

import com.gi.Chat.Application.Api.entity.ChatMessage;
import com.gi.Chat.Application.Api.entity.MessageType;
import com.gi.Chat.Application.Api.entity.WSChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WSEventListener {

  private final SimpMessageSendingOperations messageTemplate;

  @EventListener
  public void handleWSDisconnectListener(SessionDisconnectEvent event) {
    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

    String username = (String) headerAccessor.getSessionAttributes().get("username");

    if (username != null) {
      log.info("User disconnected {}", username);

      var chatMessage = WSChatMessage.builder()
          .type(MessageType.LEAVE)
          .sender(username)
          .build();

      messageTemplate.convertAndSend("/topic/public", chatMessage);

    }
  }
}
