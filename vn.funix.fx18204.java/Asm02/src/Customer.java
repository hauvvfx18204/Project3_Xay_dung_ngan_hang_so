import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer extends User {
    private List<Account> listAccount = null;

    public Customer() {
        listAccount = new ArrayList<Account>();
    }

    // ham them tai khoan cho khach hang
    public void addAccount(Account account){
        if(checkAccount(account)){
            listAccount.add(account);
            System.out.println("ok");
        }else{
            System.out.println("So tai khoan da ton tai!");
        }
    }

    // ham check so tai khoan da ton tai hay chua
    public boolean checkAccount(Account accountObj){
        Iterator<Account> itr = this.listAccount.iterator();
        while(itr.hasNext()){
            Account account = itr.next();
            if(account.getAccountNumber().equals(accountObj.getAccountNumber())){
                return false;
            }
        }
        return true;
    }

    public void getAccounts(){
        Iterator<Account> itr = this.listAccount.iterator();
        while(itr.hasNext()){
            Account account = itr.next();
            System.out.println(account.toString());
        }
    }

    // ham check xem trong so tai khoan cua khach hang co tai khoan nao la premium hay ko
    public boolean isPremium(){
        Iterator<Account> itr = this.listAccount.iterator();
        while(itr.hasNext()){
            Account account = itr.next();
            if(account.isPremium()){
                return true;
            }
        }
        return false;
    }

    // ham tinh tong so su cua khach hang
    public double getBalance(){
        Iterator<Account> itr = this.listAccount.iterator();
        double sum = 0;
        while(itr.hasNext()){
            Account account = itr.next();
            sum += account.getBalance();
        }
        return sum;
    }

    // ham hien thi thong tin ve khach hang
    public void displayInformation(){
        String isPremium = null;
        int count = 1;

        if(this.isPremium() == true){
            isPremium = "Premium";
        }else{
            isPremium = "Normal";
        }
        System.out.println();
        System.out.println(super.getCustomerId() + "  |  " + super.getName() + "  |  " + isPremium + "  |  " + this.getBalance());
        Iterator<Account> itr = this.listAccount.iterator();
        while(itr.hasNext()){
            Account account = itr.next();
            System.out.println(count++ + "     " +account.toString());
        }
    }
}
