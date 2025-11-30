package com.example.springAi.springAi_test.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.generation.augmentation.ContextualQueryAugmenter;
import org.springframework.ai.rag.preretrieval.query.expansion.MultiQueryExpander;
import org.springframework.ai.rag.preretrieval.query.transformation.RewriteQueryTransformer;
import org.springframework.ai.rag.preretrieval.query.transformation.TranslationQueryTransformer;
import org.springframework.ai.rag.retrieval.join.ConcatenationDocumentJoiner;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

// import reactor.core.publisher.Flux;

@Service
public class ChatServiceImpl implements ChatService {
	
	   @Value("classpath:/prompts/user-message.st")
	    private Resource userMessage;

	    @Value("classpath:/prompts/system-message.st")
	    private Resource systemMessage;
	
	private ChatClient chatclient;
	
	 private VectorStore vectorStore;
	
	public ChatServiceImpl(ChatClient chatclient,VectorStore vectorStore) {
		this.chatclient=chatclient;
		this.vectorStore = vectorStore;
	}

//	@Override
//	public String chat(String query) {
//		
//	//	Prompt prompt1=new Prompt(query);
//		
//	 String result=chatclient
//				.prompt(query)
//				.call()
//				.content();
//		
//		return result;
	
	
	

//    Prompt prompt = new Prompt(query);
//	
////    modify this prompt and extra things to prompt make it more interactive
//   String queryStr = "As an expert in coding and programing. Always write program in java . Now reply for this question :{query}";
//
//
//    var tutorials = chatclient
//            .prompt()
//            .user(u -> u.text(queryStr).param("query", queryStr))
//            .call()
//            .content();
//    return tutorials;
//
		
		
 // }
	

	
//public String chatTemplate() {
//
// //   first step
//    PromptTemplate strTemplate = PromptTemplate.builder().template("What is {techName}? tell ma also about {techExample}").build();
//  
//    //render the template
//    String renderedMessage = strTemplate.render(Map.of(
//            "techName", "Spring",
//            "techExample", "spring exception"
//    ));
//
//
//    Prompt prompt = new Prompt(renderedMessage);
//
//    var systemPromptTemplate=SystemPromptTemplate.builder()
//            .template("You are a helpful coding assistant. You are an expert in coding.")
//            .build();
//    var systemMessage=systemPromptTemplate.createMessage();
//
//    
//    var userPromptTemplate=PromptTemplate.builder().template("What is {techName}? tell ma also about {techExample}").build();
//    var userMessage=userPromptTemplate.createMessage(Map.of(
//            "techName", "Spring",
//            "techExample", "spring exception"
//    ));
//
//    Prompt prompt2 = new Prompt(systemMessage,userMessage);
//
//    return this.chatclient
//            .prompt()
//            .system(system ->
//                    system.text(this.systemMessage))
//            .user(user ->
//                    user.text(this.userMessage).param("concept", "Python iteration"))
//            .call()
//            .content()
//            ;
//}
	
	
	
//	   @Override
//	    public String chatTemplate(String query) {
//
//
//	        return this.chatclient
//
//	                .prompt()
////	                .advisors(new SimpleLoggerAdvisor())
//	                .system(system ->
//	                        system.text(this.systemMessage))
//	                .user(user ->
//	                        user.text(this.userMessage).param("concept", query))
//	                .call()
//	                .content()
//	                ;
//	    }
//
//
//	   
//	   @Override
//	    public Flux<String> streamChat(String query) {
//
//	        return  this.chatclient
//	                .prompt()
//	                .system(system-> system.text(this.systemMessage))
//	                .user(user-> user.text(this.userMessage).param("concept",query))
//	                .stream()
//	                .content();
//	    }
	
	
	
	// memory example
//	
//    @Override
//    public String chatTemplate(String query, String userId) {
//
//
//        return this.chatclient
//
//                .prompt()
//                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID,userId))
////                .advisors(new SimpleLoggerAdvisor())
//                .system(system ->
//                        system.text(this.systemMessage))
//                .user(user ->
//                        user.text(this.userMessage).param("concept", query))
//                .call()
//                .content()
//                ;
//    }
	
	
	
	
	//rag
	@Override
	public void saveData(List<String> list) {
	    System.out.println("Converting " + list.size() + " strings to documents...");
	    
	    List<Document> documentList = list.stream()
	            .map(Document::new)
	            .toList();
	    
	    System.out.println("Saving " + documentList.size() + " documents to vector store...");
	    System.out.println("This may take a while as embeddings are being generated...");
	    System.out.println("Started at: " + LocalDateTime.now());
	    
	    try {
	        this.vectorStore.add(documentList);
	        System.out.println("Completed at: " + LocalDateTime.now());
	        System.out.println("Vector store add() completed successfully!");
	    } catch (Exception e) {
	        System.err.println("ERROR: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	
//	  @Override
//   public String chatTemplate(String query, String userId) {
//		  return this.chatclient
//	                .prompt()
////	                .advisors(new SimpleLoggerAdvisor())
////	                .system(system ->
////	                        system.text(this.systemMessage).param("documents", contextData))
////	                .advisors(new QuestionAnswerAdvisor(vectorStore))
//	                .advisors(
//	                        QuestionAnswerAdvisor
//	                                .builder(vectorStore)
//	                                .searchRequest(SearchRequest.builder()
//	                                        .topK(3)
//	                                        .similarityThreshold(0.5)
//	                                        .build())
//	                                .build())
//	                .user(user ->
//
//                    user.text(this.userMessage).param("query", query))
//            .call()
//            .content()
//            ;
//	  }

	  
	  
//	  //rag vector - maria db store similarty response
//	   @Override
//	    public String chatTemplate(String query, String userId) {
//
//	     var advisor = RetrievalAugmentationAdvisor.builder()
//	                .documentRetriever(VectorStoreDocumentRetriever
//	                        .builder()
//	                        .vectorStore(this.vectorStore)
//	                        .topK(3)
//	                        .similarityThreshold(0.5)
//	                        .build())
//	                .queryAugmenter(ContextualQueryAugmenter.builder().allowEmptyContext(true).build())
//	                .build();
//
//
//	        return this.chatclient
//	                .prompt()
//	                .advisors(advisor)
//	                .user(user ->
//
//                    user.text(this.userMessage).param("query", query))
//            .call()
//            .content()
//            ;
//}
	
	 @Override
	    public String getResponse(String userQuery) {


	        var advisor = RetrievalAugmentationAdvisor.builder()

	                .queryTransformers(
	                        RewriteQueryTransformer.builder()
	                                .chatClientBuilder(chatclient.mutate().clone())
	                                .build(),
	                        TranslationQueryTransformer.builder().chatClientBuilder(chatclient.mutate().clone()).targetLanguage("hindi").build()

	                )
	                .queryExpander(MultiQueryExpander.builder().chatClientBuilder(chatclient.mutate().clone()).numberOfQueries(3).build())
	                .documentRetriever(
	                        VectorStoreDocumentRetriever.builder()
	                                .vectorStore(vectorStore)
	                                .topK(3)
	                                .similarityThreshold(0.3)
	                                .build()
	                )
	                .documentJoiner(new ConcatenationDocumentJoiner())
	                .queryAugmenter(ContextualQueryAugmenter.builder().build())
//	                .documentPostProcessors()


	                .build();


	        //actual call to llm

	        return chatclient
	                .prompt()
	                .advisors(advisor)
	                .user(userQuery)
	                .call()
	                .content();
	    }
}

