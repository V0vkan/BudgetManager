package budget;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class SaveLoad {
    static File file = new File("purchases.txt");

    public static void savePurchases(Map<String, Double> food,Map<String, Double> clothes,
                                     Map<String, Double> entertainment, Map<String, Double> other,
                                     double balance) {

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(food);
            writer.println(clothes);
            writer.println(entertainment);
            writer.println(other);
            writer.println(balance);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadPurchases(Map<String, Double> food,Map<String, Double> clothes,
                                     Map<String, Double> entertainment, Map<String, Double> other) {
        try (Scanner scanner = new Scanner(file)){
            String foodList = scanner.nextLine().replaceAll("}*\\{*", "");
            String[] foodArray = foodList.split(", ");

            String clothesList = scanner.nextLine().replaceAll("}*\\{*", "");
            String[] clothesArray = clothesList.split(", ");

            String entertainmentList = scanner.nextLine().replaceAll("}*\\{*", "");
            String[] entertainmentArray = entertainmentList.split(", ");

            String otherList = scanner.nextLine().replaceAll("}*\\{*", "");
            String[] otherArray = otherList.split(", ");

            Balance.setBalance(Double.parseDouble(scanner.nextLine()));

            for (String s : foodArray) {
                String name = s.replaceAll("=.*", "");
                String price = s.replaceAll(".*=", "");
                food.put(name, Double.parseDouble(price));
            }

            for (String s : clothesArray) {
                String name = s.replaceAll("=.*", "");
                String price = s.replaceAll(".*=", "");
                clothes.put(name, Double.parseDouble(price));
            }

            for (String s : entertainmentArray) {
                String name = s.replaceAll("=.*", "");
                String price = s.replaceAll(".*=", "");
                entertainment.put(name, Double.parseDouble(price));
            }

            for (String s : otherArray) {
                String name = s.replaceAll("=.*", "");
                String price = s.replaceAll(".*=", "");
                other.put(name, Double.parseDouble(price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
