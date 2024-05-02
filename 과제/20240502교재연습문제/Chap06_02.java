package exercise;

public class Chap06_02 {
    public static void main(String[] args) {
        Person p1 = new Person("길동이", 22);
        Student p2 = new Student("황진이", 23, "100");
        ForeignStudent p3 = new ForeignStudent("Amy", 30, "200", "U.S.A");

        p1.show();
        p2.show();
        p3.show();
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.printf("사람[이름 : %s, 나이 : %d]\n", name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Student extends Person {
    String studentNum;

    public Student(String name, int age, String studentNum) {
        super(name, age);
        this.studentNum = studentNum;
    }

    @Override
    public void show() {
        System.out.printf("학생[이름 : %s, 나이 : %d, 학번 : %s]\n", name, age, studentNum);
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }
}

class ForeignStudent extends Student {
    String nationality;

    public ForeignStudent(String name, int age, String studentNum, String nationality) {
        super(name, age, studentNum);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public void show() {
        System.out.printf("외국학생[이름 : %s, 나이 : %d, 학번 : %s, 국적 : %s]\n",
                name, age, studentNum, nationality);
    }
}