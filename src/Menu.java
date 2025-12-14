
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
                return false;

            //Check if Food is existing
            for (Product product : menuList)
                if (product.getName().equals(name.toLowerCase()))
                    return false;

            menuList.add(new Product(name.toLowerCase(), price));
            return true;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        catch (Exception e) {
            System.out.println("Error in addFoodToMenu function in Menu class"
                    + System.lineSeparator()
                    + Arrays.toString(e.getStackTrace()));
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
            System.out.println(e.getMessage());
            return false;
        }
        catch (Exception e) {
            System.out.println("Error in removeFoodFromMenu function in Menu class"
                    + System.lineSeparator()
                    + Arrays.toString(e.getStackTrace()));
            return false;
        }
    }

}
