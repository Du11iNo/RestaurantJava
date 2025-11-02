
import java.util.ArrayList;
import java.time.*;
import java.util.HashMap;
import java.util.Map;

public class Table {

    private int ID;
    private boolean isTaken = false;
    private LocalDate reservationDate;
    private boolean isReserved = false;
    private HashMap<String, Integer> OrderList = new HashMap<String, Integer>();


    public Table(int ID) {
        this.ID = ID;
    }

    public boolean addOrder(String OrderName, int Quantity, ArrayList<Order> SpecificMenu){
        if (Quantity <= 0)
            return false;

        if (!this.isTaken)
            this.setTaken(true);

        for (Order order: SpecificMenu)
            if (order.getName() == OrderName){
                if (OrderList.containsKey(OrderName))
                    OrderList.replace(OrderName, OrderList.get(OrderName) + Quantity);
                else
                    OrderList.put(OrderName, Quantity);
            }

        return true;
    }

    public String generateReceipt(ArrayList<Order> SpecificMenu) {

        String receipt = "";
        double total = 0.0;

        for (Map.Entry<String, Integer> orderMap: OrderList.entrySet()) {
            for (Order order : SpecificMenu) {
                if (orderMap.getKey() == order.getName()){
                    receipt += (orderMap.getKey() + " x " + orderMap.getValue() + " : $" +
                            (order.getPrice() * orderMap.getValue()) + System.lineSeparator());
                    total += orderMap.getValue() * order.getPrice();
                }
            }
        }

        receipt += "Total: $" + total;

        this.setTaken(false);
        this.setReserved(false);

        OrderList.clear();

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
