
import java.time.*;

public class Waiter extends Employee {

    private double bonus = 0.0;

    public Waiter(String nid, String nameSurname, LocalDate birthday) {
        super(nid, nameSurname, birthday);
        paycheck = 500.0;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public static boolean Hire(String NID, String nameSurname, LocalDate birthdate) {
        try {
            //Don't allow birthdates after present time; Same for other roles
            if (birthdate.isAfter(LocalDate.now()))
                throw new DateTimeException("Given date is after present date");

            Restaurant.getEmployeeList().add(new Waiter(NID, nameSurname, birthdate));
            return true;
        }
        catch (DateTimeException e) {
            ExceptionHandler.printStackedError(e);
            return false;
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in Hire function in Waiter Class", e);
            return false;
        }
    }

    @Override
    public double calculatePaycheck() {
        return paycheck + getBonus();
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "NID='" + NID + '\'' +
                ", nameSurname='" + nameSurname + '\'' +
                ", dateOfStart=" + dateOfStart +
                ", birthdate=" + birthdate +
                '}';
    }
}
