
import java.time.*;

public class Waiter extends Employee {

    public Waiter(String nid, String nameSurname, LocalDate birthday) {
        super(nid, nameSurname, birthday);
        Paycheck = 500.0;
    }
}
