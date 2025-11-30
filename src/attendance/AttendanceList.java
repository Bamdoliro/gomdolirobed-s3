package attendance;

import student.Student;

import java.util.ArrayList;
import java.util.List;

public class AttendanceList {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (student.getName().length() > 20 && student.getName().isBlank()) throw new IllegalArgumentException("Name is too long or too short");
        if (student.getAttendance() < 0) throw new IllegalArgumentException("Attendance cannot be negative");
        for (Student s : students) {
            if (s.getName().equals(student.getName()) && s.getNumber().equals(student.getAttendance())) {
                throw new IllegalArgumentException("Student already exists");
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
        } catch (IndexOutOfBoundsException e) {
            throw  new IllegalArgumentException("Student not found");
        }
    }
    public void addAttendance(Student student, Integer attendance) {
        if (attendance < 0) throw new IllegalArgumentException("Attendance cannot be negative");
        Integer oldAttendance = student.getAttendance();
        for (Student s : students) {
            if (s.equals(student)) student.setAttendance(oldAttendance + attendance);
        }
    }

    public void printStudents() {
        for (Student student : students) {
            System.out.println("Student Name: " + student.getName() + "Student Number: " + student.getNumber() + "Student Attendance:" + student.getAttendance());
        }
    }

}
