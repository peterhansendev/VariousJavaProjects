public class ok {
}
package main;

        import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;
    public static int readInt(String prompt, int userChoices) {
        int input;

        do{
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter an integer");
            }
        }while (input < 1 || input > userChoices);
        return input;
    }

    public static void clearConsole() {
        for(int i = 0; i < 100; i++) {
            System.out.println();
        }

    }
    public static void printSeperator(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void printHeading(String title) {
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);
    }

    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue");
        scanner.next();
    }

    public static void startGame() {
        boolean nameSet = false;
        String name;
        clearConsole();
        printSeperator(40);
        printSeperator(30);
        System.out.println("AGE OF THE EVIL EMPEROR");
        System.out.println("TEXT RPG");
        printSeperator(30);
        printSeperator(40);
        anythingToContinue();

        do{
            clearConsole();
            printHeading("What's your name");
            name = scanner.next();
            clearConsole();
            printHeading("Your name is " + name + "\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change my name.");
            int input = readInt("-> ", 2);
            if(input == 1)
                nameSet = true;
        } while (!nameSet);

        player = new Player(name);
    }
}

package main;

public class Player extends Character {

    public int numAtkUpgrades, numDefUpgrades;

    public String[] atkUpgrades = {"Strength", "Power", "Might", "Goldlike Strength"};
    public String[] defUpgrades = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};

    public Player(String name) {
        super(name, 100, 0);
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;

        chooseTrait();
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

    public void chooseTrait() {
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait:");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);

        int input = GameLogic.readInt("-> ", 2);
        GameLogic.clearConsole();

        if(input == 1) {
            GameLogic.printHeading("You chose " + atkUpgrades[numAtkUpgrades]);
            numAtkUpgrades++;
        } else {
            GameLogic.printHeading("You chose " + defUpgrades[numDefUpgrades]);
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
    }
}
