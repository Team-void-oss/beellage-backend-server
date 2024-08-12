package com.oss.beellage.chat.collection;

import com.oss.beellage.chat.Chat;
import com.oss.beellage.chat.dto.ChatMessageDto;

import java.util.List;
import java.util.stream.Collectors;

public class ChatConverter {

    public static List<ChatMessageDto> convertToDto(List<Chat> chatList) {
        return chatList.stream()
                .map(chat -> new ChatMessageDto(
                        chat.getSender().getId(),
                        chat.getSender().getNickname(),
                        chat.getMessage()))
                .collect(Collectors.toList());
    }
}

