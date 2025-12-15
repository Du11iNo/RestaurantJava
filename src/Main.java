import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args){

        Menu.addFoodToMenu("Lobster", 24.0);

        Menu.addFoodToMenu("Chicken", 17.0);

        Menu.addFoodToMenu("FantaCan", -5.0);

        Restaurant.addTable(1);

        Restaurant.setReservation(1, LocalDate.of(2030,1,2));

        Restaurant.addFoodAtTable(1, "Lobster", 2);
        Restaurant.addFoodAtTable(1, "Chicken", 3);
        Restaurant.addFoodAtTable(1, "Lobster", 1);
        System.out.println(Menu.getMenu());
        System.out.println(Restaurant.getTable(1).generateReceipt());

        System.out.println(Restaurant.getTable(1));

        System.out.println("");

        for (String line: FileHandler.readFile("test.txt")){
            System.out.println(line);
        }

        Restaurant.printEmployeeList();

        Waiter.Hire("12","123",LocalDate.of(2000,1,1));
        Chef.Hire("1","Qazim",LocalDate.of(2027,2,2), Chef.Qualifications.HeadChef);
        Cleaner.Hire("3","Bedrie",LocalDate.of(2002,3,3));
        Restaurant.printEmployeeList();

    }
}
