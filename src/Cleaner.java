
import java.time.LocalDate;

public class Cleaner extends Employee{

    public Cleaner(String nid, String nameSurname, LocalDate birthday) {
        super(nid, nameSurname, birthday);
        Paycheck = 300.0;
    }
}
