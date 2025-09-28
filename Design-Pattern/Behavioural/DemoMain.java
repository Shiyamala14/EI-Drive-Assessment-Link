import java.util.*;

public class DemoMain {
    public static void main(String[] args) {
        System.out.println("=== Demo Start ===\n");

        // 1) Creational - Singleton
        System.out.println("-- Singleton (ClassroomManagerSingleton) demo --");
        ClassroomManagerSingleton manager = ClassroomManagerSingleton.getInstance();
        manager.addClassroom("CS101");
        System.out.println("Singleton created classroom: " + manager.getClassroom("CS101").getName());
        System.out.println();

        // 2) Creational - Factory
        System.out.println("-- Factory (AssignmentFactory) demo --");
        Assignment a1 = AssignmentFactory.createAssignment(AssignmentFactory.Type.SIMPLE, "Basic HW", "Solve Q1-Q3");
        Assignment a2 = AssignmentFactory.createAssignment(AssignmentFactory.Type.RICH_RUBRIC, "Project", "Make a project");
        System.out.println("Created: " + a1);
        System.out.println("Created: " + a2);
        System.out.println();

        // 3) Behavioral - Observer
        System.out.println("-- Observer demo --");
        ClassroomWithObservers clo = new ClassroomWithObservers("CS101-OBS");
        StudentObserver sA = new StudentObserver("alice");
        StudentObserver sB = new StudentObserver("bob");
        clo.enroll("alice", sA);
        clo.enroll("bob", sB);
        clo.scheduleAssignment(a1); // both observers get notified
        System.out.println();

        // 4) Behavioral - Strategy
        System.out.println("-- Strategy (grading) demo --");
        SubmissionEvaluator evaluator = new SubmissionEvaluator(new SimplePointsStrategy());
        String submission = "My answer: complete and correct"; // toy
        double gradeSimple = evaluator.evaluate(submission, a1);
        System.out.println("SimplePointsStrategy grade: " + gradeSimple);

        evaluator.setStrategy(new RubricBasedStrategy());
        double gradeRubric = evaluator.evaluate(submission, a2);
        System.out.println("RubricBasedStrategy grade: " + gradeRubric);
        System.out.println();

        // 5) Structural - Facade
        System.out.println("-- Facade demo --");
        VirtualClassroomFacade facade = new VirtualClassroomFacade();
        facade.createClassroom("ENG201");
        facade.enrollStudent("ENG201", "charlie");
        facade.scheduleAssignment("ENG201", a1);
        facade.submit("ENG201", "charlie", a1.getTitle(), "My essay - complete");
        String got = facade.getSubmission("ENG201", "charlie", a1.getTitle());
        System.out.println("Facade retrieved submission: " + got);
        System.out.println();

        // 6) Structural - Adapter
        System.out.println("-- Adapter demo --");
        ExternalEmailService external = new ExternalEmailService();
        Notifier emailAdapter = new EmailAdapter(external, "university.edu");
        emailAdapter.notifyUser("diana", "New assignment posted: " + a1.getTitle());
        System.out.println();

        System.out.println("=== Demo End ===");
    }
}
