public class AttendanceSheetInsert{
    public static void insert(AttendanceSheet[] students, AttendanceSheet student){
        if(student == null) return;
        for(int index = 0; index < students.length; index++){
            if(students[index] == null){
                students[index] = student;
                return;
            }
            if(students[index].name.equals(student.name)){
                System.out.println(student.name + "는 존재하므로 추가할수없습니다.");
                return;
            }
        }
    }
}