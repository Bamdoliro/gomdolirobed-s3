import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RollBook {

    private List<Student> studentList;

    public RollBook() {
        this.studentList = new ArrayList<>();
    }

    public RollBook(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student) {
        if(studentList.contains(student)) {
            System.out.println("존재하는 학생은 추가를 할 수 없습니다.");
            return;
        }
        this.studentList.add(student);
    }

    public void removeStudent(Student student) {
        if(!studentList.contains(student)) {
            System.out.println("존재하지 않는 학생은 삭제를 할 수 없습니다.");
            return;
        }
        this.studentList.remove(student);
        System.out.println(student.getName() + "님이 출석부에서 삭제되었습니다.");
    }

    public void printStudentInfo(){
        studentList.stream()
                .sorted(Comparator.comparing(Student::getCount).reversed())
                .forEach(student -> System.out.println(student.toString()));
    }

    public void increaseCount(){
        studentList.forEach(Student::increaseCount);
    }

}
