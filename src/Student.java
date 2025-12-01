public class Student {
    private String name;
    private int studentNumber;
    private int attendanceCount;

    public Student (String name, int studentNumber, int attendanceCount) {
        if(name.isEmpty() || name.length() > 20) {
            throw new IllegalArgumentException("이름은 1~20자여야 합니다.");
        }
        if(attendanceCount < 0) {
            throw new IllegalArgumentException("출석횟수는 음수일 수 없습니다.");
        }
        this.name = name;
        this.studentNumber = studentNumber;
        this.attendanceCount = attendanceCount;
    }

    public String getName() {
        return name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        if(attendanceCount >= 0) {
            this.attendanceCount = attendanceCount;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Student stu = (Student)obj;
        return stu.getName().equals(this.name) ||
               stu.getStudentNumber() == this.studentNumber;
    }
}
