import attendance.AttendanceList;
import org.junit.jupiter.api.Test;
import student.Student;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass {
    @Test
    public void testAddAttendanceList() {
        AttendanceList attendanceList = new AttendanceList(new Student("d",21234,2),new Student("d",21234,2));
    }
    @Test
    public void testAddStudent() {
        Student student = new Student("d",21234,21234);
    }
    @Test
    public void testAddStudent2() {
        Student student = new Student("d",21234,-234);
    }
    @Test
    public void testAddAttendanceList2() {
        AttendanceList attendanceList = new AttendanceList();
        Student student = new Student("d",21234,1);
        attendanceList.addStudent(student);
        attendanceList.addStudent(student);
        attendanceList.printStudents();
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student("d",21234,21234);
        AttendanceList attendanceList = new AttendanceList(student);
        attendanceList.deleteStudent(student);
    }

    @Test
    public void testDeleteStudent2() {
        Student student = new Student("d",21234,34);
        AttendanceList attendanceList = new AttendanceList(student);
        attendanceList.deleteStudent(student);
        attendanceList.deleteStudent(student);
    }
    @Test
    public void testAddAttendance() {
        Student student = new Student("d",21234,21234);
        AttendanceList attendanceList = new AttendanceList(student);
        attendanceList.addAttendance(student,1);
    }
    @Test
    public void testAddAttendance2() {
        Student student = new Student("d",21234,21234);
        AttendanceList attendanceList = new AttendanceList(student);
        attendanceList.addAttendance(student,-1);
    }
}
