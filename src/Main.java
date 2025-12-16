import java.time.LocalDate;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args){

        Menu.readMenuFromFile();

        System.out.println("=".repeat(22) + "\nTesting Menu Functions\n" + "=".repeat(22) + "\n");
        System.out.println("**Current Menu: ");
        Menu.printMenu();
        System.out.println("**Adding food to Menu: ");
        Menu.addFoodToMenu("FantaCan", 5.0);
        System.out.println("**Updated Menu: ");
        Menu.printMenu();
        System.out.println("**Adding a wrong argument (price < 0) to Menu\n");
        Menu.addFoodToMenu("CocaCola", -5.0);


        Restaurant.readEmployeeFile();

        System.out.println("=".repeat(22) + "\nTesting Employee Functions\n" + "=".repeat(22) + "\n");
        System.out.println("**Current Employees: ");
        Restaurant.printEmployeeList();
        System.out.println("**Hiring a new Employee: ");
        Chef.hire("CC12","Anja", LocalDate.parse("2005-11-11"), Chef.Qualifications.SousChef);
        System.out.println("**Updated Employees: ");
        Restaurant.printEmployeeList();
        System.out.println("**Calculate paycheck of an Employee: ");
        Employee scnd = Restaurant.getEmployeeList().get(2);
        System.out.println(scnd.getNameSurname() + ": " + scnd.calculatePaycheck() + "$");
        System.out.println("**Firing an Employee, Updated Employees: ");
        Restaurant.fireEmployee("BB12");
        Restaurant.printEmployeeList();

        System.out.println("=".repeat(22) + "\nTesting Table Functions\n" + "=".repeat(22) + "\n");
        System.out.println("**Adding a table in the Restaurant: ");
        Restaurant.addTable(1);
        Restaurant.printTables();
        System.out.println("**Setting reservation to table 1: ");
        Restaurant.setReservation(1, LocalDate.of(2030,1,2));
        Restaurant.printTables();
        System.out.println("**Adding food to table (Customer orders): ");
        Restaurant.addFoodAtTable(1, "Lobster", 2);
        Restaurant.addFoodAtTable(1, "Chicken", 3);
        Restaurant.addFoodAtTable(1, "Lobster", 1);
        System.out.println("**Added 2 Lobsters, 3 Chickens and 1 more Lobster later");
        System.out.println("**Generating receipt for table 1: \n");
        System.out.println(Restaurant.getTable(1).generateReceipt());
        System.out.println("\n**Checking for reservation or occupancy after generating receipt: ");
        System.out.println(Restaurant.getTable(1));
        System.out.println("\n");

    }
}
