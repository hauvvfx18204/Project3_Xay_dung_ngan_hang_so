public class SavingAccount extends Account implements ReportService, Withdraw{
    public SavingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void log(double amount) {

    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    @Override
    public boolean isAccepted(double amount) {
        return false;
    }
}
