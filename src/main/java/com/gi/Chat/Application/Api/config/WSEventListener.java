package com.gi.Chat.Application.Api.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WSEventListener {

  @EventListener
  public void handleWSDisconnectListener(SessionDisconnectEvent event) {
    // inform a user is offline
  }
}
