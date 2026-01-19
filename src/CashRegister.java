public class CashRegister {

    private static double balance;

    public static double getBalance() {
        return balance;
    }

    public static void setBalance(double balance) {
        CashRegister.balance = balance;
    }

    public void givePaycheck(Employee emp) {
        try {
            if (balance < balance - emp.calculatePaycheck())
                throw new ArithmeticException();
            balance -= emp.calculatePaycheck();
        } catch (ArithmeticException e) {
            ExceptionHandler.printStackedError(e);
        } catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in givePaycheck function in CashRegister class", e);
        }
    }

    public static void givePaychecks() {
        try {
            for (Employee emp : Restaurant.getEmployeeList()) {
                if (balance < balance - emp.calculatePaycheck())
                    throw new ArithmeticException();
                balance -= emp.calculatePaycheck();
            }
        } catch (ArithmeticException e) {
            ExceptionHandler.printStackedError(e);
        } catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in givePaychecks function in CashRegister class", e);
        }
    }

    public static void addEarnings(double revenue) {
        balance = balance + revenue;
    }
    public static boolean canPaySalaries() {
        double total=0;
        for (Employee emp : Restaurant.getEmployeeList())
            total = total + emp.getPaycheck();
        return balance >= total;
    }

}
