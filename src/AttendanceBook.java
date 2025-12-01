import java.util.ArrayList;
import java.util.Collections;
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

    public void printAllStudents() {// Comparable 기준 정렬 (출석 횟수)
        Collections.sort(students);
        System.out.println("[전체 학생 정보 조회]");
        for(Student s : students) {
            System.out.println(s);
        }
        System.out.println();
    }

    public void printAttendance(Student student) {
        if(!students.contains(student)) {
            System.out.println(student.getName() + " : 출석부에 존재하지 않는 학생입니다");
            throw new IllegalArgumentException("출석부에 존재하지 않는 학생입니다");
        }
        System.out.printf("%s의 출석 횟수: %d회\n",
                student.getName(),
                student.getAttendanceCount());
    }

    public void removeStudent(Student student) {
        if(!students.contains(student)) {
            System.out.println(student.getName() + " : 존재하지 않는 학생은 삭제할 수 없습니다");
            throw new IllegalArgumentException("출석부에 존재하지 않는 학생입니다");
        }
        students.remove(student);
        System.out.println(student.getName() + "님이 출석부에서 삭제되었습니다\n");
    }
}
