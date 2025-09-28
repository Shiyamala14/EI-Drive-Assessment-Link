import java.util.*;

class ClassroomManager {
    private Map<String, Classroom> classrooms;

    public ClassroomManager() {
        this.classrooms = new HashMap<>();
    }

    public void addClassroom(String name) {
        if (classrooms.containsKey(name)) {
            throw new IllegalArgumentException("Classroom already exists.");
            
        }
        classrooms.put(name, new Classroom(name));
    }

    public void removeClassroom(String name) {
        if (!classrooms.containsKey(name)) {
            throw new IllegalArgumentException("Classroom is not Found!.");
            
        }
        classrooms.remove(name);
    }

    public Classroom getClassroom(String name) {
        if (!classrooms.containsKey(name)) {
            throw new IllegalArgumentException("Classroom does not exist.");
            
        }
        return classrooms.get(name);
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms are available.");
            System.out.println();
        } else {
            System.out.println("________ Available Classrooms ________");
            System.out.println();
            System.out.println();
            int count = 0;
            for (String name : classrooms.keySet()) {
                count++;
                System.out.println(count +". " + name);
            }
            System.out.println();
            System.out.println("Number of Classrooms :" + count);
            System.out.println("______________________________________");
        }
    }
}
