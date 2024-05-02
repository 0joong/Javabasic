package exercise;

public class Challenge_GirlTest {
    public static void main(String[] args){
//        Girl g1 = new Girl();
//        Girl g2 = new GoodGirl();
//        GoodGirl gg = new BestGirl();
        
        //g2.show(); Girl타입 참조변수는 show메서드를 사용할 수 없다 왜냐하면 Girl클래스에 없는거니깐
//        gg.show();

        Girl girls[] = {
                new Girl("갑순이"), new GoodGirl("콩쥐"), new BestGirl("황진이")
        };

        for(Girl g : girls)
            g.show();
    }
}
class Girl{
    String name;
    void show(){
        System.out.printf("%s는 자바 초보자이다.\n", name);
    };
    public Girl(String name){
        this.name = name;
    }
}
class GoodGirl extends Girl{
    public GoodGirl(String name) {
        super(name);
    }

    void show(){
        System.out.printf("%s는 자바를 잘 안다.\n", name);
    }
}
class BestGirl extends GoodGirl{

    public BestGirl(String name) {
        super(name);
    }

    void show(){
        System.out.printf("%s는 자바를 무지하게 잘 안다.\n", name);
    }
}
