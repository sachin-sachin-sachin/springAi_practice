package com.example.springAi.springAi_test.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ai_config {
	   @Bean
	    public ChatClient chatClient(ChatClient.Builder builder) {
	        return builder
	                .defaultSystem("You are a helpful coding assistant. You are an expert in coding.")
	                .defaultOptions(OllamaChatOptions.builder()
	                        .model("qwen3:4b")
	                        .temperature(0.3)
	                        .build())
	                .build();
	    }
}
