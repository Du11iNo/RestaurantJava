
import java.util.ArrayList;
import java.time.*;

public class Table {

    private int ID;
    private boolean isTaken = false;
    private LocalDate reservationDate;
    private boolean isReserved = false;

    public boolean addOrder(/*...*/){
        return false;
    }

    public boolean generateReceipt(){
        return false;
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
