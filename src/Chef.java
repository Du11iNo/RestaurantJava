import java.time.LocalDate;

public class Chef extends Employee{


    public Chef(String nid, String nameSurname, LocalDate Birthday) {
        NID = nid;
        NameSurname = nameSurname;
        DateOfStart = LocalDate.now();
        Birthdate = Birthday;
        Paycheck = 1200.0;
    }


}
