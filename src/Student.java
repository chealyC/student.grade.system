import java.util.ArrayList;

public class Student {
    private ArrayList<Subject> subjects;
    private String name;
    private int age;
    private int studentId;

    public Student(String name, int age, ArrayList<Subject> subjects, int studentId) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStudentId() {
        return studentId;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void displaySubjects() {
        for (Subject subject : subjects) {
            System.out.println("    " + subject.getSubjectName() + " - " + subject.getGrade().getPercentage() + "%");
        }
    }

    public double calculateAverage() {
        double totalPoints = 0;
        int totalCredits = 0;

        for (Subject subject : subjects) {
            int percentage = subject.getGrade().getPercentage();
            int credits = subject.getCredits();

            totalPoints += percentage * credits;
            totalCredits += credits;
        }

        if (totalCredits == 0) {
            return 0;
        }

        return totalPoints / totalCredits;
    }

    public String calculateClassification() {
        double average = calculateAverage();

        if (average >= 70) {
            return "Distinction";
        } else if (average >= 60) {
            return "Merit";
        } else if (average >= 50) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

}
