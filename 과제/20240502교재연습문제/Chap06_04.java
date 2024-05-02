package exercise;

public class Chap06_04 {
    public static void main(String[] args){
        Parent p = new Child();
        System.out.println(p.name);
        p.print();
    }
}
class Parent{
    String name = "영조";

    public void print(){
        System.out.printf("%s", name);
    }
}
class Child extends Parent{
    String name = "사도세자";

    @Override
    public void print(){
        System.out.printf("나는 %s이다.", name);
    }
}