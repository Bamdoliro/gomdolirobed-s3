import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberOfAttendanceTest {

    private AttendanceSheet[] students;

    @BeforeEach
    public void setUp() {
        students = new AttendanceSheet[5];
        students[0] = new AttendanceSheet("이밤돌", 20309, 0);
        students[1] = new AttendanceSheet("김이로", 10111, 3);
    }

    @Test
    public void increaseAttendance() {
        assertEquals(0, students[0].numberOfAttendance);

        NumberOfAttendance.increase(students, "이밤돌");

        assertEquals(1, students[0].numberOfAttendance);
    }

    @Test
    public void increaseNonStudent() {
        NumberOfAttendance.increase(students, "없는학생");

        assertEquals(0, students[0].numberOfAttendance);
    }
}