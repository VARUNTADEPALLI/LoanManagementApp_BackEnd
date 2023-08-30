package com.vaun.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	
	  @Override
	  public void configureMessageBroker(MessageBrokerRegistry config) {
	    config.enableSimpleBroker("/lesson");
	    config.setApplicationDestinationPrefixes("/app");
	  }

	  @Override
	  public void registerStompEndpoints(StompEndpointRegistry registry) {
	    registry.addEndpoint("/gs-guide-websocket").withSockJS();
	  }

}
