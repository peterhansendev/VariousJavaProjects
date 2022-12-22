package inheritance;

public class Car extends Machine {
    public void wipeWindShield() {
        System.out.println("Wipe");
    }

    @Override
    public void start() {
        System.out.println("MachineCar started");
    }

    public void showInfo() {
        System.out.println(name);
    }

 
}
