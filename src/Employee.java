
import java.time.*;
public class Employee {
    protected String NID;
    protected String NameSurname;
    protected LocalDate DateOfStart;
    protected LocalDate Birthdate;
    protected double Paycheck = 0.0;


    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }

    public String getNameSurname() {
        return NameSurname;
    }

    public void setNameSurname(String nameSurname) {
        NameSurname = nameSurname;
    }

    public LocalDate getDateOfStart() {
        return DateOfStart;
    }

    public LocalDate getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        Birthdate = birthdate;
    }



}
