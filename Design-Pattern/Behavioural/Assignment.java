import java.util.*;

public class Assignment {
    protected String title;
    protected String description;

    public Assignment(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "Assignment{" + title + "}";
    }
}
