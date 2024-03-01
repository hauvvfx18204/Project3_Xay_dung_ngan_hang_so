import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Asm01 {

    // Tao mot collection Map listData de luu du lieu cua cac tinh
    public static Map<String, String> listData;

    // Tao mot bien static numberId
    public static String numberId = "";

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        final String VERIFICATION_CODE;
        String number;

        data();
        startProgram();

        while(true) {
            System.out.print("Chuc nang: ");

            number = input.nextLine();
            String temp = number.substring(0, 1);

            if (temp.equals("0") || temp.equals("1")) {
                break;
            }
        }

        if(number.equals("1")) {
            System.out.println("Chon muc do cho ma xac thuc: ");
            System.out.println("0. Ma don gian");
            System.out.println("1. Ma phuc tap");
            String levelCode = input.nextLine();

            while(!levelCode.equals("0") && !levelCode.equals("1")){
                System.out.print("Chon muc do cho ma xac thuc: ");
                levelCode = input.nextLine();
            }

            if(levelCode.equals("0")) {
                VERIFICATION_CODE = String.valueOf((int) (Math.random() * (999 - 100 + 1) + 100));
            }else  {
                VERIFICATION_CODE = randomString(6);
            }

            System.out.println("Nhap ma xac thuc: " + VERIFICATION_CODE);
            String inputNumber = input.nextLine();

            while(!inputNumber.equals(VERIFICATION_CODE)){
                System.out.println("Ma xac thuc khong dung. Vui long thu lai: ");
                inputNumber = input.nextLine();
            }

            CCCD();
        }

        input.close();
    }

    // ham kiem tra tinh hop len cua numberId nhap vao
    public static void CCCD(){
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        do {
            if(flag == true) {
                System.out.print("Vui long nhap so CCCD: ");
            }

            numberId = input.nextLine();

            if(numberId.equals("No")){
                break;
            }else if(numberId.matches("\\d{12}") == true && check(numberId.substring(0,3)) == true){
                flag = true;
                break;
            }else{
                System.out.println("So CCCD khong hop le.");
                System.out.println("Vui long nhap lai so CCCD hoac nhap 'No' de thoat: ");
                flag = false;
            };

        }while(true);

        if(flag == true){
            displayFunction();
        }

        input.close();
    }

    // ham kiem tra xem ma tinh cua numberId nhap vao co trung voi ma tinh trong listData ko
    public static boolean check(String str){
        Iterator<String> itr = listData.keySet().iterator();
        while (itr.hasNext()){
            String key = itr.next();
            if(key.equals(str)){
                return true;
            }
        }
        return false;
    }

    // ham luu tru du lieu cua cac tinh
    public static void data(){
        listData = new HashMap<String, String>();
        listData.put("001", "Hà Nôi");
        listData.put("002", "Hà Giang");
        listData.put("004", "Cao Bằng");
        listData.put("006", "Bắc Kạn");
        listData.put("008", "Tuyên Quang");
        listData.put("010", "Lào Cai");
        listData.put("011", "Điện Biên");
        listData.put("012", "Lai Châu");
        listData.put("014", "Sơn La");
        listData.put("015", "Yên Bái");
        listData.put("017", "Hòa Bình");
        listData.put("019", "Thái Nguyên");
        listData.put("020", "Lạng Sơn");
        listData.put("022", "Quảng Ninh");
        listData.put("024", "Bắc Giang");
        listData.put("025", "Phú Thọ");
        listData.put("026", "Vĩnh Phúc");
        listData.put("027", "Bắc Ninh");
        listData.put("030", "Hải Dương");
        listData.put("033", "Hưng Yên");
        listData.put("034", "Thái Bình");
        listData.put("035", "Hà Nam");
        listData.put("036", "Nam Định");
        listData.put("037", "Ninh Bình");
        listData.put("038", "Thanh Hóa");
        listData.put("040", "Nghệ An");
        listData.put("042", "Hà Tĩnh");
        listData.put("044", "Quảng Bình");
        listData.put("045", "Quảng Trị");
        listData.put("046", "Thừa Thiên Huế");
        listData.put("048", "Đà Nẵng");
        listData.put("049", "Quảng Nam");
        listData.put("051", "Quảng Ngãi");
        listData.put("052", "Bình Định");
        listData.put("054", "Phú Yên");
        listData.put("056", "Khánh Hòa");
        listData.put("058", "Ninh Thuận");
        listData.put("060", "Bình Thuận");
        listData.put("062", "Kon Tum");
        listData.put("064", "Gia Lai");
        listData.put("066", "Đắk Lắk");
        listData.put("067", "Đắk Nông");
        listData.put("068", "Lâm Đồng");
        listData.put("070", "Bình Phước");
        listData.put("072", "Tây Ninh");
        listData.put("074", "Bình Dương");
        listData.put("075", "Đồng Nai");
        listData.put("077", "Bà Rịa - Vũng Tàu");
        listData.put("079", "Hồ Chí Minh");
        listData.put("080", "Long An");
        listData.put("082", "Tiền Giang");
        listData.put("083", "Bến Tre");
        listData.put("084", "Trà Vinh");
        listData.put("086", "Vĩnh Long");
        listData.put("087", "Đồng Tháp");
        listData.put("089", "An Giang");
        listData.put("091", "Kiên Giang");
        listData.put("092", "Cần Thơ");
        listData.put("093", "Hậu Giang");
        listData.put("094", "Sóc Trăng");
        listData.put("095", "Bạc Liêu");
        listData.put("096", "Cà Mau");

    }

    // ham hien thi cac chuc nang va in ra ket qua do nguoi dung chon
    public static void displayFunction(){
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\t| 1. Kiem tra noi sing");
            System.out.println("\t| 2. Kiem tra tuoi");
            System.out.println("\t| 3. Kiem tra so ngau nhien");
            System.out.println("\t| 0. Thoat");
            System.out.print("Chuc nang: ");

            String numberFunction = input.nextLine();

            if(numberFunction.equals("1")){
                System.out.println("Noi sinh: " + listData.get(numberId.substring(0,3)));
            }

            if(numberFunction.equals("2")){
                System.out.print("Gioi tinh: ");
                displayAgeSex(numberId.substring(3,6));
            }

            if(numberFunction.equals("3")){
                System.out.println("So ngau nhien: " + numberId.substring(6));
            }

            if(numberFunction.equals("0")){
                break;
            }

        }

        input.close();
    }

    // ham tra ve gioi tinh va nam sinh
    public static void displayAgeSex(String str){
        String numberSex = str.substring(0,1);
        String numberLastYear = str.substring(1);

        String numberFirstYear = "", sex = "";


        if(Integer.valueOf(numberSex)%2==0){
            sex = "Nam";
        }else{
            sex = "Nu";
        }

        switch (numberSex){
            case "0":
            case "1":
                numberFirstYear = "19";
                break;
            case "2":
            case "3":
                numberFirstYear = "20";
                break;
            case "4":
            case "5":
                numberFirstYear = "21";
                break;
            case "6":
            case "7":
                numberFirstYear = "22";
                break;
            case "8":
            case "9":
                numberFirstYear = "23";
                break;
        }

        System.out.println(sex + " | " + numberFirstYear + numberLastYear );
    }

    // ham hien thi menu
    public static void startProgram(){
        System.out.println();
        System.out.println("+---------+------------------------+---------+");
        System.out.println("| NGAN HANG SO | FX18204@V1.0.0              |");
        System.out.println("+---------+------------------------+---------+");
        System.out.println("| 1. Nhap CCCD                               |");
        System.out.println("| 0. Thoat                                   |");
        System.out.println("+---------+------------------------+---------+");
    }

    // ham tao chuoi ngau nhien
    public static String randomString(int n) {
        String tempStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

        StringBuilder randomStr = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)(tempStr.length() * Math.random());
            randomStr.append(tempStr.charAt(index));
        }

        return randomStr.toString();
    }
}

