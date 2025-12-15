
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
        this.paycheck = 1200.0;
    }

    public static boolean Hire(String NID, String nameSurname, LocalDate birthdate, Qualifications qualification) {
        try {
            //Don't allow birthdates after present time; Same for other roles
            if (birthdate.isAfter(LocalDate.now()))
                throw new DateTimeException("Given date is after present date");

            Restaurant.getEmployeeList().add(new Chef(NID, nameSurname, birthdate, qualification));
            return true;
        }
        catch (DateTimeException e) {
            StackTraceElement[] el = e.getStackTrace();

            System.err.println("Error in:");
            for(StackTraceElement traceEl: el){
                System.err.printf("%s%s.%s in line %d\n",
                        " ".repeat(5),
                        traceEl.getClassName(),
                        traceEl.getMethodName(),
                        traceEl.getLineNumber());
            }
            System.err.println(" ".repeat(5) + "-Context: " + e.getMessage());

            return false;
        }
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
