import java.util.*;


class Classroom {
    private String name;
    private Map<String, Student> students;
    private Map<String, Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new HashMap<>();
        this.assignments = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(String studentId) {
        if (students.containsKey(studentId)) {
            throw new IllegalArgumentException("Student Already Enrolled.");
        }
        students.put(studentId, new Student(studentId));
    }

    public void scheduleAssignment(String title, String description) {
        if (assignments.containsKey(title)) {
            throw new IllegalArgumentException("Assignment Already Exists.");
        }
        assignments.put(title, new Assignment(title, description));
    }

    public void submitAssignment(String studentId, String title, String details) {
        if (!students.containsKey(studentId)) {
            throw new IllegalArgumentException("Student not found.");
        }
        if (!assignments.containsKey(title)) {
            throw new IllegalArgumentException("Assignment not found.");
        }
        students.get(studentId).submitAssignment(title, details);
    }

    public Map<String, Student> getStudents() {
        return students;
    }

    public Map<String, Assignment> getAssignments() {
        return assignments;
    }
}

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
            throw new IllegalArgumentException("Classroom not found.");
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
            System.out.println("No Classrooms Available.");
        } else {
            int count=0;
            System.out.println("________Available Classrooms________");
            for (String name : classrooms.keySet()) {
                count++;
                System.out.println(count + ". " + name);
            }

            System.out.println();
            System.out.println("Number of ClassRooms :" + count);

            System.out.println("____________________________________");
        }
    }
}
