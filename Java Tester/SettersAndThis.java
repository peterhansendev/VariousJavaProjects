class Frog {
   private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setInfo(String name, int age) {
        setName(name);
        setAge(age);
    }

}

public class SettersAndThis {
    public static void main(String[] args) {
        
        Frog frog1 = new Frog();

       // frog1.name = "bob";
       // frog1.age = 4;

        frog1.setName("ok");
        System.out.println(frog1.getName());

        frog1.setAge(2);
        System.out.println(frog1.getAge());
    }
}
