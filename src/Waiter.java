
import java.time.*;

public class Waiter extends Employee {


    public Waiter(String nid, String nameSurname, LocalDate Birthday) {
        NID = nid;
        NameSurname = nameSurname;
        DateOfStart = LocalDate.now();
        Birthdate = Birthday;
        Paycheck = 500.0;
    }

}
