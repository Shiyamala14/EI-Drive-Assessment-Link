import java.util.*;

public class VirtualClassroomApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ClassroomManager manager = new ClassroomManager();

    public static void main(String[] args) {
        System.out.println();
        System.out.println("=== Virtual Classroom Manager ===");
        System.out.println();
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getIntInput("Choose an option: ");
            System.out.println();

            try {
                switch (choice) {
                    case 1 -> addClassroom();
                    case 2 -> addStudent();
                    case 3 -> scheduleAssignment();
                    case 4 -> submitAssignment();
                    case 5 -> listClassrooms();
                    case 6 -> removeClassroom();
                    case 7 -> listStudentsInClass();
                    case 8 -> listAssignmentsInClass();
                    case 9 -> {
                        System.out.println("Exiting application. Goodbye!");
                        System.out.println();
                        running = false;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n-------- MENU --------");
        System.out.println("1. Add Classroom");
        System.out.println("2. Add Student to Classroom");
        System.out.println("3. Schedule Assignment");
        System.out.println("4. Submit Assignment");
        System.out.println("5. List Classrooms");
        System.out.println("6. Remove Classroom");
        System.out.println("7. List Students in a Classroom");
        System.out.println("8. List Assignments in a Classroom");
        System.out.println("9. Exit");
        System.out.println("----------------------");
        System.out.println();
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static String getLineInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    private static void addClassroom() {
        String name = getLineInput("Enter classroom name: ");
        System.out.println();
        manager.addClassroom(name);

        System.out.println("Classroom '" + name + "' has been created.");
    }
    private static void addStudent() {
        String className = getLineInput("Enter classroom name: ");
        System.out.println();
        String studentId = getLineInput("Enter student ID: ");
        System.out.println();
        Classroom classroom = manager.getClassroom(className);
        classroom.addStudent(studentId);
        System.out.println("Student '" + studentId + "' has been enrolled in '" + className + "'.");
    }

    private static void scheduleAssignment() {
        String className = getLineInput("Enter classroom name: ");
        System.out.println();
        String title = getLineInput("Enter assignment title: ");
        System.out.println();
        String description = getLineInput("Enter assignment description: ");
        System.out.println();
        Classroom classroom = manager.getClassroom(className);
        classroom.scheduleAssignment(title, description);
        System.out.println("Assignment scheduled for class '" + className + "'.");
    }

    private static void submitAssignment() {
        String className = getLineInput("Enter classroom name: ");
        System.out.println();
        String studentId = getLineInput("Enter student ID: ");
        System.out.println();
        String title = getLineInput("Enter assignment title: ");
        System.out.println();
        String details = getLineInput("Enter submission details: ");
        System.out.println();
        Classroom classroom = manager.getClassroom(className);
        classroom.submitAssignment(studentId, title, details);
        System.out.println("Assignment submitted by '" + studentId + "' in class '" + className + "'.");
    }

    private static void listClassrooms() {
        manager.listClassrooms();
    }

    private static void removeClassroom() {
        String className = getLineInput("Enter classroom name to remove: ");
        System.out.println();
        manager.removeClassroom(className);
        System.out.println("Classroom '" + className + "' has been removed.");
    }

    private static void listStudentsInClass() {
        String className = getLineInput("Enter classroom name: ");
        System.out.println();
        Classroom classroom = manager.getClassroom(className);
        Map<String, Student> students = classroom.getStudents();
        if (students.isEmpty()) {
            System.out.println("No students enrolled in '" + className + "'.");
        } else {
            System.out.println("Students in '" + className + "':");
            for (String studentId : students.keySet()) {
                System.out.println("- " + studentId);
            }
        }
    }

    private static void listAssignmentsInClass() {
        String className = getLineInput("Enter classroom name: ");
        System.out.println();
        Classroom classroom = manager.getClassroom(className);
        Map<String, Assignment> assignments = classroom.getAssignments();
        if (assignments.isEmpty()) {
            System.out.println("No assignments scheduled in '" + className + "'.");
        } else {
            System.out.println("Assignments in '" + className + "':");
            for (Assignment assignment : assignments.values()) {
                System.out.println("- " + assignment.getTitle() + ": " + assignment.getDescription());
            }
        }
    }
}
