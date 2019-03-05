package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Book {
	
	@NonNull
	private String id;
	@NonNull
	private String title;
	@NonNull
	private String author;

}
