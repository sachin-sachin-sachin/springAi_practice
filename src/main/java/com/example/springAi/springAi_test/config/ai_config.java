package com.example.springAi.springAi_test.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springAi.springAi_test.Advisers.TokenPrintAdviser;

@Configuration
public class ai_config {
	
	  @Bean
	    public ChatMemory chatMemory(JdbcChatMemoryRepository jdbcChatMemoryRepository){
	        return MessageWindowChatMemory.builder()
	                .chatMemoryRepository(jdbcChatMemoryRepository)
	                .maxMessages(10)
	                .build();
	  }
	  
	        
	        private Logger logger = LoggerFactory.getLogger(ai_config.class);
	        
	   @Bean
	    public ChatClient chatClient(ChatClient.Builder builder, ChatMemory chatMemory) {
		   
		   this.logger.info("ChatMemoryImplementation class: " + chatMemory.getClass().getName());
	        MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();
	   
	        return builder
	        		 .defaultAdvisors(messageChatMemoryAdvisor,new TokenPrintAdviser(), new SafeGuardAdvisor(List.of("games")))
	                .defaultSystem("You are a helpful coding assistant. You are an expert in coding.")
	                .defaultOptions(OllamaChatOptions.builder()
	                        .model("deepseek-coder:latest")
	                        .temperature(0.3)
	                        .build())
	                .build();
	    }
}
