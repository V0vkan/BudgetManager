package budget;

import java.util.*;

interface AnalyzeMethod {

    void analyze(PurchasesLists lists);

}

class PurchasesLists {

    private Map<String, Double> food;
    private Map<String, Double> clothes;
    private Map<String, Double> entertainment;
    private Map<String, Double> other;

    public PurchasesLists(Map<String, Double> food, Map<String, Double> clothes, Map<String, Double> entertainment,
                          Map<String, Double> other) {
        this.food = food;
        this.clothes = clothes;
        this.entertainment = entertainment;
        this.other = other;
    }

    public Map<String, Double> getFood() {
        return food;
    }

    public Map<String, Double> getClothes() {
        return clothes;
    }

    public Map<String, Double> getEntertainment() {
        return entertainment;
    }

    public Map<String, Double> getOther() {
        return other;
    }
}

class SortAll implements AnalyzeMethod {

    @Override
    public void analyze(PurchasesLists lists) {
        Map<String, Double> allPurchases = new LinkedHashMap<>();
        allPurchases.putAll(lists.getFood());
        allPurchases.putAll(lists.getClothes());
        allPurchases.putAll(lists.getEntertainment());
        allPurchases.putAll(lists.getOther());
        if (allPurchases.isEmpty()) {
            System.out.println("\nThe purchase list is empty!");
        } else {
            System.out.println("\nAll:");
            PrintPurchasesList.printPurchases(SortByValue.sortByValue(allPurchases));
        }
    }
}

class SortByType implements AnalyzeMethod {

    @Override
    public void analyze(PurchasesLists lists) {
        Map<String, Double> types = new LinkedHashMap<>();
        types.put("Food", Purchases.getTotal(Purchases.getFood()));
        types.put("Entertainment", Purchases.getTotal(Purchases.getEntertainment()));
        types.put("Clothes", Purchases.getTotal(Purchases.getClothes()));
        types.put("Other", Purchases.getTotal(Purchases.getOther()));
        System.out.println("\nTypes:");
        PrintPurchasesList.printPurchasesByType(SortByValue.sortByValue(types));
    }

}

class SortCertainType implements AnalyzeMethod {

    @Override
    public void analyze(PurchasesLists lists) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose the type of purchase" +
                "\n1) Food" +
                "\n2) Clothes" +
                "\n3) Entertainment" +
                "\n4) Other");
        int n = scanner.nextInt();
        switch (n) {
            case 1:
                if (lists.getFood().isEmpty()) {
                    System.out.println("\nThe purchase list is empty!");
                } else {
                    System.out.println("\nFood:");
                    PrintPurchasesList.printPurchases(SortByValue.sortByValue(lists.getFood()));
                }
                break;
            case 2:
                if (lists.getClothes().isEmpty()) {
                    System.out.println("\nThe purchase list is empty!");
                } else {
                    System.out.println("\nClothes:");
                    PrintPurchasesList.printPurchases(SortByValue.sortByValue(lists.getClothes()));
                }
                break;
            case 3:
                if (lists.getEntertainment().isEmpty()) {
                    System.out.println("\nThe purchase list is empty!");
                } else {
                    System.out.println("\nEntertainment:");
                    PrintPurchasesList.printPurchases(SortByValue.sortByValue(lists.getEntertainment()));
                }
                break;
            case 4:
                if (lists.getOther().isEmpty()) {
                    System.out.println("\nThe purchase list is empty!");
                } else {
                    System.out.println("\nOther:");
                    PrintPurchasesList.printPurchases(SortByValue.sortByValue(lists.getOther()));
                }
                break;
        }
    }

}
class SortByValue {

    public static Map<String, Double> sortByValue(Map<String, Double> list) {
        LinkedHashMap<String, Double> reverseSortedMap = new LinkedHashMap<>();

        list.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        return reverseSortedMap;
    }

}

class PrintPurchasesList {
    public static void printPurchases(Map<String, Double> list) {
        double totalPrice = 0;
        for (Map.Entry<String, Double> entry : list.entrySet()) {
            System.out.printf(entry.getKey() + " $%.2f\n", entry.getValue());
            totalPrice += entry.getValue();
        }
        System.out.printf("Total sum: $%.2f\n", totalPrice);
    }

    public static void printPurchasesByType(Map<String, Double> list) {
        double totalPrice = 0;
        for (Map.Entry<String, Double> entry : list.entrySet()) {
            System.out.printf(entry.getKey() + " - $%.2f\n", entry.getValue());
            totalPrice += entry.getValue();
        }
        System.out.printf("Total sum: $%.2f\n", totalPrice);
    }
}
