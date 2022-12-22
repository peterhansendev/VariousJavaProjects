package equals;

import java.util.Objects;

class Person {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}



public class App {
    public static void main(String[] args) {

        Person person1 = new Person(5, "Bob");
        Person person2 = new Person(8, "Sue");

        System.out.println(person1 != person2);

    }
}
