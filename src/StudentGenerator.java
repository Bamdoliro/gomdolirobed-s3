public class StudentGenerator {
    public static Student generateStudent(String name, int studentNumber, int attendanceCount) {
        Student newStudent = null;
        try {
            newStudent = new Student(name, studentNumber, attendanceCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return newStudent;
    }
}
