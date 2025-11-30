package com.example.springAi.springAi_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springAi.springAi_test.tool.WeatherTool;

@SpringBootTest
class SpringAiTestApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	  private @Autowired
	  WeatherTool weatherTool;


	    @Test
	    void getWeatherTest() {
	    	     var response = weatherTool.getWeather("Delhi India");
				 System.out.println(response);
			
	    }

}
