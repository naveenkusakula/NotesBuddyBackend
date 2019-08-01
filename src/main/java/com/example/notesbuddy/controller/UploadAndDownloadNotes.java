// Author: Naveen Kusakula 
package com.example.notesbuddy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.notesbuddy.model.Notes;
import com.example.notesbuddy.services.NotesService;
import com.example.notesbuddy.services.uploadImageFile;

@RestController
public class UploadAndDownloadNotes {
	@Autowired
	NotesService notesService;

	@Autowired
	uploadImageFile uploadFile;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/notes/upload", method = RequestMethod.POST)
	public ResponseEntity<Notes> upload(@RequestBody Notes note) {

		Notes createdNotes = notesService.save(note);

		if (null == createdNotes) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(createdNotes);

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/notes/download/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> download(@PathVariable Long id) throws IOException {
		Notes note = notesService.getNotes(id);
		String filename = note.getLocation();
		FileWriter filewriter = null;
		try {

			File file = new File(filename);

			InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			headers.add("Pragma", "no-cache");
			headers.add("Expires", "0");

			ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
					.contentType(MediaType.parseMediaType("application/pdf")).body(resource);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<>("error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			if (filewriter != null)
				filewriter.close();
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/notes/savenotes", method = RequestMethod.POST)
	public ResponseEntity<Notes> savenotes(@RequestParam("file") MultipartFile file) {
		Notes savedNotes = uploadFile.saveFile(file);
		return ResponseEntity.ok(savedNotes);
	}

}
