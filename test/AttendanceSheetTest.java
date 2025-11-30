import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttendanceSheetTest {
    @Test
    public void validStudentCreation(){
        String name = "이밤돌";
        int studentId = 20309;
        int attendance = 0;

        AttendanceSheet student = new AttendanceSheet(name, studentId, attendance);

        assertEquals(name, student.name);
        assertEquals(studentId, student.studentId);
        assertEquals(attendance, student.numberOfAttendance);
    }

    @Test
    public void invalidStudentCreation(){
        String name = "박마루";
        int studentId = 20101;
        int attendance = -1;

        try{
            AttendanceSheet student = new AttendanceSheet(name, studentId, attendance);
            fail("예외 처리 발생 안됨");
        }
        catch(IllegalArgumentException e){
            assertEquals("출석횟수는 음수일 수 없습니다.", e.getMessage());
        }

    }

}
