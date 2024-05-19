package com.gi.Chat.Application.Api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatMessageDto {

  @Id
  private Long messageId;
  private String roomId;
  private Long senderId;
  private String content;
  private LocalDate sentAt;
  private LocalDate updatedAt;
}
