package exercise;

public class Chap06_05 {
    public static void main(String[] args){
        Phone1[] phones = {new Phone1("황진이"), new Telephone("길동이", "내일"), new Smartphone("민국이", "갤러그")};

        for(Phone1 phone : phones){
            if(phone instanceof Smartphone){
                Smartphone sp = (Smartphone)phone;
                sp.playGame();
            }
            else if(phone instanceof Telephone){
                Telephone tp = (Telephone)phone;
                tp.autoAnswering();
            }
            else{
                Phone1 p = (Phone1)phone;
                p.talk();
            }
        }
    }
}
class Phone{
    protected String owner;

    public Phone(String owner) {
        this.owner = owner;
    }

    public void talk(){
        System.out.printf("%s가 통화 중\n", owner);
    }
}
class Telephone extends Phone1 {
    private String when;

    public Telephone(String owner, String when) {
        super(owner);
        this.when = when;
    }

    public void autoAnswering(){
        System.out.printf("%s가 부재 중이니 %s에 전화 요망\n", owner, when);
    }
}

class Smartphone extends Telephone{
    private String name;

    public Smartphone(String owner, String when, String name) {
        super(owner, when);
        this.name = name;
    }

    public Smartphone(String owner, String name) {
        super(owner, "");
        this.name = name;
    }



    public void playGame(){
        System.out.printf("%s가 게임 중\n", owner);
    }
}
