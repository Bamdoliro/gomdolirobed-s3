public class Student implements Comparable<Student> {
    private final String name;
    private final int classNumber;
    private int attendanceCount;

    public Student(String name, int classNumber, int attendanceCount) {
        if(name == null || name.length() < 1 || name.length() > 20)
            throw new IllegalArgumentException("학생의 이름은 1자 이상 20자 이하이어야 합니다.");
        if(attendanceCount < 0)
            throw new IllegalArgumentException("출석 횟수는 음수일 수 없습니다.");

        this.name = name;
        this.classNumber = classNumber;
        this.attendanceCount = attendanceCount;

    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}