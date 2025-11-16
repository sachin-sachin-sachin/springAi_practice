package com.example.springAi.springAi_test.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import com.example.springAi.springAi_test.Entity.test_ai_object_response;

@Service
public class ChatServiceImpl implements ChatService {
	
	private ChatClient chatclient;
	
	public ChatServiceImpl(ChatClient.Builder builder) {
		this.chatclient=builder.build();
	}

	@Override
	public test_ai_object_response chat(String query) {
		
		Prompt prompt1=new Prompt(query);
		
	test_ai_object_response result=chatclient
				.prompt(prompt1)
				.call()
				.entity(test_ai_object_response.class);
		
//		  test_ai_object_response result = chatclient
//			        .prompt()
//			        .system("You are a helpful assistant that responds ONLY in valid JSON format. " +
//			                "Never include explanatory text, markdown code blocks, or any formatting. " +
//			                "Return only the raw JSON object.")
//			        .user(query)
//			        .call()
//			        .entity(test_ai_object_response.class);
		
		return result;
	}

}
