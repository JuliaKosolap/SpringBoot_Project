package go.it.spring.services;

import go.it.spring.entity.Note;
import go.it.spring.repos.NoteRepository;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository repository;
    private List<Note> noteList;


    public List<Note> listAll() {
        return noteList;
    }


        public Note create(Note note) {
            return repository.save(note);
        }

    public List<Note> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deleteById(long id) {
        boolean isIdExist = repository.existsById(id);
        if (isIdExist) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException();
        }
    }


    public void update(Note note) {
        long id = note.getId();
        boolean isIdExist = repository.existsById(id);
        if (isIdExist) {
            repository.save(note);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Note getById(long id) {
        Note note = null;
        boolean isIdExist = repository.existsById(id);
        if (isIdExist) {
            note = repository.getReferenceById(id);
        } else {
            throw new IllegalArgumentException();
        }
        return note;
    }

}
