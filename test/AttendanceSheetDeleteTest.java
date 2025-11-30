import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttendanceSheetDeleteTest {

    private AttendanceSheet[] students = new AttendanceSheet[5];

    @BeforeEach
    public void setUp() {
        students = new AttendanceSheet[5];
        AttendanceSheet student1 = new AttendanceSheet("이밤돌", 20309, 0);
        AttendanceSheet student2 = new AttendanceSheet("김이로", 10111, 3);

        AttendanceSheetInsert.insert(students, student1);
        AttendanceSheetInsert.insert(students, student2);
    }

    @Test
    public void deleteExisting() {
        AttendanceSheetDelete.delete(students, "이밤돌");

        assertNull(students[0]);
    }

    @Test
    public void deleteNonExistent() {
        AttendanceSheetDelete.delete(students, "없는학생");

        assertNotNull(students[0]);
        assertNotNull(students[1]);
    }
}
