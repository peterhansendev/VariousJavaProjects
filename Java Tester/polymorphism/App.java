package polymorphism;

public class App {
    public static void main(String[] args) {
        Plant plant = new Plant();
        Tree tree = new Tree();

        Plant plant2 = tree;

        plant2.grow();

        tree.leaves();

    }

    public static void doGrow(Plant plant) {
        plant.grow();
    }
}
