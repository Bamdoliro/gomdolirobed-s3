public class AttendanceBook {
    // 캡슐화 적용: private로 변경
    private Student[] list = new Student[100];
    private int size = 0;

    // 학생 추가
    public void insert(Student s) {
        if (s == null) return;

        // 중복 학생 체크 후 삽입 방지
        for (int i = 0; i < size; i++) {
            if (list[i].isSameStudent(s)) { // 새로 추가된 isSameStudent() 사용
                System.out.println(s.getName() + "님은 이미 출석부에 존재합니다.");
                return; // 삽입 중단
            }
        }

        list[size] = s;
        size++;
    }

    // 출석 증가
    public void increase(String name) {
        for (int i = 0; i < size; i++) {
            if (list[i].getName().equals(name)) {
                list[i].increase();
                return;
            }
        }
        System.out.println(name + " 학생을 찾을 수 없습니다");
    }

    // 전체 조회 (출석 내림차순)
    public void printAll() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (list[j].getAttendance() < list[j + 1].getAttendance()) {
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

    // 특정 학생 조회
    public void printAttendCnt(String name) {
        for (int i = 0; i < size; i++) {
            if (list[i].getName().equals(name)) {
                System.out.println(name + " 출석 횟수: " + list[i].getAttendance());
                return;
            }
        }
        System.out.println(name + " 학생을 찾을 수 없습니다");
    }

    // 학생 삭제
    public void remove(Student s) {
        int index = -1;

        // 삭제 대상 인덱스 찾기
        for (int i = 0; i < size; i++) {
            if (list[i].isSameStudent(s)) { // 새로 추가된 isSameStudent() 사용
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("존재하지 않는 학생은 삭제할 수 없습니다");
            return;
        }

        // 배열 요소 한 칸씩 당김
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        list[size - 1] = null; // 마지막 요소 null 처리
        size--;
        System.out.println(s.getName() + "님이 출석부에서 삭제되었습니다");
    }
}