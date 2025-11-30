package attendance;

import student.Student;

import java.util.ArrayList;
import java.util.List;

public class AttendanceList {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (student.getName().length() > 20 && student.getName().isBlank()) throw new IllegalArgumentException("Name is too long or too short");
        for (Student s : students) {
            if (s.getName().equals(student.getName()) && s.getNumber().equals(student.getAttendance())) {
                throw new IllegalArgumentException(student.getName() + "님이 이미 있습니다.");
            }
        }
        students.add(student);
    }

    public AttendanceList(Student... students) {
        for (Student student : students) {
            this.addStudent(student);
        }
    }
    public void deleteStudent(Student student) {
        try {
            students.remove(student);
            System.out.println(student.getName() + " 님이 출석부에서 삭제되었습니다");
        } catch (IndexOutOfBoundsException e) {
            throw  new IllegalArgumentException(student.getName() + "님을 찾을 수 없습니다.");
        }
    }
    public void addAttendance(Student student, Integer attendance) {
        if (attendance < 0) throw new IllegalArgumentException("출석횟수는 줄어들 수 없습니다.");
        Integer oldAttendance = student.getAttendance();
        for (Student s : students) {
            if (s.equals(student)) student.setAttendance(oldAttendance + attendance);
            break;
        }
    }

    public void printStudents() {
        students.sort((s1, s2) -> Integer.compare(s2.getAttendance(), s1.getAttendance()));
        for (Student student : students) {
            System.out.println("학생 이름: " + student.getName()
                    + " 학생 학반번호: " + student.getNumber()
                    + " 학생 출석횟수: " + student.getAttendance());
        }
    }
    public void printAttendance(Student student) {
        if (!students.contains(student)) throw new IllegalArgumentException("학생을 찾을 수 없습니다.");
        System.out.println("학생 출석횟수: " + student.getAttendance());
    }


}
