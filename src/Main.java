import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args){

        //Menu.addFoodToMenu("Lobster", 24.0);
        //Menu.addFoodToMenu("Chicken", 17.0);
        //Menu.addFoodToMenu("FantaCan", -5.0);

        System.out.println("Menu before read: ");
        Menu.printMenu();
        Menu.readMenuFromFile();
        System.out.println("Menu after read: ");
        Menu.printMenu();


        Restaurant.addTable(1);

        Restaurant.setReservation(1, LocalDate.of(2030,1,2));

        Restaurant.addFoodAtTable(1, "Lobster", 2);
        Restaurant.addFoodAtTable(1, "Chicken", 3);
        Restaurant.addFoodAtTable(1, "Lobster", 1);

        System.out.println(Restaurant.getTable(1).generateReceipt());

        System.out.println(Restaurant.getTable(1));

        System.out.println("");

        for (String line: FileHandler.readFile("test.txt")){
            System.out.println(line);
        }

        Restaurant.printEmployeeList();

        Restaurant.readEmployeeFile();
        Restaurant.printEmployeeList();

    }
}
