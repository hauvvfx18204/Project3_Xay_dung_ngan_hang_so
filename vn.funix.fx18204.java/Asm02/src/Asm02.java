import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Asm02 {

    public static final Bank bank = new Bank();


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        boolean flag = true;

        while(flag) {

            startMenu();

            int number = -1;

            while (number != 0 && number != 1 && number != 2 && number != 3 && number != 4 && number != 5) {
                System.out.print("Chuc nang: ");
                try {
                    number = input.nextInt();
                    input.nextLine();
                } catch (Exception e) {
                    input.nextLine();
                    System.out.println("Error: " + e.getMessage());
                }
            }

            // su ly logic
            switch (number) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    addAccount();
                    break;
                case 3:
                    displayListCustomer();
                    break;
                case 4:
                    searchCCCD();
                    break;
                case 5:
                    searchName();
                    break;
                default:
                    flag = false;
            }
        }

        input.close();
    }

    // ham tim kiem khach hang thong qua ten
    public static void searchName(){
        Scanner input = new Scanner(System.in);

        Validate validate = new Validate();

        System.out.println("Nhap ten khach hang can tim:");
        String name = input.nextLine();

        bank.getCustomerByName(name);

    }

    // ham tim kiem khach hang thong qua CCCD
    public static void searchCCCD(){
        Scanner input = new Scanner(System.in);
        Validate validate = new Validate();

        System.out.println("Nhap so CCCD can tim:");
        String numberId = input.nextLine();

        while(!validate.checkId(numberId)){
            System.out.println("So CCCD ko hop le, nhap lai CCCD:");
            numberId= input.nextLine();
        }

        if(bank.isCustomerExisted(numberId)) {
            System.out.println("ko tim thay so CCCD khach hang:");
        }else{
            bank.getCustomerByID(numberId);
        }

    }

    // ham hien thi tat ca cac khach hang
    public static void displayListCustomer(){
        bank.getCustomers();
    }

    // ham them tai khoan
    public static void addAccount(){
        Scanner input = new Scanner(System.in);
        Validate validate = new Validate();

        System.out.println("Nhap CCCD khach hang:");
        String numberId = input.nextLine();

        while(!validate.checkId(numberId)){
            System.out.println("So CCCD ko hop le, nhap lai CCCD:");
            numberId= input.nextLine();
        }

        while(bank.isCustomerExisted(numberId)){
            System.out.println("ko tim thay CCCD khach hang:");
            System.out.println("Nhap CCCD khach hang:");
            numberId= input.nextLine();
        }

        System.out.println("Nhap ma STK gom 6 chu so:");
        String numberSTK = input.nextLine();
        while(!validate.checkSTK(numberSTK)){
            System.out.println("Nhap ma STK gom 6 chu so:");
            numberSTK = input.nextLine();
        }

        double balance = 0;
        while(!validate.checkBalance(balance)){
            System.out.println("Nhap so du:");
            try{
                balance = input.nextDouble();
                input.nextLine();
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
                input.nextLine();
            }
        }

        Account account = new Account(numberSTK, balance);
        bank.addAccount(numberId, account);

//        input.close();
    }

    // ham them khach hang
    public static void addCustomer(){
        Scanner input = new Scanner(System.in);

        System.out.println("Nhap ten khach hang:");
        String name = input.nextLine();
        System.out.println("Nhap so CCCD:");
        String numberId = input.nextLine();

        Validate validate = new Validate();

        while(!validate.checkId(numberId)){
            System.out.println("Nhap so CCCD:");
            numberId= input.nextLine();
        }

        Customer customer = new Customer();
        customer.setName(name);
        customer.setCustomerId(numberId);

        bank.addCustomer(customer);

//        input.close();
    }

    // menu
    public static void startMenu(){
        System.out.println();
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| NGAN HANG SO | FX18204@V2.0.0                 |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. Them khach hang                            |");
        System.out.println("| 2. Them tai khoan cho khach hang              |");
        System.out.println("| 3. Hien thi danh sach khach hang              |");
        System.out.println("| 4. Tim theo CCCD                              |");
        System.out.println("| 5. Tim theo ten khach hang                    |");
        System.out.println("| 0. Thoat                                      |");
        System.out.println("+----------+-------------------------+----------+");
    }

}
