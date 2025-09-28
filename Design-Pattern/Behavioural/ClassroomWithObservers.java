import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClassroomWithObservers implements Subject {
    private String name;
    private Map<String, StudentObserver> studentObservers = new HashMap<>();
    private Map<String, Assignment> assignments = new HashMap<>();
    private List<Observer> observers = new ArrayList<>();

    public ClassroomWithObservers(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void enroll(String studentId, StudentObserver student) {
        studentObservers.put(studentId, student);
        registerObserver(student);
    }

    public void scheduleAssignment(Assignment a) {
        assignments.put(a.getTitle(), a);
        notifyObservers(a);
    }

    public Map<String, Assignment> getAssignments() { return assignments; }

    @Override
    public void registerObserver(Observer o) { observers.add(o); }

    @Override
    public void removeObserver(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers(Assignment a) {
        for (Observer o : new ArrayList<>(observers)) {
            o.update(a);
        }
    }
}
