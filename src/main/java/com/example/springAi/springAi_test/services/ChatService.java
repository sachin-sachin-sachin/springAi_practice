package com.example.springAi.springAi_test.services;

import java.util.List;

import reactor.core.publisher.Flux;

public interface ChatService {
//	 public String chat(String query);
	 
	//   public String chatTemplate();
	 
//	  String chatTemplate(String query);
//	   
//	   Flux<String> streamChat(String query);
	
	
	// Memory Example
//	  String chatTemplate(String query, String userId);
	  
	  //rag
	  void saveData(List<String> list);
	  
	  // rag similar response by llm by read from vector 
	  String chatTemplate(String query, String userId);
}
