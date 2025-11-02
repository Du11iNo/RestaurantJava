
import java.util.ArrayList;
public class Menu {

    private ArrayList<Order> MenuList = new ArrayList<>();

    public void printMenu(){
        for (Order order: MenuList)
            System.out.println(order);
    }

    public ArrayList<Order> getMenu(){
        return MenuList;
    }

    public boolean addFoodToMenu(String Name, double Price){
        if (Price<0)
            return false;

        for (Order order: MenuList)
            if (order.getName() == Name)
                return false;

        MenuList.add(new Order(Name, Price));
        return true;
    }

    public boolean removeFoodFromMenu(String Name){
        for (Order order: MenuList)
            if (order.getName() == Name) {
                MenuList.remove(order);
                return true;
            }
        return false;
    }

}
