public class AttendanceSheet {
    public String name;
    public int studentId;
    public int numberOfAttendance;

    public AttendanceSheet(String name, int studentId,  int numberOfAttendance) {
        if(numberOfAttendance < 0){
            throw new IllegalArgumentException("출석횟수는 음수일 수 없습니다.");
        }
        this.name = name;
        this.studentId = studentId;
        this.numberOfAttendance = numberOfAttendance;
    }
}