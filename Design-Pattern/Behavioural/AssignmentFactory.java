
import java.util.*;

public class AssignmentFactory {
    public enum Type { SIMPLE, RICH_RUBRIC }

    public static Assignment createAssignment(Type type, String title, String description) {
        switch (type) {
            case RICH_RUBRIC:
                return new RubricAssignment(title, description, "Default Rubric");
            case SIMPLE:
            default:
                return new Assignment(title, description);
        }
    }
}
