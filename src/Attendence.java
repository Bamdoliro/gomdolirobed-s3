import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attendence {
    private Map<String, Student> students;

    public Attendence() {
        this.students = new HashMap<>();
    }
    
    private String getKey(Student student) {
        return student.getName() + "-" + student.getSchoolId();
    }

    //이미 존재하는 학생 추가하면?
    public boolean addStudent(Student student) {
        String key = getKey(student);
        if(students.containsKey(key)) {
            System.out.println(student.getName() + "은(는) 이미 출석부에 존재합니다.");
            return false;
        }
        students.put(key, student); //학생 파일에서의 hash를 내부적으로 사용하는 구조
        return true;
    }

    //출석부에 없는 이름을 삭제하려고 한다면?
    public boolean removeStudent(Student student) {
        String key = getKey(student);
        if (!students.containsKey(key)) {
            System.out.println("존재하지 않는 학생은 삭제 불가능합니다.");
            return false;
        }
        students.remove(key);
        System.out.println(student.getName() + "님이 출석부에서 삭제되었습니다.");
        return true;
    }

    //출석부 안에 있는 학생의 출석횟수 증가시키기
    public void increaseAttendance(Student student) {
        String key = getKey(student);
        Student s = students.get(key);
        if (s != null) {
            s.increaseAttendance();
        }
    }
    
    //출석부 조회
    public void printAllStudents() {
        List<Student> studentList = new ArrayList<>(students.values());
        studentList.sort((s1, s2) -> Integer.compare(s2.getAttendanceCount(), s1.getAttendanceCount()));

        System.out.println("\n==== 출석부 ====");
        for(Student student : studentList) {
            System.out.println(student);
        }
        System.out.println();
    }

    //특정 학생의 출석횟수 출력
    public void printStudentAttendance(Student student) {
        String key = getKey(student);
        Student s = students.get(key);
        if(s != null) {
            System.out.println(s.getName() + "의 출석횟수 : " + s.getAttendanceCount() + "회");
        }
    }
}