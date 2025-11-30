package com.example.springAi.springAi_test.services;

import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.stereotype.Service;

@Service
public class DataTransformerImpl implements DataTransformer{
	   @Override
	    public List<Document> transform(List<Document> documents) {
	        var splitter = new TokenTextSplitter(300,400,10,5000,true);
	        return splitter.transform(documents);
	    }
}
