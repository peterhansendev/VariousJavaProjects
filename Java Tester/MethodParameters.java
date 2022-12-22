class Robot {
    public void speak(String text) {
        System.out.println(text);
    }

    public void jump(int height) {
        System.out.println(height);
    }

    public void move(String direction, double distance) {
        System.out.println("Moving " + distance + " meters " + direction);
    }
}

public class MethodParameters {
    public static void main(String[] args) {
        Robot sam = new Robot();

        sam.speak("Hi");
        sam.jump(11);
        sam.move("west", 5);

        String greeting = "Hello there";
        sam.speak(greeting);

        int value = 14;
        sam.jump(value);

    }
}
