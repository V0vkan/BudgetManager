package budget;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static boolean exit = false;
    static Analyzer analyzer = new Analyzer();

    public static void printMenu() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("7) Analyze (Sort)");
        System.out.println("0) Exit");
    }

    public static void selectAction(int n) {
        switch (n) {
            case 1:
                System.out.println("\nEnter income:");
                Balance.addIncome(scanner.nextDouble());
                System.out.println("Income was added!\n");
                break;
            case 2:
                Purchases.selectType();
                break;
            case 3:
                Purchases.showPurchases();
                break;
            case 4:
                System.out.printf("\nBalance: $%.2f\n\n", Balance.getBalance());
                break;
            case 5:
                SaveLoad.savePurchases(Purchases.getFood(), Purchases.getClothes(),
                        Purchases.getEntertainment(), Purchases.getOther(),
                        Balance.getBalance());
                System.out.println("\nPurchases were saved!\n");
                break;
            case 6:
                SaveLoad.loadPurchases(Purchases.getFood(), Purchases.getClothes(),
                        Purchases.getEntertainment(), Purchases.getOther());
                System.out.println("\nPurchases were loaded!\n");
                break;
            case 7:
                boolean flag = true;
                while (flag) {
                    System.out.println("\nHow do you want to sort?" +
                            "\n1) Sort all purchases" +
                            "\n2) Sort by type" +
                            "\n3) Sort certain type" +
                            "\n4) Back");
                    int j = scanner.nextInt();
                    switch (j) {
                        case 1:
                            analyzer.setMethod(new SortAll());
                            analyzer.analyze();
                            break;
                        case 2:
                            analyzer.setMethod(new SortByType());
                            analyzer.analyze();
                            break;
                        case 3:
                            analyzer.setMethod(new SortCertainType());
                            analyzer.analyze();
                            break;
                        case 4:
                            System.out.println();
                            flag = false;
                            break;
                    }
                }
                break;
            case 0:
                System.out.println("\nBye!");
                exit = true;
                break;
        }
    }


}
