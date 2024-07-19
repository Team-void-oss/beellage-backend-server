package com.oss.beellage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 주제를 명확히 설정 (예: /api/v1/work/teams/{teamId}/chats)
        config.enableSimpleBroker("/api/v1/work/teams");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/api/v1/work/teams/{teamId}/chats").setAllowedOrigins("*").withSockJS();
        registry.addEndpoint("/api/v1/work/teams/{teamId}/village/{villageId}").setAllowedOrigins("*").withSockJS();
    }
}

