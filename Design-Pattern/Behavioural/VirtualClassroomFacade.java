import java.util.HashMap;
import java.util.Map;

public class VirtualClassroomFacade {
    private Map<String, ClassroomWithObservers> rooms = new HashMap<>();
    private Map<String, Map<String, String>> submissions = new HashMap<>();

    public void createClassroom(String name) {
        rooms.put(name, new ClassroomWithObservers(name));
        submissions.put(name, new HashMap<>());
        System.out.println("[Facade] Classroom created: " + name);
    }

    public void enrollStudent(String className, String studentId) {
        ClassroomWithObservers c = rooms.get(className);
        if (c == null) throw new IllegalArgumentException("Classroom not found.");
        StudentObserver student = new StudentObserver(studentId);
        c.enroll(studentId, student);
        System.out.println("[Facade] Enrolled " + studentId + " to " + className);
    }

    public void scheduleAssignment(String className, Assignment a) {
        ClassroomWithObservers c = rooms.get(className);
        if (c == null) throw new IllegalArgumentException("Classroom not found.");
        c.scheduleAssignment(a);
        System.out.println("[Facade] Scheduled " + a.getTitle() + " in " + className);
    }

    public void submit(String className, String studentId, String assignmentTitle, String details) {
        Map<String, String> classSubs = submissions.get(className);
        if (classSubs == null) throw new IllegalArgumentException("Classroom not found.");
        String key = studentId + ":" + assignmentTitle;
        classSubs.put(key, details);
        System.out.println("[Facade] " + studentId + " submitted " + assignmentTitle + " in " + className);
    }

    public String getSubmission(String className, String studentId, String assignmentTitle) {
        Map<String, String> classSubs = submissions.get(className);
        String key = studentId + ":" + assignmentTitle;
        return (classSubs == null) ? null : classSubs.get(key);
    }
}
