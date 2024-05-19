package com.gi.Chat.Application.Api.service;

import com.gi.Chat.Application.Api.dto.ChatMessageDto;
import com.gi.Chat.Application.Api.entity.ChatMessage;
import com.gi.Chat.Application.Api.entity.MessageRoom;
import com.gi.Chat.Application.Api.mapper.ChatMessageMapper;
import com.gi.Chat.Application.Api.repository.ChatMessageRepo;
import com.gi.Chat.Application.Api.repository.MessageRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChatMessageService {

  @Autowired
  private ChatMessageRepo chatMessageRepo;

  @Autowired
  private MessageRoomRepo messageRoomRepo;

  public List<ChatMessage> getMessagesByRoomId(String roomId) {
    return chatMessageRepo.findChatMessagesByRoomId(roomId).orElseThrow();
  }

  public ChatMessageDto saveMessage(ChatMessageDto chatMessageDto) {
    ChatMessage messageToSave = ChatMessageMapper.convertFromDto(chatMessageDto);

    System.out.println(messageToSave.getMessageId());

    messageToSave.setRoomId(chatMessageDto.getRoomId());

    MessageRoom messageRoomToSave = new MessageRoom();

    messageRoomToSave.setRoomId(chatMessageDto.getRoomId());
    messageRoomToSave.setCreatedAt(LocalDate.now());

    messageRoomRepo.save(messageRoomToSave);

    ChatMessage savedMessage = chatMessageRepo.save(messageToSave);
    return ChatMessageMapper.convertToDto(savedMessage);
  }

}