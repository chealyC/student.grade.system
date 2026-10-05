import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class StudentData {
    ArrayList<Student> students = new ArrayList<>();

    public void createStudents() {

        // John's subjects and grades
        ArrayList<Subject> johnSubjects = new ArrayList<>();

        johnSubjects.add(new Subject("Computer Science", 20, new Grade(85)));
        johnSubjects.add(new Subject("Mathematics", 20, new Grade(72)));
        johnSubjects.add(new Subject("Artificial Intelligence", 40, new Grade(91)));

        Student student1 = new Student("John", 21, johnSubjects, 22343);


        // Sarah's subjects and grades
        ArrayList<Subject> sarahSubjects = new ArrayList<>();

        sarahSubjects.add(new Subject("Computer Science", 20, new Grade(63)));
        sarahSubjects.add(new Subject("Mathematics", 20, new Grade(55)));
        sarahSubjects.add(new Subject("Artificial Intelligence", 40, new Grade(61)));

        Student student2 = new Student("Sarah", 22, sarahSubjects, 22344);


        // Alex's subjects and grades
        ArrayList<Subject> alexSubjects = new ArrayList<>();

        alexSubjects.add(new Subject("Computer Science", 20, new Grade(44)));
        alexSubjects.add(new Subject("Mathematics", 20, new Grade(52)));
        alexSubjects.add(new Subject("Artificial Intelligence", 40, new Grade(42)));

        Student student3 = new Student("Alex", 20, alexSubjects, 22345);


        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("0: View all students");
            System.out.println("1: Add student");
            System.out.println("2: Find student");
            System.out.println("3: Remove student");
            System.out.println("4: Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    for (Student student : students) {
                        System.out.println("Student ID: " + student.getStudentId());
                        System.out.println("Student name: " + student.getName());
                        System.out.println("Student age: " + student.getAge());

                        System.out.println("Subjects:");
                        student.displaySubjects();

                        System.out.println("Average: " +
                                (String.format("%.1f", student.calculateAverage()) + "%"));

                        System.out.println("Classification: " +
                                student.calculateClassification());

                        System.out.println();
                    }
                    break;

                case 1:
                    addStudent();
                    break;

                case 2:
                    findStudent();
                    break;

                case 3:
                    removeStudent();
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        ArrayList<Subject> subjects = new ArrayList<>();

        System.out.print("Enter number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        for (int i = 0; i < numberOfSubjects; i++) {
            scanner.nextLine();

            System.out.print("Enter subject name: ");
            String subjectName = scanner.nextLine();

            System.out.print("Enter subject credits: ");
            int credits = scanner.nextInt();

            System.out.print("Enter grade: ");
            int grade = scanner.nextInt();

            subjects.add(
                    new Subject(
                            subjectName,
                            credits,
                            new Grade(grade)
                    )
            );
        }

    Student student = new Student(
            name,
            age,
            subjects,
            studentId
    );

    students.add(student);

    System.out.println("Student and their subjects " +
            "have been added successfully");
    }

    public void findStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                System.out.println("Student ID: " + student.getStudentId());
                System.out.println("Student Name: " + student.getName());
                System.out.println("Student Age: " + student.getAge());

                System.out.println("Subjects: ");
                student.displaySubjects();

                System.out.println("Average: " +
                        String.format("%.1f", student.calculateAverage()) + "%");

                System.out.println("Classification: " +
                        student.calculateClassification());

                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void removeStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();

            if (student.getStudentId() == studentId) {
                iterator.remove();

                System.out.println("Student removed successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}