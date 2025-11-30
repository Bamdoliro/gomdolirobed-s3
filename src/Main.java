//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

class Student{
    String name;
    int grade;
    int classroom;
    int number;
    int attendCnt;

    // if 음수 -> name = null
    Student(String name, int grade, int classroom, int number, int attendCnt){
        this.name = name;
        this.grade = grade;
        this.classroom = classroom;
        this.number = number;
        if(attendCnt < 0){
            System.out.println("출석횟수는 음수일 수 없습니다");
            this.name = null;
        } else {
            this.attendCnt = attendCnt;
        }
    }

    void increase(){
        attendCnt++;
    }

    @Override
    public String toString(){
        return name + " " + grade + classroom + number +  + attendCnt;
    }
}

class AttendanceBook {
    Student[] list = new Student[100];
    int size = 0;

    void insert(Student s) {
        if (s == null || s.name == null) return;

        for (int i = 0; i < size; i++) {
            Student cur = list[i];
            if (cur.name.equals(s.name) &&
                cur.grade == s.grade &&
                cur.classroom == s.classroom &&
                cur.number == s.number) {
                System.out.println(s.name + "은(는) 이미 출석부에 존재합니다.");
                return;
            }
        }

        list[size] = s;
        size++;
    }

    void increase(String name) {
        for (int i = 0; i < size; i++) {
            if (list[i].name.equals(name)) {
                list[i].increase();
                return;
            }
        }
        System.out.println(name + "학생을 찾을 수 없습니다");
    }

    void printAll() {
        // 내림차순
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (list[j].attendCnt < list[j + 1].attendCnt) {
                    Student tmp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println(list[i]);
        }
    }

    void printAttendCnt(String name) {
        for (int i = 0; i < size; i++) {
            if (list[i].name.equals(name)) {
                System.out.println(name + " 출석 횟수: " + list[i].attendCnt);
                return;
            }
        }
        System.out.println(name + "학생을 찾을 수 없습니다");
    }

    void remove(Student s) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            Student cur = list[i];
            if (cur.name.equals(s.name) &&
                cur.grade == s.grade &&
                cur.classroom == s.classroom &&
                cur.number == s.number) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("존재하지 않는 학생은 삭제할 수 없습니다");
            return;
        }

        // 앞으로 한 칸씩 당김
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        size--;
        System.out.println(s.name + "님이 출석부에서 삭제되었습니다");
    }
}

public class Main {
    public static void main(String[] args) {

        // TODO-1 출석부 생성
        // 학생목록이 비어 있는 출석부를 하나 생성합니다.
        AttendanceBook book = new AttendanceBook();

        // TODO-2 학생 생성
        // 출석횟수가 0회인 2학년 3반 9번 이밤돌을 생성합니다.
        Student s1 = new Student("이밤돌", 2, 3, 9, 0);
        // 출석횟수가 3회인 1학년 1반 11번 김이로를 생성합니다.
        Student s2 = new Student("김이로", 1, 1, 11, 3);
        // 출석횟수가 2회인 1학년 2반 9번 최시나를 생성합니다.
        Student s3 = new Student("최시나", 1, 2, 9, 2);

        // 출석횟수가 -1회인 2학년 1반 1번 박마루를 생성합니다.
        Student s4 = new Student("박마루", 2, 1, 1, -1);
        // 출석횟수는 음수일 수 없다는 메시지가 출력되고 생성되지 않습니다.

        // TODO-3 출석부에 학생 삽입
        // 생성한 출석부에 이밤돌, 김이로를 삽입합니다.
        book.insert(s1);
        book.insert(s2);

        // TODO-4 출석부에 동일한 학생 삽입
        // 출석부에 이밤돌을 다시 삽입합니다.
        book.insert(s1);
        // 출석부에 이밤돌은 존재하므로 삽입할 수 없다는 메시지가 출력됩니다.

        // TODO-5 출석횟수 증가
        // 출석부에 존재하는 이밤돌, 김이로의 출석횟수가 각각 1씩 증가합니다.
        book.increase("이밤돌");
        book.increase("김이로");

        // TODO-6 출석부 조회
        // 출석부에 등록된 모든 학생의 정보를 조회합니다.
        book.printAll();
        // 각 학생들의 이름, 학반번호, 출석횟수를 출력해야합니다.
        // 학생 목록은 출석횟수를 기준으로 내림차순 정렬하여 출력해야 합니다.

        // TODO-7 특정 학생 정보 조회
        // 이밤돌의 출석 횟수를 조회합니다.
        // 김이로의 출석 횟수를 조회합니다.
        book.printAttendCnt("이밤돌");
        book.printAttendCnt("김이로");

        // TODO-8 출석부에 존재하지 않는 학생 삭제
        // 출석부에서 최시나를 삭제합니다.
        book.remove(s3);
        // 출석부에 최시나는 없으므로 존재하지 않는 학생은 삭제가 불가능하다는 메시지가 출력됩니다.

        // TODO-9 출석부에서 학생 삭제
        // 출석부에서 이밤돌을 삭제합니다.
        book.remove(s1);
        // 학생이름 + '님이 출석부에서 삭제되었습니다' 라는 메시지가 출력되어야합니다.

        // TODO-10 삭제 후 출석부 조회
        // 학생 삭제가 정상적으로 되었는지 다시 한 번 출석부의 학생 명단을 조회해 출력합니다.
        book.printAll();

    }
}