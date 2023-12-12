import java.util.concurrent.atomic.AtomicBoolean;

public class Ticket {
    private int id;
    private AtomicBoolean reserved;
    private Customer customer;

    public Ticket(int id) {
        this.id = id;
        this.reserved = new AtomicBoolean(false);
        this.customer = null;
    }

    public int getId() {
        return id;
    }

    public boolean isReserved() {
        return reserved.get();
    }

    public void setReserved(boolean reserved) {
        this.reserved.set(reserved);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
