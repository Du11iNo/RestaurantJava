
import java.time.LocalDate;

public class Chef extends Employee{

    public Chef(String nid, String nameSurname, LocalDate birthday) {
        super(nid, nameSurname, birthday);
        Paycheck = 1200.0;
    }
}
