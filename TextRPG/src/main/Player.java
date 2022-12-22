package main;

public class Player extends Character {

    public int numAtkUpgrades, numDefUpgrades;

    int gold, restsLeft, pots;

    public String[] atkUpgrades = {"Strength", "Power", "Might", "Goldlike Strength"};
    public String[] defUpgrades = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};

    public Player(String name, int i, int i1) {
        super("name", 0, 0);
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;

        this.gold = 5;
        this.restsLeft = 1;
        this.pots = 0;
        chooseTrait();
    }

    @Override
    public int attack() {

        return (int) (Math.random()*(xp/4 + numAtkUpgrades*3 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1);
    }

    @Override
    public int defend() {

        return (int) (Math.random()*(xp/4 + numDefUpgrades*3 + 3) + xp/10 + numDefUpgrades*2 + numAtkUpgrades + 1);
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
