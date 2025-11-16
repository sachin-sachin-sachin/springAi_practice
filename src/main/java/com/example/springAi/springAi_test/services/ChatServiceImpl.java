package com.example.springAi.springAi_test.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {
	
	private ChatClient chatclient;
	
	public ChatServiceImpl(ChatClient chatclient) {
		this.chatclient=chatclient;
	}

	@Override
	public String chat(String query) {
		
	//	Prompt prompt1=new Prompt(query);
		
	 String result=chatclient
				.prompt(query)
				.call()
				.content();
		
		return result;
	}

}
