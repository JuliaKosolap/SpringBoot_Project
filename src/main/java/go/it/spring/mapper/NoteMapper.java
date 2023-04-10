package go.it.spring.mapper;

import go.it.spring.entity.Note;
import go.it.spring.model.NoteDTO;

public class NoteMapper {
    public static NoteDTO from(Note note) {
        NoteDTO dto = new NoteDTO();

        dto.setId(note.getId());
        dto.setTitle(note.getTitle());;
        dto.setContent(note.getContent());
        return dto;
    }

    public static Note from(NoteDTO dto) {
        Note note = new Note();
        note.setId(dto.getId());
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        return note;
    }
}
