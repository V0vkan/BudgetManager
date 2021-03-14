package budget;

import java.util.*;

public class Purchases {
    static Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);

    private static Map<String, Double> food = new LinkedHashMap<>();
    private static Map<String, Double> clothes = new LinkedHashMap<>();
    private static Map<String, Double> entertainment = new LinkedHashMap<>();
    private static Map<String, Double> other = new LinkedHashMap<>();

    private static double totalPrice = 0;

    public static void selectType() {
        boolean flag = true;
        while (flag) {
            System.out.println("\nChoose the type of purchase" +
                    "\n1) Food" +
                    "\n2) Clothes" +
                    "\n3) Entertainment" +
                    "\n4) Other" +
                    "\n5) Back");

            int n = scanner.nextInt();

            switch (n) {
                case 1:
                    addPurchase(food);
                    break;
                case 2:
                    addPurchase(clothes);
                    break;
                case 3:
                    addPurchase(entertainment);
                    break;
                case 4:
                    addPurchase(other);
                    break;
                case 5:
                    System.out.println();
                    flag = false;
                    break;
            }
        }
    }

    private static void addPurchase(Map<String, Double> name) {
        System.out.println("\nEnter purchase name:");
        scanner.nextLine();
        String purchaseName = scanner.nextLine();
        System.out.println("Enter its price:");
        double price = scanner.nextDouble();
        name.put(purchaseName, price);
        Balance.removeBalance(price);
        System.out.println("Purchase was added!");
    }

    public static void showPurchases() {
        if (food.isEmpty() && clothes.isEmpty() && entertainment.isEmpty() && other.isEmpty()) {
            System.out.println("\nThe purchase list is empty!\n");
        } else {
            boolean flag = true;
            while (flag) {
                System.out.println("\nChoose the type of purchase" +
                        "\n1) Food" +
                        "\n2) Clothes" +
                        "\n3) Entertainment" +
                        "\n4) Other" +
                        "\n5) All" +
                        "\n6) Back");


                int n = scanner.nextInt();

                switch (n) {
                    case 1 :
                        System.out.println("\nFood:");
                        if (food.isEmpty()) {
                            System.out.println("The purchase list is empty!");
                        } else {
                            for (Map.Entry<String, Double> entry : food.entrySet()) {
                                System.out.printf(entry.getKey() + " $%.2f\n", entry.getValue());
                            }
                            System.out.printf("Total sum: $%.2f\n", getTotal(food));
                        }
                        break;
                    case 2 :
                        System.out.println("\nClothes:");
                        if (clothes.isEmpty()) {
                            System.out.println("The purchase list is empty!");
                        } else {
                            for (Map.Entry<String, Double> entry : clothes.entrySet()) {
                                System.out.printf(entry.getKey() + " $%.2f\n", entry.getValue());
                            }
                            System.out.printf("Total sum: $%.2f\n", getTotal(clothes));
                        }
                        break;
                    case 3 :
                        System.out.println("\nEntertainment:");
                        if (entertainment.isEmpty()) {
                            System.out.println("The purchase list is empty!");
                        } else {
                            for (Map.Entry<String, Double> entry : entertainment.entrySet()) {
                                System.out.printf(entry.getKey() + " $%.2f\n", entry.getValue());
                            }
                            System.out.printf("Total sum: $%.2f\n", getTotal(entertainment));
                        }
                        break;
                    case 4 :
                        System.out.println("\nOther:");
                        if (other.isEmpty()) {
                            System.out.println("The purchase list is empty!");
                        } else {
                            for (Map.Entry<String, Double> entry : other.entrySet()) {
                                System.out.printf(entry.getKey() + " $%.2f\n", entry.getValue());
                            }
                            System.out.printf("Total sum: $%.2f\n", getTotal(other));
                        }
                        break;
                    case 5 :
                        System.out.println("\nAll:");
                        for (Map.Entry<String, Double> entry : food.entrySet()) {
                            System.out.printf(entry.getKey() + " $%.2f\n", entry.getValue());
                        }
                        for (Map.Entry<String, Double> entry : clothes.entrySet()) {
                            System.out.printf(entry.getKey() + " $%.2f\n", entry.getValue());
                        }
                        for (Map.Entry<String, Double> entry : entertainment.entrySet()) {
                            System.out.printf(entry.getKey() + " $%.2f\n", entry.getValue());
                        }
                        for (Map.Entry<String, Double> entry : other.entrySet()) {
                            System.out.printf(entry.getKey() + " $%.2f\n", entry.getValue());
                        }
                        System.out.printf("Total sum: $%.2f\n",  getTotal(food) + getTotal(clothes) +
                                getTotal(entertainment) + getTotal(other));
                        break;
                    case 6 :
                        flag = false;
                        break;
                }
            }
            System.out.println();
        }
    }

    public static Map<String, Double> getFood() {
        return food;
    }
    public static Map<String, Double> getClothes() {
        return clothes;
    }
    public static Map<String, Double> getEntertainment() {
        return entertainment;
    }
    public static Map<String, Double> getOther() {
        return other;
    }

    public static double getTotal(Map<String, Double> list) {
        double total = 0;
        if (!list.isEmpty()) {
            for (Map.Entry<String, Double> entry : list.entrySet()) {
                total += entry.getValue();
            }
        }
        return total;
    }

}
