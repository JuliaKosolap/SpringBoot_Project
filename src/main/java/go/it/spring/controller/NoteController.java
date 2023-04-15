package go.it.spring.controller;

import go.it.spring.entity.Note;
import go.it.spring.mapper.NoteMapper;
import go.it.spring.model.NoteDTO;
import go.it.spring.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public NoteDTO create(@RequestBody NoteDTO dto) {
        Note note = NoteMapper.from(dto);
        note = noteService.create(note);
        return NoteMapper.from(note);
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("note/list");
        List<Note> notes = noteService.findAll();
        result.addObject("notes", notes);
        return result;
    }

    @GetMapping("/edit")
    public ModelAndView getEditForm(@RequestParam long id) {
        Note note = noteService.getById(id);
        ModelAndView result = new ModelAndView("note/edit");
        result.addObject("note", note);
        return result;
    }

    @PostMapping("/save")
    public ModelAndView editNote(@ModelAttribute("note") Note note, Model model) {
        noteService.update(note);
        ModelAndView result = new ModelAndView("redirect:/note/list");
        List<Note> notes = noteService.findAll();
        result.addObject("notes", notes);
        return result;
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam long id) {
        noteService.deleteById(id);
        ModelAndView result = new ModelAndView("redirect:/note/list");
        List<Note> notes = noteService.findAll();
        result.addObject("notes", notes);
        return result;
    }


}
