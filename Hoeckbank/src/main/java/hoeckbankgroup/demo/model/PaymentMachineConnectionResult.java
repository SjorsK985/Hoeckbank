package hoeckbankgroup.demo.model;

public class PaymentMachineConnectionResult {
    private boolean succeeded;
    private long id;
    public PaymentMachineConnectionResult(boolean succeeded, long id) {
        this.succeeded = succeeded;
        this.id = id;
    }
    public boolean isSucceeded() {
        return succeeded;
    }
    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}