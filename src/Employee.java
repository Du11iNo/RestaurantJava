
import java.time.*;

//Super Class; used as inheritance
public class Employee {
    private String NID;
    private String NameSurname;
    private Roles role;
    private LocalDate DateOfStart;
    private LocalDate Birthdate;
    private double Paycheck = 0.0;

    public enum Roles {
        Chef,
        Waiter,
        Cleaner /* More to be added (maybe) */
    }

    public Employee(String NID, String nameSurname, Roles role, LocalDate birthdate, double paycheck) {
        this.NID = NID;
        NameSurname = nameSurname;
        this.role = role;
        DateOfStart = LocalDate.now();
        Birthdate = birthdate;
        Paycheck = paycheck;
    }

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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
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
                ", role=" + role +
                ", DateOfStart=" + DateOfStart +
                ", Birthdate=" + Birthdate +
                '}';
    }
}
