
import java.util.ArrayList;
import java.time.*;
public class Restaurant {

    private ArrayList<Employee> EmployeeList = new ArrayList<>();
    private ArrayList<Table> TableList = new ArrayList<>();

    public boolean fireEmployee(String nid){
        for (Employee employee: EmployeeList){
            if (employee.getNID() == nid){
                EmployeeList.remove(employee);
                return true;
            }
        }
        return false;
    }

    public boolean addWaiter(String NID, String NameSurname, LocalDate Birthdate){
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
        for (Table tab: TableList)
            if (tab.getID() == ID){
                tab.setReserved(true);
                tab.reserveTable(date);
                return true;
            }
        return false;
    }

    public boolean addFoodAtTable(int ID, String Food, int Quantity, ArrayList<Order> SpecificMenu){
        for (Table table: TableList)
            if (table.getID() == ID) {
                table.addOrder(Food, Quantity, SpecificMenu);
                return true;
            }
        return false;
    }

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
