import java.util.*;

class Student {
    private String studentId;
    private Map<String, String> submissions;

    public Student(String studentId) {
        this.studentId = studentId;
        this.submissions = new HashMap<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void submitAssignment(String assignmentTitle, String details) {
        submissions.put(assignmentTitle, details);
    }

    public Map<String, String> getSubmissions() {
        return submissions;
    }
}

class Assignment {
    private String title;
    private String description;

    public Assignment(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
