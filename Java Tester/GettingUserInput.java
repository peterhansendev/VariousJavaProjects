import java.util.Scanner;

public class GettingUserInput {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("line: ");

        double value = input.nextDouble();

        System.out.println("you entered: " + value);
    }
}
