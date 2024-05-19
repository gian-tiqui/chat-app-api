package com.gi.Chat.Application.Api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chat_messages")
public class ChatMessage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long messageId;
  private String roomId;
  private Long senderId;
  private String content;
  private LocalDate sentAt;
  private LocalDate updatedAt;
}
