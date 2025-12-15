
import java.time.DateTimeException;
import java.time.LocalDate;

public class Cleaner extends Employee{

    public Cleaner(String nid, String nameSurname, LocalDate birthday) {
        super(nid, nameSurname, birthday);
        paycheck = 300.0;
    }

    public static boolean Hire(String NID, String nameSurname, LocalDate birthdate) {
        try {
            //Don't allow birthdates after present time; Same for other roles
            if (birthdate.isAfter(LocalDate.now()))
                throw new DateTimeException("Given date is after present date");

            Restaurant.getEmployeeList().add(new Cleaner(NID, nameSurname, birthdate));
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
        return "Cleaner{" +
                "NID='" + NID + '\'' +
                ", nameSurname='" + nameSurname + '\'' +
                ", dateOfStart=" + dateOfStart +
                ", birthdate=" + birthdate +
                '}';
    }
}
