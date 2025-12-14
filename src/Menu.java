
import java.util.ArrayList;

//Contains all orders/food in an Array
public class Menu {

    private ArrayList<Product> MenuList = new ArrayList<>(); //Food List

    public void printMenu(){
        for (Product product : MenuList)
            System.out.println(product);
    }

    public ArrayList<Product> getMenu(){
        return MenuList;
    }

    public boolean addFoodToMenu(String Name, double Price){

        //Don't allow prices lower than 0
        if (Price<0)
            return false;

        //Check if Food is existing
        for (Product product : MenuList)
            if (product.getName() == Name)
                return false;

        MenuList.add(new Product(Name, Price));
        return true;
    }

    public boolean removeFoodFromMenu(String Name){

        //Find Food in Array & remove it
        for (Product product : MenuList)
            if (product.getName() == Name) {
                MenuList.remove(product);
                return true;
            }
        return false;
    }

}
