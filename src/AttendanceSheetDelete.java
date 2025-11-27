public class AttendanceSheetDelete {
    public static void delete(AttendanceSheet[] students, String student){
        for(int index = 0; index < students.length; index++){
            if(students[index] == null) continue;
            if(students[index].name.equals(student)){
                students[index] = null;
                System.out.println(student + "님이 출석부에서 삭제되었습니다.");
                return;
            }
        }
        System.out.println(student + "님이 출석부에 없습니다.");
    }
}
