package student;

public class Student {
    private final String name;
    private final Integer number;
    private Integer attendance;

    public Student(String name, Integer number, Integer attendance) {
        if (attendance < 0) throw new IllegalArgumentException("출석 횟수는 음수일 수 없습니다.");
        this.name = name;
        this.number = number;
        this.attendance = attendance;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getAttendance() {
        return attendance;
    }
    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }
}