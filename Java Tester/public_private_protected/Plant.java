package public_private_protected;

public class Plant {
    public String name;

    public final static int ID = 8;

    private String type;

    protected String size;

    public Plant() {
        name = "Freddy";

        this.type = "plant";

        this.size = "medium";
    }
}
