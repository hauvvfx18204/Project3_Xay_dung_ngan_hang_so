public class Validate {

    // ma vung cua 63 tinh thanh trong ca nuoc
    private String areaCode = "001 002 004 006 008 010 011 012 014 015 017 019 020 022 024 025 026 027 030 031 033 034 035 036 037 038 040 042 044 045 046 048 049 051 052 054 056 058 060 062 064 066 067 068 070 072 074 075 077 079 080 082 083 084 086 087 089 091 092 093 094 095 096";


    // ham ckeck so CCCD co hop le khong
    public boolean checkId(String numberId){
        return numberId.matches("\\d{12}") && this.areaCode.contains(numberId.substring(0,3));
    }

    // ham check STK co hop le khong
    public boolean checkSTK(String numberSTK){
        return numberSTK.matches("\\d{6}");
    }

    // ham check so du co dung quy dinh khong
    public boolean checkBalance(double balance){
        if(balance < 50000){
            return false;
        }
        return true;
    }

}
