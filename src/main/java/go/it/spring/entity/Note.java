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

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Note() {

    }
}
