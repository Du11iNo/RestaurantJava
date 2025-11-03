
import java.util.ArrayList;

//Contains all orders/food in an Array
public class Menu {

    private ArrayList<Order> MenuList = new ArrayList<>(); //Food List

    public void printMenu(){
        for (Order order: MenuList)
            System.out.println(order);
    }

    public ArrayList<Order> getMenu(){
        return MenuList;
    }

    public boolean addFoodToMenu(String Name, double Price){

        //Don't allow prices lower than 0
        if (Price<0)
            return false;

        //Check if Food is existing
        for (Order order: MenuList)
            if (order.getName() == Name)
                return false;

        MenuList.add(new Order(Name, Price));
        return true;
    }

    public boolean removeFoodFromMenu(String Name){

        //Find Food in Array & remove it
        for (Order order: MenuList)
            if (order.getName() == Name) {
                MenuList.remove(order);
                return true;
            }
        return false;
    }

}
