package courses.oop;

public class Square extends Shape {

    public Square(String color) {
        super(color);
    }

    public Square() {
        super();
    }

    //overloading
    public void draw(String color) {
        System.out.println("Draw a square with color:" + color);
        super.setColor(color);
    }

    //overwriting
    public void draw() {
        this.draw(this.getColor());
    }
}
