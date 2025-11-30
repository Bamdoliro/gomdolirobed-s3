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
            System.out.println("출석부에 동일한 학생은 추가할 수 없습니다.");
            return;
        }
        students.add(student);
    }
}
