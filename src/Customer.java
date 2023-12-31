public class Customer extends Thread{
    private String name;
    private Concert concert;

    public Customer(String name, Concert concert) {
        this.name = name;
        this.concert = concert;
    }

    @Override
    public void run() {
        // El cliente intenta reservar un ticket
        concert.reservedTicket(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
