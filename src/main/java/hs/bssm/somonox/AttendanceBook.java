package hs.bssm.somonox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AttendanceBook {
    private final List<Student> students;

    public AttendanceBook() {
        this.students = new ArrayList<>();
    }

    public AttendanceBook(List<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(this.students);
    }

    public Student getStudent(String identifier) {
        Optional<Student> opt = this.students.stream()
                .filter(s -> s.getIdentifier().equals(identifier))
                .findFirst();

        if (opt.isEmpty()) {
            throw new IllegalArgumentException("Student with identifier " + identifier + " not found.");
        }

        return opt.get();
    }

    public void addStudent(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Student cannot be null");

        // Check for existing student with same identifier
        boolean exists = this.students.stream()
                .anyMatch(s -> s.equals(student));
        if (exists)
            throw new IllegalArgumentException("Student with identifier " + student.getIdentifier() + " already exists.");

        // Actual add logic
        this.students.add(student);
    }

    public void removeStudent(String identifier) {
        Optional<Student> opt = this.students.stream()
                .filter(s -> s.getIdentifier().equals(identifier))
                .findFirst();

        if (opt.isEmpty()) {
            throw new IllegalArgumentException("Student with identifier " + identifier + " not found.");
        }

        Student toRemove = opt.get();
        boolean removed = this.students.removeIf(student -> student.getIdentifier().equals(identifier));

        if (!removed) {
            throw new IllegalArgumentException("Student with identifier " + identifier + " not found.");
        }

        System.out.println(toRemove + "님이 출석부에서 삭제되었습니다");
    }

    public void attendAll() {
        for (Student student : students) {
            student.incrementAttendance();
        }
    }

    public void attend(String identifier) {
        Optional<Student> opt = this.students.stream()
                .filter(s -> s.getIdentifier().equals(identifier))
                .findFirst();

        if (opt.isEmpty()) {
            throw new IllegalArgumentException("Student with identifier " + identifier + " not found.");
        }

        opt.get().incrementAttendance();
    }

    public List<StudentInfo> getStudentInfosSortedByAttendanceDesc() {
        return this.students.stream()
                .sorted(Comparator.comparingInt(Student::getAttendance).reversed())
                .map(s -> new StudentInfo(s.getName(), s.getIdentifier(), s.getAttendance()))
                .collect(Collectors.toList());
    }

}
