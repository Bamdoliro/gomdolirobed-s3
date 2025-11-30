public class NumberOfAttendance {
    public static void increase(AttendanceSheet students[], String student) {
        for(int index = 0; index < students.length; index++){
            if(students[index] == null) continue;
            if(students[index].getName().equals(student)){
                students[index].increaseAttendance();
                return;
            }
        }
    }
}