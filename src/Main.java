import java.util.concurrent.ConcurrentHashMap;
public class Main {
    public static void main(String[] args) {
        // Creamos un concierto con 10 tickets y los mostramos
        Concert concert = new Concert(10);
        concert.showTickets();
        // Creamos 13 clientes y hacemos que reserven tickets a la vez
        Customer[] customers = new Customer[13];
        for (int i = 0; i < 13; i++) {
            Customer customer = new Customer("Customer " + i, concert);
            customers[i] = customer;
            customer.start();
        }

        try {
            // Esperamos a que todos los clientes terminen de reservar tickets y mostramos los tickets
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