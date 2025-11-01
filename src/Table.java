
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
}
