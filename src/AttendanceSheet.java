public class AttendanceSheet {
    private String name;
    private int studentId;
    private int numberOfAttendance;

    public String getName(){
        return this.name;
    }
    public int getStudentId(){
        return this.studentId;
    }
    public int getNumberOfAttendance(){
        return this.numberOfAttendance;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    public void setNumberOfAttendance(int numberOfAttendance){
        this.numberOfAttendance = numberOfAttendance;
    }
    public void increaseAttendance() {
        this.numberOfAttendance++;
    }
    public AttendanceSheet(String name, int studentId,  int numberOfAttendance) {
        if(numberOfAttendance < 0){
            throw new IllegalArgumentException("출석횟수는 음수일 수 없습니다.");
        }
        this.name = name;
        this.studentId = studentId;
        this.numberOfAttendance = numberOfAttendance;
    }
}