
import java.util.ArrayList;
import java.util.Arrays;

//Contains all orders/food in an Array
public class Menu {

    private ArrayList<Product> MenuList = new ArrayList<>(); //Food List

    public void printMenu() {
        for (Product product : MenuList)
            System.out.println(product);
    }

    public ArrayList<Product> getMenu() {
        return MenuList;
    }

    public boolean addFoodToMenu(String Name, double Price) {

        try {
            //Don't allow prices lower than 0
            if (Price < 0)
                return false;

            //Check if Food is existing
            for (Product product : MenuList)
                if (product.getName().equals(Name))
                    return false;

            MenuList.add(new Product(Name, Price));
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

    public boolean removeFoodFromMenu(String Name) {

        try {
        //Find Food in Array & remove it
        for (Product product : MenuList)
            if (product.getName().equals(Name)) {
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
