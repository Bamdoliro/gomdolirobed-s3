public class Student {
    // 캡슐화 적용: private로 변경
    private String name;
    private int grade;
    private int classroom;
    private int number;
    private int attendCnt;

    public Student(String name, int grade, int classroom, int number, int attendCnt){
        if (name == null || name.length() < 1 || name.length() > 20) { // 이름 길이 제한
            throw new IllegalArgumentException("학생 이름은 1~20자여야 합니다.");
        }
        if(attendCnt < 0){
            throw new IllegalArgumentException("출석횟수는 음수일 수 없습니다");
        }
        this.name = name;
        this.grade = grade;
        this.classroom = classroom;
        this.number = number;
        this.attendCnt = attendCnt;
    }

    // Getter 메서드 추가 (캡슐화)
    public String getName() { return name; }
    public int getGrade() { return grade; }
    public int getClassroom() { return classroom; }
    public int getNumber() { return number; }
    public int getAttendance() { return attendCnt; }

    public void increase(){
        attendCnt++;
    }

    @Override
    public String toString(){
        return name + " " + grade + classroom + number + " 출석횟수: " + attendCnt;
    }

    // 동일 학생 비교 메서드 추가
    public boolean isSameStudent(Student other) {
        return this.name.equals(other.name)
            && this.grade == other.grade
            && this.classroom == other.classroom
            && this.number == other.number;
    }
}