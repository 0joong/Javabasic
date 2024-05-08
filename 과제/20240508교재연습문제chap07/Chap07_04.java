package exercise;

public class Chap07_04 {
    static void speak(Talkable t){
        t.talk();
    }
    public static void main(String[] args){
        speak(new Korean());
        speak(new American());
    }
}
interface Talkable{
    void talk();
}
class Korean implements Talkable{
    public void talk(){
        System.out.print("안녕하세요!\n");
    }
}
class American implements Talkable{
    public void talk(){
        System.out.print("Hello!\n");
    }
}