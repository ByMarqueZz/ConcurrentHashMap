import java.util.concurrent.ConcurrentHashMap;
public class Main {
    public static void main(String[] args) {
        Concert concert = new Concert(10);
        Customer[] customers = new Customer[13];
        for (int i = 0; i <= 12; i++) {
            Customer customer = new Customer("Customer " + i, concert);
            customers[i] = customer;
            customer.start();
        }

        try {
            for (Customer customer : customers) {
                customer.join();
            }
            Thread.sleep(1000);
            concert.showTickets();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}