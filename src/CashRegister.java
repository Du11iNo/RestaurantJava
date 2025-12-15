public class CashRegister {

    private double balance;

    public CashRegister() {
        this.balance = 5000000.0;
    }

    public CashRegister(int balance) {
        this.balance = balance;
    }

    public void givePaycheck(Employee emp) {
      try {
          if (balance < balance - emp.calculatePaycheck()) {
              throw new ArithmeticException();
          }

          balance -= emp.calculatePaycheck();
      }

      catch (ArithmeticException e) {
          //printstack;
      }

    }

    public void givePaychecks() {
        try {
            for (Employee emp : Restaurant.getEmployeeList()) {

                if (balance < balance - emp.calculatePaycheck()) {
                    throw new ArithmeticException();
                }

                balance -= emp.calculatePaycheck();
            }
        }

        catch (ArithmeticException e) {
            //printstack;
        }

    }

    public double calculateEarnings() {

        balance += earnings;
        return earnings;
    }
}
