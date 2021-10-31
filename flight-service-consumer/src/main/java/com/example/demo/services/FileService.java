package com.example.demo.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class FileService {

	public void save(String message) {
		
		Path path = Paths.get("FligtDetails.txt");
		
		try {
			
			Files.writeString(path, message);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
