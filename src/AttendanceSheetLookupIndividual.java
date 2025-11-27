public class AttendanceSheetLookupIndividual {
    public static void lookup(AttendanceSheet[] students, String student){
        for(int index = 0; index < students.length; index++){
            if(students[index] == null) continue;
            if(students[index].name.equals(student)){
                System.out.println(students[index].name + "의 출석일수 : " + students[index].numberOfAttendance);
            }
        }
    }
}
