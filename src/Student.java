public class Student {

    private String name;

    private String studentNumber;

    private Integer count;

    public Student(String name, String studentNumber, Integer count) {
        if(name.isBlank() || name.length() >= 20){
            System.out.println("이름은 1자 이상 20자 이하여야합니다");
            return;
        }
        this.name = name;
        this.studentNumber = studentNumber;
        if(count < 0){
            System.out.println("출석횟수는 1회 이상이어야합ㄴ디ㅏ.");
            return;
        }
        this.count = count;
    }

    public String toString(){
        return this.name + "님\n 학번 : " + this.studentNumber + "\n 출석횟수 : " + this.count + "회";
    }

    public void increaseCount(){
        this.count++;
    }

    public Integer getCount(){
        return this.count;
    }

    public void printCount(){
        System.out.println(this.count + "회");
    }

    public String getName(){
        return this.name;
    }

}
