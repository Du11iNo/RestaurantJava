
import java.util.ArrayList;
import java.util.Arrays;

//Contains all orders/food in an Array
public class Menu {

    private static ArrayList<Product> menuList = new ArrayList<>(); //Food List

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

    public static boolean removeFoodFromMenu(String name) {

        try {
        //Find Food in Array & remove it
        for (Product product : menuList)
            if (product.getName().equals(name.toLowerCase())) {
                menuList.remove(product);
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
