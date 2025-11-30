package com.example.springAi.springAi_test.services;

import java.util.List;

import org.springframework.ai.document.Document;

public interface DataTransformer {
	  List<Document> transform(List<Document> documents);
}
