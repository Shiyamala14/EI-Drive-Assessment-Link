import java.util.HashMap;
import java.util.Map;

public class Classroom {
    private String name;
    private Map<String, Assignment> assignments = new HashMap<>();

    public Classroom(String name) { this.name = name; }

    public String getName() { return name; }

    public void schedule(Assignment a) {
        assignments.put(a.getTitle(), a);
    }
}
