package go.it.spring;

import go.it.spring.controller.NoteController;
import go.it.spring.entity.Note;
import go.it.spring.services.NoteService;
import org.flywaydb.core.Flyway;
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
		Flyway flyway = Flyway.configure().dataSource("jdbc:h2:./test5", "sa", null).load();
		flyway.migrate();
		Note note = new Note("Note1", "some content");
		Note note2 = new Note("Note2", "some content");
		Note note3 = new Note("Note3", "some content");
		System.out.println(noteService.create(note));
		System.out.println(noteService.create(note2));
		System.out.println(noteService.create(note3));
	}
}
