
import java.time.*;

//Super Class; used as inheritance
public abstract class Employee {
    protected String NID;
    protected String NameSurname;
    protected LocalDate DateOfStart;
    protected LocalDate Birthdate;
    protected double Paycheck = 0.0;

    public Employee(String NID, String nameSurname, LocalDate birthdate) {
        this.NID = NID;
        NameSurname = nameSurname;
        DateOfStart = LocalDate.now();
        Birthdate = birthdate;
    }

    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {this.NID = NID;}

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

    @Override
    public String toString() {
        return "Employee{" +
                "NID='" + NID + '\'' +
                ", NameSurname='" + NameSurname + '\'' +
                ", DateOfStart=" + DateOfStart +
                ", Birthdate=" + Birthdate +
                '}';
    }
}
