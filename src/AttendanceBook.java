import java.util.ArrayList;
import java.util.List;

public class AttendanceBook {
    private final List<Student> students;

    public AttendanceBook() {
        this.students = new ArrayList<>();
    }

    public AttendanceBook(List<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public void addStudent(Student student) {
        if(students.contains(student)) {
            System.out.println(student.getName() + " : 출석부에 동일한 학생은 추가할 수 없습니다");
            throw new IllegalArgumentException("출석부에 동일한 학생은 추가할 수 없습니다");
        }
        students.add(student);
    }

    public void increaseAttendance(Student student, int days) {
        if(days < 0) {
            System.out.println(student.getName() + " : 출석 횟수는 음수만큼 증가할 수 없습니다");
            throw new IllegalArgumentException("출석 횟수는 음수만큼 증가할 수 없습니다");
        }
        if(!students.contains(student)) {
            System.out.println(student.getName() + " : 출석부에 존재하지 않는 학생입니다");
            throw new IllegalArgumentException("출석부에 존재하지 않는 학생입니다");
        }

        student.increaseAttendance(days);
    }
}
