
import java.util.*;
import java.time.*;

//Contains data related to specific table in Restaurant
public class Table {

    private int ID;
    private boolean isTaken = false;
    private LocalDate reservationDate;
    private boolean isReserved = false;

    @SuppressWarnings("FieldMayBeFinal")
    private HashMap<String, Integer> productMap = new HashMap<String, Integer>(); //Contains Food and repeated times

    public Table(int ID) {
        this.ID = ID;
    }

    public Set<Map.Entry<String, Integer>> getProductMap() {
        return productMap.entrySet();
    }

    public boolean addOrder(String orderName, int quantity){

        ArrayList<Product> menu = Menu.getMenu();

        try {
            // Don't allow quantities below or equal to 0
            if (quantity <= 0)
                throw new IllegalArgumentException("Given Quantity is lower than 0");

            // Normalize order name to lowercase
            orderName = orderName.toLowerCase();

            // Set to taken (Adding orders to a table means the table has been taken)
            if (!this.isTaken)
                this.setTaken(true);

            // For every product in the menu
            for (Product product : menu) {
                // Compare in lowercase
                if (product.getName().toLowerCase().equals(orderName)) {
                    // Add quantity if already exists, otherwise put new entry
                    productMap.put(orderName,
                            productMap.getOrDefault(orderName, 0) + quantity);

                    // Stop loop after matching product
                    break;
                }
            }

            return true;
        }
        catch (IllegalArgumentException e) {
            ExceptionHandler.printStackedError(e);
            return false;
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in addOrder function in Table class", e);
            return false;
        }
    }


    public StringBuilder generateReceipt() {

        try {
            ArrayList<Product> menu = Menu.getMenu();

            //Will contain the whole receipt ( Sort of toString() ))
            StringBuilder receipt = new StringBuilder("Date: " + LocalDate.now().toString() + System.lineSeparator());

            double total = 0.0;

            //Here we go again ;(
            for (Map.Entry<String, Integer> productEntrySet : productMap.entrySet()) { //Create entry set (Enhanced ifs don't work on Hashmaps)
                for (Product product : menu) { //For every Food in the Menu specified above
                    if (productEntrySet.getKey().equals(product.getName())) { //If entry key is found on Menu

                        String productName = productEntrySet.getKey();
                        String capitalisedProductName = productName.substring(0, 1).toUpperCase()
                                + productName.substring(1);

                        receipt.append(productEntrySet.getKey().substring(0, 1).toUpperCase()
                                + productEntrySet.getKey().substring(1)
                                + " x " + productEntrySet.getValue() + " : $"
                                + (product.getPrice() * productEntrySet.getValue()) + System.lineSeparator());

                        total += productEntrySet.getValue() * product.getPrice(); //Add gathered costs to total

                    /*
                        Out:
                            Key1 x Value1 : $ (Price1 * Value1) \n
                            Key2 x Value2 : $ (Price2 * Value2) \n
                            .....
                    */

                    }
                }
            }

            CashRegister.addEarnings(total);
            receipt.append("Total: $" + total); //Add the total to receipt

            //Reset Table
            this.setTaken(false);
            this.setReserved(false);
            productMap.clear();

            return receipt;
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
        catch (Exception e) {
            System.err.println("Error in generateReceipt function in Table class"
                    + System.lineSeparator()
                    + Arrays.toString(e.getStackTrace()));
            return null;
        }
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

        try {
            //Don't allow dates before present date
            if (LocalDate.now().isAfter(reserveDate))
                return false;

            isReserved = true;
            reservationDate = reserveDate;

            return true;
        }
        catch (DateTimeException e) {
            System.err.println(e.getMessage());
            return false;
        }
        catch (Exception e) {
            System.err.println("Error in reserveTable function of Table class"
                    + System.lineSeparator()
                    + Arrays.toString(e.getStackTrace()));
            return false;
        }
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
