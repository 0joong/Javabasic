package exercise;

public class Chap06_06 {
    public static void main(String[] args) {
        Car c = new Car("파랑", 200, 1000, 5);
        c.show();

        System.out.println();
        Vehicle v = c;
        v.show();
    }
}

class Vehicle {
    String color;
    int speed;

    public Vehicle(String color, int speed) {
        this.color = color;
        this.speed = speed;
    }

    public void show() {
        System.out.printf("%s %d\n", color, speed);
    }

}

class Car extends Vehicle {
    int displacement;
    int gears;

    public Car(String color, int speed, int displacement, int gears) {
        super(color, speed);
        this.displacement = displacement;
        this.gears = gears;
    }

    @Override
    public void show() {
        System.out.printf("%s %d %d %d\n", color, speed, displacement, gears);
    }

}