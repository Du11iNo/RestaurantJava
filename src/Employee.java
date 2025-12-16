
import java.time.*;

//Super Class; used as inheritance
public abstract class Employee {
    protected String NID;
    protected String nameSurname;
    protected LocalDate dateOfStart;
    protected LocalDate birthdate;
    protected double paycheck = 0.0;

    public Employee(String NID, String nameSurname, LocalDate birthdate) {
        this.NID = NID;
        this.nameSurname = nameSurname;
        this.dateOfStart = LocalDate.now();
        this.birthdate = birthdate;
    }

    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {this.NID = NID;}

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        nameSurname = nameSurname;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        birthdate = birthdate;
    }

    public double getPaycheck() {
        return paycheck;
    }

    public void setPaycheck(double paycheck) {
        this.paycheck = paycheck;
    }

    public static void hire(String NID, String nameSurname, LocalDate birthdate) {
        return;
    }

    public double calculatePaycheck(){
        return paycheck;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "NID='" + NID + '\'' +
                ", NameSurname='" + nameSurname + '\'' +
                ", DateOfStart=" + dateOfStart +
                ", Birthdate=" + birthdate +
                '}';
    }
}
