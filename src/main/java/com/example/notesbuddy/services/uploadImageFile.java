// Author: Naveen Kusakula 
package com.example.notesbuddy.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.notesbuddy.model.Notes;

@Service
public class uploadImageFile {
	private String defaultLocationToSaveFile = "./src/files";

	private Notes savedNotes;

	uploadImageFile() {
		savedNotes = new Notes();
	}

	public Notes saveFile(MultipartFile fileToBeUploaded) {
		FileOutputStream output;
		File createTemporaryFileToWrite;
		//Path fileStorageLocationPath = Paths.get(defaultLocationToSaveFile).toAbsolutePath().normalize();
		//String fileStorageLocation = fileStorageLocationPath.toString();

		try {
			createTemporaryFileToWrite = new File("src/files/"+fileToBeUploaded.getOriginalFilename());
			output = new FileOutputStream("src/files/"+fileToBeUploaded.getOriginalFilename());
			output.write(fileToBeUploaded.getBytes());
			savedNotes.setLocation("src/files/"+fileToBeUploaded.getOriginalFilename());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return savedNotes;
	}

}
