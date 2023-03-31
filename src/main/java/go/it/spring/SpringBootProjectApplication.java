package go.it.spring;

import go.it.spring.entity.Note;
import go.it.spring.services.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootProjectApplication.class, args);
		NoteService service = new NoteService();
		Note note = new Note("Note1", "some content");
		Note note2 = new Note("Note2", "some content");
		Note addedNote = service.add(note);
		Note addedNote2 = service.add(note2);
		System.out.println("New note id: " + addedNote.getId());
		System.out.println("New note id: " + addedNote2.getId());
		Note note3 = new Note(0, "Note3", "some new content");
		service.update(note3);
		System.out.println(service.getById(addedNote2.getId()));
		System.out.println(service.listAll());
		service.deleteById(0);
	}

}
