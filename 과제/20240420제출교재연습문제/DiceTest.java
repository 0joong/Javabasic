package challenge_chap04;

public class DiceTest {
    public static void main(String[] args) {
        Dice d = new Dice();
        System.out.printf("주사위의 숫자 : %d\n", d.roll());
    }
}
class Dice {
    int face;

    int roll() {
        face = (int) (Math.random() * (6) + 1);
        return face;
    }
}