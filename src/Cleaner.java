
import java.time.LocalDate;

public class Cleaner extends Employee{

    public Cleaner(String nid, String nameSurname, LocalDate Birthday) {
        NID = nid;
        NameSurname = nameSurname;
        DateOfStart = LocalDate.now();
        Birthdate = Birthday;
        Paycheck = 300.0;
    }

}
