public class Main {
    public static void main(String[] args) {
        AttendanceBook book = new AttendanceBook();

        Student s1 = new Student("이밤돌", 2, 3, 9, 0);
        Student s2 = new Student("김이로", 1, 1, 11, 3);
        Student s3 = new Student("최시나", 1, 2, 9, 2);

        try {
            Student s4 = new Student("박마루", 2, 1, 1, -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } // 출석횟수 음수 예외 처리 테스트

        book.insert(s1);
        book.insert(s2);
        book.insert(s1);

        book.increase("이밤돌");
        book.increase("김이로");

        book.printAll();

        book.printAttendCnt("이밤돌");
        book.printAttendCnt("김이로");

        book.remove(s3);
        book.remove(s1);

        book.printAll();
    }
}