package com.oss.beellage.chat.controller;

import com.oss.beellage.chat.domain.ChatMessage;
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
    public List<ChatMessage> getMessages(@PathVariable("teamId") Long teamId) {
        return chatService.getMessagesForTeam(teamId);
    }

    @Override
    @PostMapping
    public ChatMessage sendMessage(@PathVariable("teamId") Long teamId, @RequestBody ChatMessageDto chatMessageDto) {
        ChatMessage chatMessage = chatService.saveMessage(teamId, chatMessageDto.getSender(), chatMessageDto.getContent());

        // broadcast path
        messagingTemplate.convertAndSend("/topic/api/v1/work/teams/" + teamId + "/chats", chatMessageDto);

        return chatMessage;
    }
}
