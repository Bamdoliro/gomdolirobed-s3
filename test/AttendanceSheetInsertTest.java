import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttendanceSheetInsertTest {

    private AttendanceSheet[] students = new AttendanceSheet[5];

    @BeforeEach
    public void setUp() {
        students = new AttendanceSheet[5];
    }

    @Test
    public void insertAttendanceSheet() {
        AttendanceSheet student1 = new AttendanceSheet("이밤돌", 20309, 0);

        AttendanceSheetInsert.insert(students, student1);
        assertEquals(students[0], student1);
    }
    @Test
    public void insertDuplicationAttendanceSheet() {
        AttendanceSheet student1 = new AttendanceSheet("이밤돌", 20309, 0);
        AttendanceSheet student2 = new AttendanceSheet("이밤돌", 20309, 0);

        AttendanceSheetInsert.insert(students, student1);
        AttendanceSheetInsert.insert(students, student2);

        assertEquals(student1, students[0]);
        assertNull(students[1]);
    }
    @Test
    public void insertNullAttendanceSheet() {
        AttendanceSheet nullStudent = null;

        AttendanceSheetInsert.insert(students, nullStudent);

        assertNull(students[0]);
    }
}
