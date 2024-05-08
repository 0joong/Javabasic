package exercise;

public class Chap07_05 {
    public static void main(String[] args){
        Controller c[] = { new TV(false), new Radio(true)};

        for(Controller controller : c){
            controller.show();
        }
    }
}
abstract class Controller{
    boolean power;
    void show(){
        if(power){
            System.out.printf("%s가 커졌습니다.\n", getName());
        }
        else{
            System.out.printf("%s가 꺼졌습니다.\n", getName());
        }
    }
    abstract String getName();
}
class TV extends Controller{
    public TV(boolean power){
        this.power = power;
    }

    @Override
    String getName() {
        return "TV";
    }
}
class Radio extends Controller{
    public Radio(boolean power){
        this.power = power;
    }

    @Override
    String getName() {
        return "Radio";
    }
}