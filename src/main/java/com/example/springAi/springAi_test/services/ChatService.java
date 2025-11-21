package com.example.springAi.springAi_test.services;

import reactor.core.publisher.Flux;

public interface ChatService {
//	 public String chat(String query);
	 
	//   public String chatTemplate();
	 
	  String chatTemplate(String query);
	   
	   Flux<String> streamChat(String query);
}
