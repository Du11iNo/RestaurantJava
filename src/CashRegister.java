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
          if (balance < balance - emp.calculatePaycheck())
              throw new ArithmeticException();
          balance -= emp.calculatePaycheck();
      }
      catch (ArithmeticException e) {
          ExceptionHandler.printStackedError(e);
      }
      catch (Exception e) {
          ExceptionHandler.printGeneralException("Error in givePaycheck function in CashRegister class", e);
      }
    }

    public void givePaychecks() {
        try {
            for (Employee emp : Restaurant.getEmployeeList()) {
                if (balance < balance - emp.calculatePaycheck())
                    throw new ArithmeticException();
                balance -= emp.calculatePaycheck();
            }
        }
        catch (ArithmeticException e) {
            ExceptionHandler.printStackedError(e);
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in givePaychecks function in CashRegister class", e);
        }
    }

    public double calculateEarnings() {
        balance += earnings;
        return earnings;
    }
}
