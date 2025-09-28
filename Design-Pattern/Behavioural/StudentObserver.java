public class StudentObserver implements Observer {
    private final String studentId;

    public StudentObserver(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public void update(Assignment a) {
        System.out.println("[Observer] Student " + studentId + " notified of new assignment: " + a.getTitle());
    }
}
