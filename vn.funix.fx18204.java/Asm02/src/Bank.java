import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Bank {
    private final String id;
    private final List<Customer> listCustomer;

    public Bank(){
        this.listCustomer = new ArrayList<Customer>();
        this.id = String.valueOf(UUID.randomUUID());
    }

    // ham them khach hang
    public void addCustomer(Customer customer){
        if(isCustomerExisted(customer.getCustomerId())){
            listCustomer.add(customer);
            System.out.println("ok");
        }else{
            System.out.println("Khach hang da ton tai!");
        }
    }

    // ham them tai khoan
    public void addAccount(String numberId, Account account){
        Iterator<Customer> itr = this.listCustomer.iterator();
        while(itr.hasNext()){
            Customer customer = itr.next();
            if(customer.getCustomerId().equals(numberId)){  // tim so CCCD trong listCustomer de them tai khoan
                customer.addAccount(account);
            }
        }
    }

    // ham check khach hang da co trong bank hay chua
    public boolean isCustomerExisted(String numberId){
        Iterator<Customer> itr = this.listCustomer.iterator();
        while(itr.hasNext()){
            Customer customer = itr.next();
            if(customer.getCustomerId().equals(numberId)){
                return false;
            }
        }
        return true;
    }

    // ham hien thi danh sach cac khach hang
    public void getCustomers(){
        Iterator<Customer> itr = this.listCustomer.iterator();
        while(itr.hasNext()){
            Customer customer = itr.next();
            customer.displayInformation();
        }
    }

    // ham hien thi khach hang thong qua so CCCD
    public void getCustomerByID(String numberId){
        Iterator<Customer> itr = this.listCustomer.iterator();
        while(itr.hasNext()){
            Customer customer = itr.next();
            if(customer.getCustomerId().equals(numberId)){
                customer.displayInformation();
            }

        }
    }

    // ham hien thi khach hang thong qua ten
    public void getCustomerByName(String name){
        boolean flag = false;
        Iterator<Customer> itr = this.listCustomer.iterator();
        while(itr.hasNext()){
            Customer customer = itr.next();
            if(customer.getName().toLowerCase().contains(name.toLowerCase())){
                customer.displayInformation();
                flag = true;
            }

        }
        if(flag == false){
            System.out.println("Khong co ten khach hang can tim");
        }
    }

}
