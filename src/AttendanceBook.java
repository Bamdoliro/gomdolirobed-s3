import java.security.Key;
import java.util.Comparator;
import java.util.Vector;

public class AttendanceBook {
    private Vector<Student> students;

    public AttendanceBook() {
        students = new Vector<>();
    }

    public AttendanceBook(Vector<Student> students) {
        this.students = students;
    }

    public void increaseAttendanceCount(Student student) {
        if(students.contains(student)) {
            student.setAttendanceCount(student.getAttendanceCount() + 1);
        } else {
            System.out.println("없는 학생입니다.");
        }
    }

    public void addStudent(Student student) {
        if(students.contains(student)) {
            System.out.println("이미 존재하는 이름/학번 입니다.");
        } else {
            students.add(student);
        }

    }

    public void removeStudent(Student student) {
        if(students.contains(student)) {
            System.out.println(student.getName() + "님이 출석부에서 삭제되었습니다.");
            students.remove(student);
        } else {
            System.out.println("없는 학생입니다.");
        }
    }

    public void showAllStudents() {
        System.out.println("- 현재 출석부 학생 목록 -");
        students.sort(Comparator.comparingInt(Student::getAttendanceCount).reversed());
        for(int i = 0; i < students.size(); i++) {
            Student curStudent = students.get(i);
            System.out.println(curStudent.getStudentNumber() + " " +
                    curStudent.getName() + " | 출석횟수: " + curStudent.getAttendanceCount());
        }
    }
}
