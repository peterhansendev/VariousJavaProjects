package generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();

        strings.add("cat");
        strings.add("dog");

        String animal = strings.get(1);
        System.out.println(animal);

        HashMap<Integer, String> map = new HashMap<Integer, String>();
    }

}
