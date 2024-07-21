package com.oss.beellage.chat.controller;

import com.oss.beellage.chat.Chat;
import com.oss.beellage.chat.dto.ChatMessageDto;
import com.oss.beellage.chat.service.ChatService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/work/teams/{teamId}/chats")
public class ChatApiControllerImpl implements ChatApiController {

    private final ChatService chatService;

    private final SimpMessagingTemplate messagingTemplate;

    public ChatApiControllerImpl(ChatService chatService, SimpMessagingTemplate messagingTemplate) {
        this.chatService = chatService;
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    @GetMapping
    public List<Chat> getMessages(@PathVariable("teamId") Long teamId) {
        return chatService.getMessagesForTeam(teamId);
    }

    @Override
    @PostMapping
    public Chat sendMessage(@PathVariable("teamId") Long teamId, @RequestBody ChatMessageDto chatMessageDto) {
        // token으로 user를 찾는 방식으로 변경 필요
        Long userId = 1L;
        Chat chatMessage = chatService.saveMessage(teamId, userId, chatMessageDto.getContent());

        // broadcast path
        messagingTemplate.convertAndSend("/chatting/api/v1/work/teams/" + teamId + "/chats", chatMessageDto);

        return chatMessage;
    }
}
