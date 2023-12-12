import java.util.concurrent.ConcurrentHashMap;

public class Concert {
    private ConcurrentHashMap<Integer, Ticket> availableTickets;

    public Concert(int numberOfTickets) {
        availableTickets = new ConcurrentHashMap<>();
        for (int i = 0; i < numberOfTickets; i++) {
            availableTickets.put(i, new Ticket(i));
        }
    }

    public void reservedTicket(Customer customer) {
        System.out.println("Reservando ticket para " + customer + " ⏳");
        ConcurrentHashMap.KeySetView<Integer, Ticket> keySet = availableTickets.keySet();

        Integer firstAvailableTicket = keySet.stream()
                .filter(ticketId -> !availableTickets.get(ticketId).isReserved())
                .findFirst()
                .orElse(null);

        if (firstAvailableTicket != null) {
            Ticket ticket = availableTickets.get(firstAvailableTicket);
            ticket.setReserved(true);
            ticket.setCustomer(customer);
            System.out.println("Ticket reservado para " + customer + " ✅");
        } else {
            System.out.println("No hay tickets disponibles para " + customer + " ❌");
        }
    }

    public void showTickets() {
        System.out.println("________________________________");
        availableTickets.forEach((key, value) -> {
            if(!value.isReserved()) {
                System.out.println("Ticket: " + key + ", Reservado: " + value.isReserved());
            } else {
                System.out.println("Ticket: " + key + ", Reservado: " + value.isReserved() + ", " + value.getCustomer());
            }
        });
    }
}
