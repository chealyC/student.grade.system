public class Subject {
    private String subjectName;
    private int credits;
    private Grade grade;

    public Subject(String subjectName, int credits, Grade grade) {
        this.subjectName = subjectName;
        this.credits = credits;
        this.grade = grade;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public Grade getGrade() {
        return grade;
    }
}
