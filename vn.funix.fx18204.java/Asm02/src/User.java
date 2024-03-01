public class User {
    private String name;
    private String customerId;

    public User(){
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setCustomerId(String customerId){
        this.customerId = customerId;
    }

    public String getCustomerId(){
        return this.customerId;
    }

}
