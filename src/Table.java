
import java.util.ArrayList;
import java.time.*;
import java.util.HashMap;
import java.util.Map;

//Contains data related to specific table in Restaurant
public class Table {

    private int ID;
    private boolean isTaken = false;
    private LocalDate reservationDate;
    private boolean isReserved = false;
    private HashMap<String, Integer> OrderMap = new HashMap<String, Integer>(); //Contains Food and repeated times


    public Table(int ID) {
        this.ID = ID;
    }

    public boolean addOrder(String OrderName, int Quantity, ArrayList<Product> SpecificMenu){

        //Don't allow quantities below or equal to 0
        if (Quantity <= 0)
            return false;

        //Set to taken (Adding orders to a table means the table has been taken and orders have been made)
        if (!this.isTaken)
            this.setTaken(true);

        //Here we go now :(
        for (Product product : SpecificMenu) //For every Food in the Menu specified above
            if (product.getName() == OrderName){ //Check if argument Order (OrderName) exists in Menu (Menu's Food List)
                if (OrderMap.containsKey(OrderName))
                    //Check if entry is already registered to OrderMap
                    //then add the quantity
                    OrderMap.replace(OrderName, OrderMap.get(OrderName) + Quantity);

                    /*
                        Example:
                            Person A in Table 1 ordered 3 Chicken plates
                            Previously, he had ordered 1 Chicken plate
                            In OrderMap -> {Chicken = 1 + 3}
                    */

                else
                    //Simply add entry
                    OrderMap.put(OrderName, Quantity);
            }

        return true;
    }

    public String generateReceipt(ArrayList<Product> SpecificMenu) {

        //Will contain the whole receipt ( Sort of toString() ))
        String receipt = "Date: " + LocalDate.now().toString() + System.lineSeparator();

        double total = 0.0;

        //Here we go again ;(
        for (Map.Entry<String, Integer> orderMap: OrderMap.entrySet()) { //Create entry set (Enhanced ifs don't work on Hashmaps)
            for (Product product : SpecificMenu) { //For every Food in the Menu specified above
                if (orderMap.getKey() == product.getName()){ //If entry key is found on Menu

                    receipt += (orderMap.getKey() + " x " + orderMap.getValue() + " : $" +
                            (product.getPrice() * orderMap.getValue()) + System.lineSeparator());
                    total += orderMap.getValue() * product.getPrice(); //Add gathered costs to total

                    /*
                        Out:
                            Key1 x Value1 : $ (Price1 * Value1) \n
                            Key2 x Value2 : $ (Price2 * Value2) \n
                            .....
                    */

                }
            }
        }

        receipt += "Total: $" + total; //Add the total to receipt

        //Reset Table
        this.setTaken(false);
        this.setReserved(false);
        OrderMap.clear();

        return receipt;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public boolean reserveTable(LocalDate reserveDate /*, ...*/){

        //Don't allow dates before present date
        if (LocalDate.now().isAfter(reserveDate))
            return false;

        isReserved = true;
        reservationDate = reserveDate;

        return true;
    }

    public boolean takeTable(){
        isTaken = true;
        return true;
    }

    @Override
    public String toString(){
        return "Table [ ID: " + ID + ", Taken: " + isTaken + ", " +
                (isReserved ? "Is Reserved for Date: " + reservationDate : "No reservations")
                + "]";
    }

}
