class Person {
    String name;
    int age;

    void speak() {
        System.out.println("hello " + age);
    }

    void sayHello() {
        System.out.println("yo");
    }
}

public class ClassesAndObjects {
    public static void main(String[] args) {

        Person person1 = new Person();
        person1.name = "Joe";
        person1.age = 3;
        person1.speak();
        person1.sayHello();

        Person person2 = new Person();
        person2.name = "Joe2";
        person2.age = 23;

        System.out.println(person1.name);
    }
}
