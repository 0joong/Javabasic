package challenge_chap04;

public class Triangle {
    private double base;
    private double height;

    public Triangle(double base, double height){//constructor
        this.base = base;
        this.height = height;
    }

    public Triangle(){}//basic constructor

    double findArea(){//넓이 구하기
        return base*height*0.5;
    }

    double getBase(){//밑변 접근자
        return base;
    }

    double getHeight(){//높이 접근자
        return height;
    }

    boolean isSameArea(Triangle t){
        return t.findArea() == this.findArea();
    }
}
