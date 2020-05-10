package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void printStatus(int water, int milk, int beans, int cups, int money){
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water \n", water);
        System.out.printf("%d of milk \n", milk);
        System.out.printf("%d of coffee beans \n", beans);
        System.out.printf("%d of disposable cups \n", cups);
        System.out.printf("$%d of money \n", money);
    }

    public static void checkResources(int water, int beans, int cups, int water_c, int beans_c) {
        if (water / water_c < 1) {
            System.out.println("Sorry, not enough water!");
        } else if (beans / beans_c < 1) {
            System.out.println("Sorry, not enough beans!");
        } else if (cups == 0) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        int water_c = 0;
        int milk_c = 0;
        int beans_c = 0;

    loop: while (true) {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scan.nextLine();
        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String coffee = scan.nextLine();
                switch (coffee) {
                    case "1":
                        water_c = 250;
                        beans_c = 16;
                        checkResources(water, beans, cups, water_c,beans_c);
                        water -= water_c;
                        beans -= beans_c;
                        money += 4;
                        cups -= 1;
                        break;
                    case "2":
                        water_c = 350;
                        milk_c = 75;
                        beans_c = 20;
                        checkResources(water, beans, cups, water_c,beans_c);
                        if (water / water_c >= 1) {
                            water -= water_c;
                            milk -= milk_c;
                            beans -= beans_c;
                            money += 7;
                            cups -= 1;
                        }
                        break;
                    case "3":
                        water_c = 200;
                        milk_c = 100;
                        beans_c = 12;
                        checkResources(water, beans, cups, water_c,beans_c);
                        water -= water_c;
                        milk -= milk_c;
                        beans -= beans_c;
                        money += 6;
                        cups -= 1;
                        break;
                    case "back":
                        break;
                }
                break;
            case "fill":
                System.out.println("Write how many ml of water do you want to add:");
                water += scan.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                milk += scan.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                beans += scan.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                cups += scan.nextInt();
                scan.nextLine();
                break;
            case "take":
                System.out.printf("I gave you $%d \n", money);
                money = 0;
                break;
            case "remaining":
                printStatus(water, milk, beans, cups, money);
                break;
            case "exit":
                break loop;
        }
    }
    }
}