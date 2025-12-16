
import java.time.DateTimeException;
import java.time.LocalDate;

public class Chef extends Employee{

    public enum Qualifications {
        HeadChef,
        SousChef,
        Apprentice;
    }

    private Qualifications qualification;

    public Chef(String nid, String nameSurname, LocalDate birthday, Qualifications qualification) {
        super(nid, nameSurname, birthday);
        this.qualification = qualification;
        this.paycheck = 900.0;
    }

    public Qualifications getQualification() {
        return qualification;
    }

    public static void hire(String NID, String nameSurname, LocalDate birthdate, Qualifications qualification) {
        try {
            //Don't allow birthdates after present time; Same for other roles
            if (birthdate.isAfter(LocalDate.now()))
                throw new DateTimeException("Given date is after present date");

            Restaurant.getEmployeeList().add(new Chef(NID, nameSurname, birthdate, qualification));
            Restaurant.writeEmployeeFile();
        }
        catch (DateTimeException e) {
            ExceptionHandler.printStackedError(e);
            return;
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in hire function in Chef Class", e);
            return;
        }
    }

    @Override
    public double calculatePaycheck() {
        return switch (getQualification()) {
            case Qualifications.HeadChef -> paycheck + 300;
            case Qualifications.SousChef -> paycheck + 100;
            default -> paycheck;
        };
    }

    @Override
    public String toString() {
        return "Chef{" +
                "NID='" + NID + '\'' +
                ", nameSurname='" + nameSurname + '\'' +
                ", dateOfStart=" + dateOfStart +
                ", birthdate=" + birthdate +
                ", qualification=" + qualification +
                '}';
    }
}
