public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance){
        this.setAccountNumber(accountNumber);
        this.setBalance(balance);
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    // ham check xem tai khoan nay co phai premiun hay ko
    public boolean isPremium(){
        if(this.getBalance() >= 10000000){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getAccountNumber() + "  |\t\t\t\t\t\t\t   " + this.getBalance();
    }
}
