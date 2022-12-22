package polymorphism;

public class Tree extends Plant {

    @Override
    public void grow() {
        System.out.println("Tree growing");
    }
    
    public void leaves() {
        System.out.println("Leaves");
    }
}
