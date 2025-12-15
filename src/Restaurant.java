
import java.nio.file.Paths;
import java.time.*;
import java.util.Arrays;
import java.util.*;

//Contains all main functions
public class Restaurant {

    private static ArrayList<Employee> employeeList = new ArrayList<>(); //Contains all employees
    private static ArrayList<Table> tableList = new ArrayList<>(); //Contains all tables

    public static ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public static boolean fireEmployee(String nid){

        //Find employee in list & remove it
        for (Employee employee: employeeList){
            if (employee.getNID().equals(nid)) {
                employeeList.remove(employee);
                writeEmployeeFile();
                return true;
            }
        }
        return false;
    }

    public static boolean addTable(int ID){

        try {
            //If table with ID exists, do not add to list
            for (Table table : tableList)
                if (table.getID() == ID)
                    return false;

            tableList.add(new Table(ID));
            return true;
        }

        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in Add to TableList: ", e);
            return false;
        }
    }

    public static void writeEmployeeFile() {
        try {

            String format = "%s/%s/%s/%s";
            List lines = new ArrayList<String>();
            lines.add("NID/NameSurname/DateOfStart/Role");

            for (Employee emp: getEmployeeList()) {
                String nid = emp.getNID();
                String ns = emp.getNameSurname();
                LocalDate start = emp.getDateOfStart();

                lines.add(String.format(format,
                                nid,
                                ns,
                                start.toString().replace("-", "."),
                                emp.getClass().toString().substring(6)));
            }

            FileHandler.writeToFile("EmployeeList.txt", format, lines);
        }
        catch (NullPointerException e) {
            ExceptionHandler.printStackedError(e);
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in writeEmployeeFile function in Restaurant class", e);
        }
    }

    public static void printEmployeeList(){
        for (Employee emp: employeeList)
            System.out.println(emp);
    }

    public static void printTables(){
        for (Table tab: tableList)
            System.out.println(tab);
    }

    public static Table getTable(int ID){

        try {
            //Check list for table with specified ID
            for (Table table : tableList)
                if (table.getID() == ID)
                    return table;
            return null;
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in getTable function in Table", e);
            return null;
        }
    }

    public static void removeAllReservations(){
        for (Table tab: tableList)
            tab.setReserved(false);
    }

    public static boolean setReservation(int ID, LocalDate date){

        try {
        //Find table with specified ID; Reserve for specified date
        for (Table tab: tableList)
            if (tab.getID() == ID){
                tab.setReserved(true);
                tab.reserveTable(date);
                return true;
            }
        return false;
        }
        catch (DateTimeException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in setReservation function in Restaurant class", e);
            return false;
        }
    }

    public static boolean addFoodAtTable(int ID, String Food, int Quantity){

        try{
        //Add food in Table's Order list
        for (Table table: tableList)
            if (table.getID() == ID) {
                table.addOrder(Food.toLowerCase(), Quantity);
                return true;
            }
        return false;
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in addFoodToTable function in Restaurant class", e);
            return false;
        }
    }

    //Set isTaken for all tables to false unless it has reservation for today
    public static boolean setupTables(){
        for (Table tab: tableList) {
            tab.setTaken(tab.isReserved() && LocalDate.now().equals(tab.getReservationDate()));
        }
        return true;
    }
}