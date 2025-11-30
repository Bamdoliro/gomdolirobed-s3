import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttendanceSheetLookupTest {

    private AttendanceSheet[] students = new AttendanceSheet[5];

    @BeforeEach
    public void setUp() {
        students = new AttendanceSheet[5];
        AttendanceSheet student1 = new AttendanceSheet("이밤돌", 20309, 0);
        AttendanceSheet student2 = new AttendanceSheet("김이로", 10111, 3);
        AttendanceSheet student3 = new AttendanceSheet("최시나", 10209, 2);

        AttendanceSheetInsert.insert(students, student1);
        AttendanceSheetInsert.insert(students, student2);
        AttendanceSheetInsert.insert(students, student3);
    }

    @Test
    public void lookUpAttendanceSheet() {
        AttendanceSheetLookup.lookup(students);

        assertEquals("김이로", students[0].getName());
        assertEquals("최시나", students[1].getName());
        assertEquals("이밤돌", students[2].getName());
    }

}
