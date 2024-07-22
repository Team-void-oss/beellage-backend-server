package com.oss.beellage.chat.controller;

import com.oss.beellage.chat.Chat;
import com.oss.beellage.chat.collection.ChatConverter;
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
    public List<ChatMessageDto> getMessages(@PathVariable("teamId") Long teamId) {
        return ChatConverter.convertToDto(
                chatService.getMessagesForTeam(teamId)
        );
    }

    @Override
    @PostMapping
    public ChatMessageDto sendMessage(@PathVariable("teamId") Long teamId, @RequestBody ChatMessageDto chatMessageDto) {
        Chat c = chatService.saveMessage(teamId, chatMessageDto.getUserId(), chatMessageDto.getMessage());
        ChatMessageDto dto = new ChatMessageDto(c.getId(), c.getSender().getNickname(), c.getMessage());
        // broadcast path
        messagingTemplate.convertAndSend("/chatting/api/v1/work/teams/" + teamId + "/chats",
                dto);

        return dto;
    }
}
