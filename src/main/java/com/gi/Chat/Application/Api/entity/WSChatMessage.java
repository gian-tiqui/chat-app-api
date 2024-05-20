package com.gi.Chat.Application.Api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WSChatMessage {

  private String content;
  private String sender;
  private MessageType type;
}
