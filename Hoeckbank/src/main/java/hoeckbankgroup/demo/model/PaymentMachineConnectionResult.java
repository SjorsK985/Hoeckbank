package hoeckbankgroup.demo.model;

public class PaymentMachineConnectionResult {
    private boolean succeeded;
    private int id;
    public PaymentMachineConnectionResult(boolean succeeded, int id) {
        this.succeeded = succeeded;
        this.id = id;
    }
    public boolean isSucceeded() {
        return succeeded;
    }
    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}