package go.it.spring;

import go.it.spring.controller.NoteController;
import go.it.spring.entity.Note;
import go.it.spring.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@SpringBootApplication
public class SpringBootProjectApplication implements CommandLineRunner {

	@Autowired
	private NoteService noteService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Note note = new Note("Note1", "some content");
		Note note2 = new Note("Note2", "some content");
		noteService.add(note);
		noteService.add(note2);
	}
}
