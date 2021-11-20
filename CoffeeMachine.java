package machine;
import java.util.*;

public class CoffeeMachine {

    static int water = 400;
    static int milk = 540;
    static int coffeeBean = 120;
    static int disposableCup = 9;
    static int money = 550;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String selection = scanner.next();
        System.out.println();
        while (!selection.equals("exit")) {
            switch (selection) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    printStatus();
                    break;
            }
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            selection = scanner.next();
            System.out.println();
        }
    }

    private static void printStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBean + " g of coffee beans");
        System.out.println(disposableCup + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private static void fillMachine() {
        System.out.println("Write how many ml of water you want to add:");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addCoffeeBean = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int addDisposableCup = scanner.nextInt();
        water += addWater;
        milk += addMilk;
        coffeeBean += addCoffeeBean;
        disposableCup += addDisposableCup;
    }

    private static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String coffee = scanner.next();
        switch (coffee) {
            case "1":
                if (water >= 250 && coffeeBean >= 16 && disposableCup >= 1) {
                    water -= 250;
                    coffeeBean -= 16;
                    disposableCup--;
                    money += 4;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (coffeeBean < 16) {
                    System.out.println("Sorry, not enough coffee bean!");
                } else {
                    System.out.println("Sorry, not enough disposable cup!");
                }
                break;
            case "2":
                if (water >= 350 && milk >= 75 && coffeeBean >= 20 && disposableCup >= 1) {
                    water -= 350;
                    milk -= 75;
                    coffeeBean -= 20;
                    disposableCup--;
                    money += 7;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffeeBean < 20) {
                    System.out.println("Sorry, not enough coffee bean!");
                } else {
                    System.out.println("Sorry, not enough disposable cup!");
                }
                break;
            case "3":
                if (water >= 200 && milk >= 100 && coffeeBean >= 12 && disposableCup >= 1) {
                    water -= 200;
                    milk -= 100;
                    coffeeBean -= 12;
                    money += 6;
                    disposableCup--;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffeeBean < 12) {
                    System.out.println("Sorry, not enough coffee bean!");
                } else {
                    System.out.println("Sorry, not enough disposable cup!");
                }
                break;
        }
    }
}