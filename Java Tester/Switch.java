import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("please enter a command: ");
        String text = input.nextLine();

        switch (text) {
            case "start":
                System.out.println("Started");
                break;

            case "stop":
                System.out.println("Stopped");
                break;

            default:
                System.out.println("Command not recognized");
        }
    }
}
