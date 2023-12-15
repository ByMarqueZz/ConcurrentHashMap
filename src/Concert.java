import java.util.concurrent.ConcurrentHashMap;

public class Concert {
    private ConcurrentHashMap<Integer, Ticket> availableTickets;

    /**
     * Constructor de la clase Concert
     * @param numberOfTickets Número de tickets a crear
     */
    public Concert(int numberOfTickets) {
        availableTickets = new ConcurrentHashMap<>();
        for (int i = 0; i < numberOfTickets; i++) {
            // creamos los tickets y los añadimos al ConcurrentHashMap
            availableTickets.put(i + 1, new Ticket(i + 1));
        }
    }

    /**
     * Método que reserva un ticket para un cliente
     * @param customer Cliente que quiere reservar un ticket
     */
    public void reservedTicket(Customer customer) {
        // Empieza la reserva del ticket
        System.out.println("Reservando ticket para " + customer + " ⏳");
        // Obtenemos la vista de las keys del ConcurrentHashMap para poder iterarlo correctamente
        ConcurrentHashMap.KeySetView<Integer, Ticket> keySet = availableTickets.keySet();

        // Filtramos los tickets que no estén reservados y cogemos el primero disponible
        Integer firstAvailableTicket = keySet.stream()
                .filter(ticketId -> !availableTickets.get(ticketId).isReserved())
                .findFirst()
                .orElse(null);

        if (firstAvailableTicket != null) {
            // Obtenemos el ticket y lo reservamos para el cliente
            Ticket ticket = availableTickets.get(firstAvailableTicket);
            ticket.setReserved(true);
            ticket.setCustomer(customer);
            System.out.println("Ticket reservado para " + customer + " ✅");
        } else {
            System.out.println("No hay tickets disponibles para " + customer + " ❌");
        }
    }

    /**
     * Método que muestra los tickets disponibles
     */
    public void showTickets() {
        System.out.println("________________________________");
        availableTickets.forEach((key, value) -> {
            if(!value.isReserved()) {
                System.out.println("Ticket: " + key + ", Reservado: " + value.isReserved());
            } else {
                System.out.println("Ticket: " + key + ", Reservado: " + value.isReserved() + ", " + value.getCustomer());
            }
        });
        System.out.println("________________________________");
    }
}
