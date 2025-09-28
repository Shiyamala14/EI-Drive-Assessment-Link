import java.util.*;

public class RubricAssignment extends Assignment {
    private String rubric;

    public RubricAssignment(String title, String description, String rubric) {
        super(title, description);
        this.rubric = rubric;
    }

    public String getRubric() { return rubric; }

    @Override
    public String toString() {
        return "RubricAssignment{" + title + ", rubric=" + rubric + "}";
    }
}
