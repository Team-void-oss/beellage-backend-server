package com.oss.beellage.chat.controller;

import com.oss.beellage.chat.Chat;
import com.oss.beellage.chat.dto.ChatMessageDto;
import com.oss.beellage.chat.service.ChatService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatMessageControllerImpl implements ChatMessageController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatService chatService;

    public ChatMessageControllerImpl(SimpMessagingTemplate messagingTemplate, ChatService chatService) {
        this.messagingTemplate = messagingTemplate;
        this.chatService = chatService;
    }

    @Override
    @MessageMapping("/chats/{teamId}/sendMessage")
    public void sendMessage(@DestinationVariable("teamId") Long teamId, @Payload ChatMessageDto chatMessageDto) {
        Chat c = chatService.saveMessage(teamId, chatMessageDto.getUserId(), chatMessageDto.getMessage());
        // 특정 팀의 채팅 주제로 메시지를 브로드캐스트
        System.out.println(c.getSender().getName() + "!!!!1");
        messagingTemplate.convertAndSend("/chatting/api/v1/work/teams/" + teamId + "/chats",
                new ChatMessageDto(c.getId(), c.getSender().getName(), c.getMessage()));
    }
}
