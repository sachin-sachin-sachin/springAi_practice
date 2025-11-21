package com.example.springAi.springAi_test.config;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springAi.springAi_test.Advisers.TokenPrintAdviser;

@Configuration
public class ai_config {
	   @Bean
	    public ChatClient chatClient(ChatClient.Builder builder) {
	        return builder
	        		 .defaultAdvisors(new TokenPrintAdviser(), new SafeGuardAdvisor(List.of("games")))
	                .defaultSystem("You are a helpful coding assistant. You are an expert in coding.")
	                .defaultOptions(OllamaChatOptions.builder()
	                        .model("deepseek-coder:latest")
	                        .temperature(0.3)
	                        .build())
	                .build();
	    }
}
