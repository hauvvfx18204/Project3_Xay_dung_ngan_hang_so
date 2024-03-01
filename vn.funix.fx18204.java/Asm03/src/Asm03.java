import java.util.Scanner;

public class Asm03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean flag = true;
        while(flag){
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
//                    addCustomer();
                    break;
                case 2:
//                    addAccount();
                    break;
                case 3:
//                    displayListCustomer();
                    break;
                case 4:
//                    searchCCCD();
                    break;
                case 5:
//                    searchName();
                    break;
                default:
                    flag = false;
            }

        }


        input.close();
    }

    public static void customerInformation(){

    }

    public static void startMenu(){
        System.out.println();
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| NGAN HANG SO | FX18204@V3.0.0                 |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. Thong tin khach hang                       |");
        System.out.println("| 2. Them tai khoan ATM                         |");
        System.out.println("| 3. Them tai khoan tin dung                    |");
        System.out.println("| 4. Rut tien                                   |");
        System.out.println("| 5. Lich su giao dich                          |");
        System.out.println("| 0. Thoat                                      |");
        System.out.println("+----------+-------------------------+----------+");
    }
}