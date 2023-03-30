import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Ticket ticket_1 = new Ticket(
                "Толмачево",
                "Аэропорт_1",
                1,
                10,
                12
        );
        Ticket ticket_2 = new Ticket(
                "Толмачево",
                "Аэропорт_2",
                2,
                10,
                14
        );

        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] tickets = {ticket_1, ticket_2};
        Arrays.sort(tickets, timeComparator);

    }
}
