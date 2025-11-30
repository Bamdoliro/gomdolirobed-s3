public class AttendanceSheetInsert{
    public static void insert(AttendanceSheet[] students, AttendanceSheet student){
        if(student == null) return;
        for(int index = 0; index < students.length; index++){
            if(students[index] == null){
                students[index] = student;
                return;
            }
            if(students[index].getName().equals(student.getName())){
                System.out.println(student.getName() + "는 존재하므로 추가할수없습니다.");
                return;
            }
        }
    }
}