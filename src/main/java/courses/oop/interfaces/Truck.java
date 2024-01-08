package courses.oop.interfaces;

public class Truck implements Car, Engine, Comparable {
    int capacity;

    public Truck(int capacity) {
        this.capacity = capacity;
    }

    public Truck() {
        this.capacity = Engine.MAX_CAPACITY ;
    }

    @Override
    public void start() {
        System.out.println("Start Truck");
        this.engineOn();
    }

    @Override
    public void stop() {
        System.out.println("Stop Truck");
        this.engineOff();
    }

    @Override
    public void engineOn() {
        System.out.println("Start Engine");
    }

    @Override
    public void engineOff() {
        System.out.println("Stop Engine");
    }

    public int compareTo(Truck o) {
        if (this.capacity == o.capacity)
            return 1;
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
