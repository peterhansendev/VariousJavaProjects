package interfaces;

public class Machine implements Info {

    private int id = 7;

    public void start() {
        System.out.println("Machine Started");
    }

    @Override
    public void showInfo() {
        System.out.println("This is the machine " + id);
        
    }
}
