package courses.oop.interfaces;

public class Dacia extends AbstractCar {


    @Override
    public void engineOff() {
        System.out.println("Dacia engine off");
    }

    public static void main(String[] args) {
        Dacia dacia = new Dacia();
        dacia.engineOn();
        dacia.engineOff();
    }
}
