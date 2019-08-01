//Author Name: Sunit Shah
package com.example.notesbuddy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.notesbuddy.database.ProgramDataServices;
import com.example.notesbuddy.model.Program;

@Service
public class ProgramService implements IProgramService{

	@Override
	public List<Program> getAllPrograms() {
		// TODO Auto-generated method stub
		return ProgramDataServices.getAllPrograms();
	}

}
