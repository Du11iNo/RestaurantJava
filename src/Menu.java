
import java.io.File;
import java.io.IOException;
import java.util.*;

//Contains all orders/food in an Array
public class Menu {

    private static ArrayList<Product> menuList = new ArrayList<>(); //Food List
    private static String filePath = "Menu.txt";

    public static void printMenu() {
        for (Product product : menuList)
            System.out.println(product);
    }

    public static ArrayList<Product> getMenu() {
        return menuList;
    }

    public static boolean addFoodToMenu(String name, double price) {

        try {
            //Don't allow prices lower than 0
            if (price < 0)
                throw new IllegalArgumentException("Price is lower than 0 ");

            //Check if Food is existing
            for (Product product : menuList)
                if (product.getName().equals(name.toLowerCase()))
                    return false;

            menuList.add(new Product(name.toLowerCase(), price));
            writeMenuFile();
            return true;
        }
        catch (IllegalArgumentException e) {
            ExceptionHandler.printStackedError(e);
            return false;
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in addFoodToMenu function in Menu class", e);
            return false;
        }
    }

    private static void writeMenuFile() {
        try{
            List<String> lines = new ArrayList<String>();
            String format = "%s:%.2f";
            lines.add("Product-Price");

            for (Product p: getMenu())
                lines.add(String.format(format, p.getName(), p.getPrice()));

            FileHandler.writeToFile(filePath, format, lines);
        }
        catch (NullPointerException e) {
            ExceptionHandler.printStackedError(e);
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in writeMenuFile function in Menu class", e);
        }
    }

    public static void readMenuFromFile() {
        try {
            String[] lines = FileHandler.readFile(filePath);

            for (int i = 1; i < lines.length; i++) {
                String[] parts = lines[i].split(":");
                String productName = parts[0];
                double price = Double.parseDouble(parts[1]);

                addFoodToMenu(productName, price);
            }
        }
        catch (NullPointerException e) {
            ExceptionHandler.printStackedError(e);
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in readMenuFromFile function in Menu class", e);
        }
    }

    public static boolean removeFoodFromMenu(String name) {

        try {
        //Find Food in Array & remove it
        for (Product product : menuList)
            if (product.getName().equals(name.toLowerCase())) {
                menuList.remove(product);
                writeMenuFile();
                return true;
            }
        return false;
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in removeFoodFromMenu function in Menu class", e);
            return false;
        }
    }

}
