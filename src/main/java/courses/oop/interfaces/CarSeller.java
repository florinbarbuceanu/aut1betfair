package courses.oop.interfaces;

public class CarSeller {
    public static void main(String[] args) {
        Truck truck1 = new Truck(5000);
        Truck truck2 = new Truck();

        System.out.println(truck2.compareTo(truck1));

    }
}
