package com.enotes.schdular;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.enotes.entity.Notes;
import com.enotes.repository.NotesRepository;

@Component
public class NotesSchedular {

	@Autowired
	private NotesRepository notesRepo;

	@Scheduled(cron = "0 0 0 * * ?")
//	@Scheduled(cron = "* * * ? * *")
	public void deleteNotesSchdular() {
		
		LocalDateTime cutOffDate = LocalDateTime.now().minusDays(7);
		List<Notes> deleteNotes = notesRepo.findAllByIsDeletedAndDeletedOnBefore(true, cutOffDate);
		notesRepo.deleteAll(deleteNotes);
	}

}
