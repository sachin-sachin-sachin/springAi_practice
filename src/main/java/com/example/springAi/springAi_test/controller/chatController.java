package com.example.springAi.springAi_test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springAi.springAi_test.services.ChatService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping
public class chatController {
	
	
//	  private ChatClient chatClient;
//
//	    public chatController(ChatClient.Builder builder) {
//	        this.chatClient = builder.build();

//	    }

//	    @GetMapping("/chat")
//	    public ResponseEntity<String> chat(
//	            @RequestParam(value = "q") String query
//	    ) {
//	        String responseContent = this.chatClient.prompt(query).call().content();
//	        return ResponseEntity.ok(responseContent);
//	    }
	
	
//	private ChatService chatservice;
//	
//	public chatController(ChatService chatservice) {
//		this.chatservice=chatservice;
//	}
	    
//	    @GetMapping("/chat")
//	    public ResponseEntity<String> chat(
//	            @RequestParam(value = "q") String query
//	    ) {
//	        return ResponseEntity.ok(chatservice.chat(query));
//	    }
	
	
	
	
	
//	private ChatService chatservice;
//	
//	public chatController(ChatService chatservice) {
//		this.chatservice=chatservice;
//	}
//	
//	  @GetMapping("/chat")
//	    public ResponseEntity<String> chat(
//	            @RequestParam(value = "q", required = true) String q) {
//	        return ResponseEntity.ok(chatservice.chatTemplate(q));
//	    }
//	  
//	    
//	    @GetMapping("/stream-chat")
//	    public ResponseEntity<Flux<String>> streamChat(
//	            @RequestParam("q") String query
//	    ){
//	        return ResponseEntity.ok(this.chatservice.streamChat(query));
//	    }
	
	
	
//	// Memory Example _____________________________________________________ // 
//	  private ChatService chatService;
//
//	    public chatController(ChatService chatService) {
//	        this.chatService = chatService;
//	    }
//
//	    @GetMapping("/chat")
//	    public ResponseEntity<String> chat(
//	            @RequestParam(value = "q", required = true) String q,
//	            @RequestHeader("userId") String userId
//	            ) {
//	        return ResponseEntity.ok(chatService.chatTemplate(q,userId));
//	    } 
	
	
	
	
	// advance_rag
	private ChatService chatService;
	
		    public chatController(ChatService chatService) {
		        this.chatService = chatService;
		    }
		    
	   @PostMapping("/chat")
    public ResponseEntity<String> getResponse(@RequestParam("q") String userQuery){
        return ResponseEntity.ok(chatService.getResponse(userQuery));
    }


}
