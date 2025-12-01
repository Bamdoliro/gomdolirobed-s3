//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // TODO-1 출석부 생성
        AttendanceBook ab = new AttendanceBook();

        // TODO-2 학생 생성
        Student s1 = StudentGenerator.generateStudent("이밤돌", 20309, 0);
        Student s2 = StudentGenerator.generateStudent("김이로", 10111, 3);
        Student s3 = StudentGenerator.generateStudent("최시나", 10209, 2);

        Student s4 = StudentGenerator.generateStudent("박마루", 20101, -1);

        // TODO-3 출석부에 학생 삽입
        ab.addStudent(s1);
        ab.addStudent(s2);

        // TODO-4 출석부에 동일한 학생 삽입
        ab.addStudent(s1);

        // TODO-5 출석횟수 증가
        ab.increaseAttendanceCount(s1);
        ab.increaseAttendanceCount(s2);

        // TODO-6 출석부 조회
        ab.showAllStudents();

        // TODO-7 특정 학생 정보 조회
        System.out.println(s1.getAttendanceCount());
        System.out.println(s2.getAttendanceCount());

        // TODO-8 출석부에 존재하지 않는 학생 삭제
        ab.removeStudent(s3);

        // TODO-9 출석부에서 학생 삭제
        ab.removeStudent(s1);

        // TODO-10 삭제 후 출석부 조회
        ab.showAllStudents();

    }
}