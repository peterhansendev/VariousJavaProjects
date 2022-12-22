class Person1 {
    String name;
    int age;

    void speak() {
        System.out.println("My name is: " + name);
    }

    int calculate() {
        int yearsLeft = 65 - age;
        return yearsLeft;
    }

    int getAge() {
        return age;
    }

    String getName() {
        return name;
    }
}

public class GettersSetters {
    public static void main(String[] args) {
        Person1 person1 = new Person1();

        person1.name = "Joe";
        person1.age = 25;
        person1.speak();
        int years = person1.calculate();
        System.out.println("years left: " + years);

        int age = person1.getAge();
        System.out.println(age);

        String name = person1.getName();
        System.out.println(name);
    }
}
