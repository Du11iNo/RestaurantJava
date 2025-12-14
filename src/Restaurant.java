
import java.util.ArrayList;
import java.time.*;
import java.util.Arrays;

//Contains all main functions
public class Restaurant {

    private ArrayList<Employee> employeeList = new ArrayList<>(); //Contains all employees
    private ArrayList<Table> tableList = new ArrayList<>(); //Contains all tables

    public boolean fireEmployee(String nid){

        //Find employee in list & remove it
        for (Employee employee: employeeList){
            if (employee.getNID().equals(nid)) {
                employeeList.remove(employee);
                return true;
            }
        }
        return false;
    }

    public boolean addWaiter(String NID, String NameSurname, LocalDate Birthdate){

        //Dont allow birthdates after present time; Same for other roles
        if (Birthdate.isAfter(LocalDate.now()))
            return false;

        employeeList.add(new Waiter(NID, NameSurname, Birthdate));
        return true;
    }

    public boolean addChef(String NID, String NameSurname, LocalDate Birthdate){
        if (Birthdate.isAfter(LocalDate.now()))
            return false;

        employeeList.add(new Chef(NID, NameSurname, Birthdate));
        return true;
    }

    public boolean addTable(int ID){

        try {
            //If table with ID exists, do not add to list
            for (Table table : tableList)
                if (table.getID() == ID)
                    return false;

            tableList.add(new Table(ID));
            return true;
        }

        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + System.lineSeparator() + Arrays.toString(e.getStackTrace()));
            return false;
        }
        catch (Exception e) {
            System.out.println("Error in Add to TableList: " + e.getMessage());
            return false;
        }
    }

    public void printEmployeeList(){
        for (Employee emp: employeeList)
            System.out.println(emp);
    }

    public void printTables(){
        for (Table tab: tableList)
            System.out.println(tab);
    }

    public Table getTable(int ID){

        try {
            //Check list for table with specified ID
            for (Table table : tableList)
                if (table.getID() == ID)
                    return table;
            return null;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        catch (Exception e) {
            System.out.println("Error in getTable function in Table" + System.lineSeparator() + Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    public void removeAllReservations(){
        for (Table tab: tableList)
            tab.setReserved(false);
    }

    public boolean setReservation(int ID, LocalDate date){

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
            System.out.println(e.getMessage());
            return false;
        }
        catch (Exception e) {
            System.out.println("Error in setReservation function in Restaurant class"
                    + System.lineSeparator()
                    + Arrays.toString(e.getStackTrace()));
            return false;
        }
    }

    public boolean addFoodAtTable(int ID, String Food, int Quantity){

        try{
        //Add food in Table's Order list
        for (Table table: tableList)
            if (table.getID() == ID) {
                table.addOrder(Food, Quantity);
                return true;
            }
        return false;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        catch (Exception e) {
            System.out.println("Error in addFoodToTable function in Restaurant class"
                    + System.lineSeparator()
                    + Arrays.toString(e.getStackTrace()));
            return false;
        }
    }

    //Set isTaken for all tables to false unless it has reservation for today
    public boolean setupTables(){
        for (Table tab: tableList){
            if (tab.isReserved() && LocalDate.now().equals(tab.getReservationDate())){
                tab.setTaken(true);
            } else{
                tab.setTaken(false);
            }
        }
        return true;
    }

}
