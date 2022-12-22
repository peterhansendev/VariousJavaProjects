class Machine {
    private String name;
    private int code;

    public Machine() {
        this("Arine", 0);
        System.out.println("First constructor");

    }

    public Machine(String name) {
        this(name, 0);

        System.out.println("Second constructor");
        this.name = name;
    }

    public Machine(String name, int code) {
        System.out.println("Third constructor");
        this.name = name;
        this.code = code;
    }
}

public class Construtors {
    public static void main(String[] args) {
        Machine machine1 = new Machine();

        Machine machine2 = new Machine("Bert");

        Machine machine3 = new Machine("Bert", 9);

    }
}
