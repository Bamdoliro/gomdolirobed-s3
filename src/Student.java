public class Student implements Comparable<Student>{
    private final String name;
    private final int classNumber;
    private int attendanceCount;

    public Student(String name, int classNumber, int attendanceCount) {
        if(name == null || name.length() < 1 || name.length() > 20) {
            System.out.println("학생의 이름은 1자 이상 20자 이하이어야 합니다");
            throw new IllegalArgumentException("학생의 이름은 1자 이상 20자 이하이어야 합니다");
        }
        if(attendanceCount < 0) {
            System.out.println("출석 횟수는 음수일 수 없습니다");
            throw new IllegalArgumentException("출석 횟수는 음수일 수 없습니다");
        }

        this.name = name;
        this.classNumber = classNumber;
        this.attendanceCount = attendanceCount;

    }

    public void increaseAttendance(int days) {
        this.attendanceCount += days;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(other.attendanceCount, this.attendanceCount);
    }
}