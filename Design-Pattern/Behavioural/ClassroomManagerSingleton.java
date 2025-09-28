import java.util.HashMap;
import java.util.Map;


public class ClassroomManagerSingleton {
    private static ClassroomManagerSingleton instance;
    private Map<String, Classroom> classrooms;

    private ClassroomManagerSingleton() {
        classrooms = new HashMap<>();
    }

    public static synchronized ClassroomManagerSingleton getInstance() {
        if (instance == null) {
            instance = new ClassroomManagerSingleton();
        }
        return instance;
    }

    public void addClassroom(String name) {
        if (classrooms.containsKey(name)) throw new IllegalArgumentException("Classroom already exists.");
        classrooms.put(name, new Classroom(name));
    }

    public Classroom getClassroom(String name) {
        if (!classrooms.containsKey(name)) throw new IllegalArgumentException("Classroom not found.");
        return classrooms.get(name);
    }
}
