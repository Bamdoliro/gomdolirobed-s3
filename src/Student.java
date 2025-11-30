import java.util.Objects;

public class Student {
    private String name;
    // 왜 integer가 아니라 int인가?
    // int는 null값이 포함될 수 없음 but, integer는 null값이 포함될 수 있음
    private int grade;
    private int classNum;
    private int studentNum;
    private int attendanceCount;

    public Student(String name, int grade, int classNum, int attendanceCount) {
        if (attendanceCount < 0) { // 출석횟수가 0보다 작으면 안됨!
            throw new IllegalArgumentException("출석횟수가 0보다 작을 수 없음.");
        }
        // 초기화 시키기
        this.name = name;
        this.grade = grade;
        this.classNum = classNum;
        this.studentNum = studentNum;
        this.attendanceCount = attendanceCount;
    }

    // getter : private 필드에 접근하기 위해 사용함
    public String getName() {
        return name;
    }
    public int getGrade() {
        return grade;
    }
    public int getClassNum() {
        return classNum;
    }
    public int getStudentNum() {
        return studentNum;
    }
    public int getAttendanceCount() {
        return attendanceCount;
    }

    //출석횟수 증가시키기!
    public void increaseAttendance() {
        this.attendanceCount++;
    }

    //학년/반/번호를 문자열로
    public String getSchoolId() {
        return grade + "학년 " + classNum + "반 " + studentNum + "번";
    }

    //override : 재정의
    @Override
    public boolean equals(Object ob) {
        if (this == ob) { // 완전히 같은 객체며ㄴ true
            return true;
        }
        if (ob == null || getClass() != ob.getClass()) { //null이면 false
            return false;
        }
        Student student = (Student) ob;       //object를 student로 변환
        return name.equals(student.name) &&   //왜?) obj는 object 타입이라서 형변환을 해야 필드 접근 가능함
            grade == student.grade && 
            classNum == student.classNum &&
            studentNum == student.studentNum;
    }
    @Override
    public int hashCode() { //출석부 파일에서 HashMap을 사용하는데, 데이터를 빠르게 찾으려고 hasCode 사용
        return Objects.hash(name, grade, classNum, studentNum);
    }

    @Override
    public String toString() {
        return String.format(
            "이름: %s, 학년/반/번호: %d학년 %d반 %d번, 출석횟수: %d번",
            name, grade, classNum, studentNum, attendanceCount
        );
    }
}
