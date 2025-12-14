
import java.util.ArrayList;
import java.util.Arrays;

//Contains all orders/food in an Array
public class Menu {

    private static ArrayList<Product> MenuList = new ArrayList<>(); //Food List

    public static void printMenu() {
        for (Product product : MenuList)
            System.out.println(product);
    }

    public static ArrayList<Product> getMenu() {
        return MenuList;
    }

    public static boolean addFoodToMenu(String Name, double Price) {

        try {
            //Don't allow prices lower than 0
            if (Price < 0)
                return false;

            //Check if Food is existing
            for (Product product : MenuList)
                if (product.getName().equals(Name.toLowerCase()))
                    return false;

            MenuList.add(new Product(Name.toLowerCase(), Price));
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

    public static boolean removeFoodFromMenu(String Name) {

        try {
        //Find Food in Array & remove it
        for (Product product : MenuList)
            if (product.getName().equals(Name.toLowerCase())) {
                MenuList.remove(product);
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
