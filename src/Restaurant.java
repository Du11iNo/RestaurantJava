
import java.util.ArrayList;
import java.time.*;

//Contains all main functions
public class Restaurant {

    private ArrayList<Employee> EmployeeList = new ArrayList<>(); //Contains all employees
    private ArrayList<Table> TableList = new ArrayList<>(); //Contains all tables

    public boolean fireEmployee(String nid){

        //Find employee in list & remove it
        for (Employee employee: EmployeeList){
            if (employee.getNID() == nid){
                EmployeeList.remove(employee);
                return true;
            }
        }
        return false;
    }

    public boolean addWaiter(String NID, String NameSurname, LocalDate Birthdate){

        //Dont allow birthdates after present time; Same for other roles
        if (Birthdate.isAfter(LocalDate.now()))
            return false;

        EmployeeList.add(new Waiter(NID, NameSurname, Birthdate));
        return true;
    }

    public boolean addChef(String NID, String NameSurname, LocalDate Birthdate){
        if (Birthdate.isAfter(LocalDate.now()))
            return false;

        EmployeeList.add(new Chef(NID, NameSurname, Birthdate));
        return true;
    }

    public boolean addTable(int ID){

        //If table with ID exists, do not add to list
        for (Table table: TableList)
            if (table.getID() == ID)
                return false;

        TableList.add(new Table(ID));

        return true;
    }

    public void printEmployeeList(){
        for (Employee emp: EmployeeList)
            System.out.println(emp);
    }

    public void printTables(){
        for (Table tab: TableList)
            System.out.println(tab);
    }

    public Table getTable(int ID){

        //Check list for table with specified ID
        for (Table table: TableList)
            if (table.getID() == ID)
                return table;
        return null;
    }

    public void removeAllReservations(){
        for (Table tab: TableList)
            tab.setReserved(false);
    }

    public boolean setReservation(int ID, LocalDate date){

        //Find table with specified ID; Reserve for specified date
        for (Table tab: TableList)
            if (tab.getID() == ID){
                tab.setReserved(true);
                tab.reserveTable(date);
                return true;
            }
        return false;
    }

    public boolean addFoodAtTable(int ID, String Food, int Quantity, ArrayList<Order> SpecificMenu){

        //Add food in Table's Order list
        for (Table table: TableList)
            if (table.getID() == ID) {
                table.addOrder(Food, Quantity, SpecificMenu);
                return true;
            }
        return false;
    }

    //Set isTaken for all tables to false unless it has reservation for today
    public boolean setupTables(){
        for (Table tab: TableList){
            if (tab.isReserved() && LocalDate.now().equals(tab.getReservationDate())){
                tab.setTaken(true);
            } else{
                tab.setTaken(false);
            }
        }
        return true;
    }

}
