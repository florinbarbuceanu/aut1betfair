package courses.oop;

import courses.javabasics.Draw;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(3);
        Circle.setName("Cerc1");
        System.out.println("Aria cercului:" + circle.getArea());

        Circle circle1 = new Circle(4);
        System.out.println("Aria cercului:" + circle1.getArea());
        Circle.setName("Cerc2");
        System.out.println("Circle name:" + Circle.name);
        Draw.drawFullShape(4);
    }
}
