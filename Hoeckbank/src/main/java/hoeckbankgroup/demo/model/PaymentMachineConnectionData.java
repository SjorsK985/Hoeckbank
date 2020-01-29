package hoeckbankgroup.demo.model;
public class PaymentMachineConnectionData {
    private String account;
    private int check;
    public PaymentMachineConnectionData(){
        super();
    }
    public PaymentMachineConnectionData(String account, int check) {
        this.account = account;
        this.check = check;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public int getCheck() {
        return check;
    }
    public void setCheck(int check) {
        this.check = check;
    }
}