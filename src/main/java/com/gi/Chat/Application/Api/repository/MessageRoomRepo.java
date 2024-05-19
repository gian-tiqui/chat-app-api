package com.gi.Chat.Application.Api.repository;

import com.gi.Chat.Application.Api.entity.MessageRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRoomRepo extends JpaRepository<MessageRoom, Long> {
}
