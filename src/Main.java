import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args){

        Menu SummerMenu = new Menu();

        SummerMenu.addFoodToMenu("Lobster", 24.0);

        SummerMenu.addFoodToMenu("Chicken", 17.0);

        SummerMenu.addFoodToMenu("FantaCan", 5.0);

        Restaurant SummerDine = new Restaurant();

        SummerDine.addTable(1);

        SummerDine.setReservation(1, LocalDate.of(2030,1,2));

        System.out.println(SummerDine.getTable(1));

        SummerDine.addFoodAtTable(1, "Lobster", 2, SummerMenu.getMenu());
        SummerDine.addFoodAtTable(1, "Chicken", 3, SummerMenu.getMenu());

        System.out.println(SummerDine.getTable(1));


        System.out.println(SummerDine.getTable(1).generateReceipt(SummerMenu.getMenu()));

        System.out.println(SummerDine.getTable(1));

    }

}
