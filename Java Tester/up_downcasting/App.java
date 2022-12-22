package up_downcasting;

class Machine {
    public void start() {
        System.out.println("Machine started");
    }
}

class Camera extends Machine {
    public void start() {
        System.out.println("Camera started");
    }
    public void snap() {
        System.out.println("Snap");
    }
}

public class App {
    public static void main(String[] args) {
        
        Machine machine1 = new Machine();
        Camera camera1 = new Camera();

        machine1.start();
        camera1.start();
        camera1.snap();

        // Upcasting
        Machine machine2 = camera1;
        machine2.start();

        // Downcasting
        Machine machine3 = new Camera();
        Camera camera2 = (Camera)machine3;
        camera2.start();
        camera2.snap();
    }
}
