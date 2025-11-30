import java.util.Arrays;

public class AttendanceSheetLookup {
    public static void lookup(AttendanceSheet students[]) {
        Arrays.sort(students, (a, b) -> {
            if(a == null && b == null) return 0;
            if (a == null) return 1;
            if (b == null) return -1;
            return b.getNumberOfAttendance() - a.getNumberOfAttendance();
        });
        for (int index = 0; index < students.length; index++) {
            if(students[index] == null) continue;
            System.out.println("이름 : " + students[index].getName() + " 학번 : " + students[index].getStudentId() + " 출석일수 : " + students[index].getNumberOfAttendance());
        }
    }
}
