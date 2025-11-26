package com.example.springAi.springAi_test;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springAi.springAi_test.helper.Helper;
import com.example.springAi.springAi_test.services.ChatService;

@SpringBootTest
class SpringAiTestApplicationTests {

	@Test
	void contextLoads() {
		
	}

//	@Autowired
//	private ChatService chatService;
//	@Test
//	void testTemplateRender(){
//
//		System.out.println("Template Renderer");
//
//		var output=this.chatService.chatTemplate();
//		System.out.println(output);
//
//	}
	
	   @Autowired
	    private  ChatService chatService;
//	    @Test
//	    void saveDataToVectorDatabase(){
//	        System.out.println("saving data to database");
//	        this.chatService.saveData(Helper.getData());
//	        try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        System.out.println("data is saved successfully");
//	    }
	   
	   @Timeout(value = 60, unit = TimeUnit.SECONDS) // Allow 60 seconds
	   @Test
	   void saveDataToVectorDatabase() throws InterruptedException {
	       System.out.println("saving data to database");
	       this.chatService.saveData(Helper.getData());
	       
	       Thread.sleep(30000); // Wait for embeddings
	       
	       System.out.println("data is saved successfully");
	   }

}
