package main;

import javax.xml.namespace.QName;
import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;
    static Player1 player1;
    static Player2 player2;

    public static boolean isRunning;

    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};

    public static String[] enemies = {"Orge", "Orge", "Goblin", "Goblin", "Stone Elemental"};
    public static int place = 0, act = 1;
    public static String[] places = {"Mountains", "Landlines", "Castle", "Throne Room"};

    public static int readInt(String prompt, int userChoices) {
        int input;

        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter an integer");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue");
        scanner.next();
    }

    public static void startGame() {
        boolean nameSet = false;
        String name;
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("AGE OF THE EVIL EMPEROR");
        System.out.println("TEXT RPG");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();

        do {
            clearConsole();
            printHeading("CHOOSE CHARACTER");
            System.out.println("(1) Player1\n(2) Player2");
            int input = readInt("-> ", 2);
            if(input == 1) {
                System.out.println("Player1");

                player.chooseTrait();
                player = new Player1("name1");


            } else if (input == 2) {
                System.out.println("Player2");
                player.chooseTrait();
                player = new Player1("name1");

            }
            nameSet = true;
            anythingToContinue();
            gameLoop();
        } while (!nameSet);

        Story.printIntro();

        //player = new Player("name", 0, 0);

        Story.printFristActIntro();

        isRunning = true;

        //choosePlayer();
        gameLoop();
    }
/*
    public static void choosePlayer() {
        clearConsole();
        printHeading("CHOOSE CHARACTER");
        System.out.println("(1) Player1\n(2) Player2");
        int input = readInt("-> ", 2);
        if(input == 1) {
            System.out.println("Player1");
            player = player1();

        } else if (input == 2) {
            System.out.println("Player2");
            player = player2;
        }
        anythingToContinue();
        gameLoop();
    }*/

    public static void checkAct() {
        if (player.xp >= 10 && act == 1) {
            act = 2;
            place = 1;
            Story.printFirstActOutro();
            player.chooseTrait();
            Story.printSecondActIntro();

            enemies[0] = "Evil Mercenary";
            enemies[1] = "Goblin";
            enemies[2] = "Wolve Pack";
            enemies[3] = "Henchman of the Evil Emperor";
            enemies[4] = "Stranger";

            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";
        } else if (player.xp >= 50 && act == 2) {
            act = 3;
            place = 2;
            Story.printSecondActOutro();
            player.chooseTrait();
            Story.printThirdActIntro();

            enemies[0] = "Evil Mercenary";
            enemies[1] = "Goblin";
            enemies[2] = "Wolve Pack";
            enemies[3] = "Henchman of the Evil Emperor";
            enemies[4] = "Stranger";

            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";

            player.hp = player.maxHp;
        } else if (player.xp >= 100 && act == 3) {
            act = 4;
            place = 3;
            Story.printThirdActOutro();
            player.chooseTrait();
            Story.printFourthActIntro();
            player.hp = player.maxHp;
            finalBattle();
        }
    }

    public static void randomEncounter() {
        int encounter = (int) (Math.random() * encounters.length);

        if (encounters[encounter].equals("Battle")) {
            randomBattle();
        } else if (encounters[encounter].equals("Rest")) {
            takeRest();
        } else {
            shop();
        }
    }

    public static void continueJourney() {
        checkAct();

        if (act != 4)
            randomEncounter();
    }

    public static void characterInfo() {
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP: " + player.xp);
        printSeparator(20);
        System.out.println("# of Potions: " + player.pots);
        printSeparator(20);

        if (player.numAtkUpgrades > 0) {
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(20);
        }
        if (player.numDefUpgrades > 0) {
            System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
        }
        anythingToContinue();
    }

    public static void shop() {
        clearConsole();
        printHeading("You meet a mysterious stranger. \nHe offers you something:");
        int price = (int) (Math.random() * (10 + player.pots*3) + 10 + player.pots);
        System.out.println("- Magic Potion: " + price + " gold.");
        printSeparator(20);
        System.out.println("Do you want to buy one?\n(1) Yes!\n(2) No thanks.");
        int input = readInt("-> ", 2);
        if(input == 1) {
            clearConsole();
            if(player.gold >= price) {
                printHeading("You bought a magical potion for " + price + "gold");
                player.pots++;
                player.gold -= price;
            } else printHeading("You don't have enough gold to buy this..");
            anythingToContinue();
        }
    }

    public static void takeRest() {
        clearConsole();
        if(player.restsLeft >= 1) {
            printHeading("Do you want to take a rest: (" + player.restsLeft + " rest(s) left).");
            System.out.println("(1) Yes\n(2) No, not now.");
            int input = readInt("-> ", 2);
            if(input == 1) {
                clearConsole();
                if(player.hp < player.maxHp) {
                    int hpResorted = (int) (Math.random() * (player.xp/4 + 1) + 10);
                    player.hp += hpResorted;
                    if(player.hp > player.maxHp)
                        player.hp = player.maxHp;
                    System.out.println("You took a rest and restored up to " + hpResorted + " health.");
                    System.out.println("You're now at " + player.hp + "/" + player.maxHp + " health.");
                    player.restsLeft--;
                }
            } else
                System.out.println("You're at full health");
            anythingToContinue();
        }
    }

    public static void randomBattle() {
        clearConsole();
        printHeading("You encountered an enemy. Time to fight!");
        anythingToContinue();
        battle(new Enemy(enemies[(int) (Math.random() * enemies.length)], player.xp));
    }

    public static void battle(Enemy enemy) {
        while (true) {
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Choose an action:");
            printSeparator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Run Away");
            int input = readInt("-> ", 3);
            if (input == 1) {
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();

                if (dmgTook < 0) {
                    dmg -= dmgTook / 2;
                    dmgTook = 0;
                }
                    if (dmg < 0)
                        dmg = 0;
                    player.hp -= dmgTook;
                    enemy.hp -= dmg;
                    clearConsole();
                    printHeading("BATTLE");
                    System.out.println("You dealt " + dmg + " damage to the " + enemy.name + ".");
                    printSeparator(15);
                    System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
                    anythingToContinue();

                    if (player.hp <= 0) {
                        playerDied();
                        break;
                    } else if (enemy.hp <= 0) {
                        clearConsole();
                        printHeading("You defeated the " + enemy.name + "!");
                        player.xp += enemy.xp;
                        System.out.println("You earned " + enemy.xp + " XP!");
                        boolean addRest = (Math.random()*5 + 1 <= 2.25);
                        int goldEarned = (int) (Math.random() * enemy.xp);
                        if(addRest) {
                            player.restsLeft++;
                            System.out.println("You earned the chance to get an additional rest!");
                        }
                        if(goldEarned > 0) {
                            player.gold += goldEarned;
                            System.out.println("You collect " + goldEarned + " gold from the " + enemy.name);
                        }
                        anythingToContinue();
                        break;
                    }

            } else if (input == 2) {
                clearConsole();
                if(player.pots > 0 && player.hp < player.maxHp) {
                    printHeading("Do you want to drink a potion? (" + player.pots + " left).");
                    System.out.println("(1) Yes\n(2) No, maybe later.");
                    input = readInt("-> ", 2);
                    if (input == 1) {
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("You drank a magic potion. It restored your health back to " + player.maxHp);
                        anythingToContinue();
                    }
                } else {
                    printHeading("You don't have any potions or you're at full health");
                    anythingToContinue();
                }

            } else {
                clearConsole();
                if (act != 4) {

                    if (Math.random() * 10 + 1 <= 3.5) {
                        printHeading("You ran away from the " + enemy.name + "!");
                        anythingToContinue();
                        break;
                    } else {
                        printHeading("You didn't manage to escape.");
                        int dmgTook = enemy.attack();
                        System.out.println("You took  " + dmgTook + " damage!");
                        player.hp -= dmgTook;
                        anythingToContinue();
                        if (player.hp <= 0)
                            playerDied();
                        }
                    } else {
                        printHeading("You cannot escape!");
                        anythingToContinue();
                    }
                }
            }
        }


    public static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action:");
        printSeparator(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
    }

    public static void finalBattle() {
        battle(new Enemy("THE EVIL EMPEROR", 300));
        Story.printEnd(player);
        isRunning = false;
    }
    public static void playerDied() {
        clearConsole();
        printHeading("You died...");
        printHeading("You earned " + player.xp + " XP on your journey. try to earn more next time!");
    }
    public static void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = readInt("-> ", 3);
            if (input == 1) {
                continueJourney();
            } else if (input == 2) {
                characterInfo();
            } else {
                isRunning = false;
            }
        }
    }
}
