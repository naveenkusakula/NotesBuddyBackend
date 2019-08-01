package com.example.notesbuddy.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.notesbuddy.model.Notes;

@Repository
public interface INotesRepository extends CrudRepository<Notes, Long> {
	public Notes save(Notes notes);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE notes SET average_rating = ?1 WHERE id = ?2", nativeQuery = true)
    public void updateAverageRating( long averageRating, long notesID);
}
