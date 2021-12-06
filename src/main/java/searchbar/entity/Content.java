package searchbar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Content {

    @Id
    private int id;
    private String title;
    private String duration;
    private String description;
    private String type;
    private String date;
    private int directorId;

    public Content() {
        this(0, "", "", "", "", "", 0);
    }

    public Content(String title, String duration, String description, String type, String date, int directorId) {
        this(0, title, duration, description, type, date, directorId);
    }

    public Content(int id, String title, String duration, String description, String type, String date, int directorId) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.type = type;
        this.date = date;
        this.directorId = directorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

}
