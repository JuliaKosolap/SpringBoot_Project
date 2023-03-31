package go.it.spring.entity;

import lombok.Data;
@Data
public class Note {

    public Note(long randomId, String title, String content) {
        this.id = randomId;
        this.title = title;
        this.content = content;
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    long id;
    String title;
    String content;
}
