package go.it.spring.services;

import go.it.spring.entity.Note;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NoteService {
    private List<Note> noteList;

    public List<Note> listAll() {
        return noteList;
    }

    public Note add(Note note) {
        boolean isIdExists = true;
        Random random = new Random();
        long randomId = 0;
        if (noteList != null) {
            while (isIdExists) {
                randomId = random.nextLong();
                isIdExists = checkIfIdExists(randomId);
            }
        } else {
            noteList = new ArrayList<>();
        }
        Note newNote = new Note(randomId, note.getTitle(), note.getContent());
        noteList.add(newNote);
        return newNote;
    }

    public void deleteById(long id) {
        boolean isIdExist = checkIfIdExists(id);
        if (isIdExist) {
            for (int i = 0; i < noteList.size(); i++) {
                if (noteList.get(i).getId() == id) {
                    noteList.remove(noteList.get(i));
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }


    public void update(Note note) {
        long id = note.getId();
        boolean isIdExist = checkIfIdExists(id);
        if (isIdExist) {
            for (int i = 0; i < noteList.size(); i++) {
                if (noteList.get(i).getId() == id) {
                    noteList.get(i).setTitle(note.getTitle());
                    noteList.get(i).setContent(note.getContent());
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Note getById(long id) {
        Note note = null;
        boolean isIdExist = checkIfIdExists(id);
        if (isIdExist) {
            for (int i = 0; i < noteList.size(); i++) {
                if (noteList.get(i).getId() == id) {
                    note = new Note(noteList.get(i).getId(), noteList.get(i).getTitle(), noteList.get(i).getContent());
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return note;
    }

    private boolean checkIfIdExists(long id) {
        boolean isIdExist = false;
        if (noteList != null) {

            for (int i = 0; i < noteList.size(); i++) {
                if (noteList.get(i).getId() == id) {
                    isIdExist = true;
                }
            }
        } else {
            System.out.println("List of notes is empty");
        }
        return isIdExist;
    }

}
