import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class AviaSoulsTest {
    Ticket ticket_1 = new Ticket("Толмачево", "Аэропорт_1", 1, 10, 12);
    Ticket ticket_2 = new Ticket("Толмачево", "Аэропорт_2", 2, 10, 14);
    Ticket ticket_3 = new Ticket("Толмачево", "Аэропорт_3", 3, 10, 16);
    Ticket ticket_4 = new Ticket("Толмачево", "Аэропорт_4", 5, 10, 18);
    Ticket ticket_5 = new Ticket("Толмачево", "Аэропорт_5", 4, 10, 20);
    Ticket ticket_6 = new Ticket("Толмачево", "Аэропорт_3", 4, 10, 22);

    @Test
    public void shouldCompareTo() {
        AviaSouls souls = new AviaSouls();
        souls.add(ticket_1);
        souls.add(ticket_2);
        souls.add(ticket_3);
        souls.add(ticket_4);
        souls.add(ticket_5);

        Ticket[] tickets = {ticket_4, ticket_5};
        Arrays.sort(tickets);

        Ticket[] expected = {ticket_5, ticket_4};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void shouldSearch() {
        AviaSouls souls = new AviaSouls();
        souls.add(ticket_1);
        souls.add(ticket_2);
        souls.add(ticket_3);
        souls.add(ticket_4);
        souls.add(ticket_5);

        Ticket[] tickets = {ticket_1, ticket_2, ticket_3, ticket_4, ticket_5};
        Arrays.sort(tickets);

        Ticket[] expected = {ticket_1, ticket_2, ticket_3, ticket_5, ticket_4};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void shouldCompareTime() {
        AviaSouls souls = new AviaSouls();
        souls.add(ticket_1);
        souls.add(ticket_2);
        souls.add(ticket_3);
        souls.add(ticket_4);
        souls.add(ticket_5);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket_1, ticket_5};
        Arrays.sort(tickets, timeComparator);

        Ticket[] expected = {ticket_1, ticket_5};


        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void shouldSearchAndSortByTimeFlight() {
        AviaSouls souls = new AviaSouls();
        souls.add(ticket_1);
        souls.add(ticket_2);
        souls.add(ticket_3);
        souls.add(ticket_4);
        souls.add(ticket_5);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket_1, ticket_2, ticket_3, ticket_4, ticket_5};
        Arrays.sort(tickets, timeComparator);

        Ticket[] expected = {ticket_1, ticket_2, ticket_3, ticket_4, ticket_5};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    void shouldTestSearchWithNoTickets() {

        AviaSouls souls = new AviaSouls();

        Ticket[] actual = souls.search("Толмачево", "Аэропорт_1");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldTestSearchWithOneTicket() {

        AviaSouls souls = new AviaSouls();

        Ticket ticket = new Ticket("Толмачево", "Аэропорт_1", 1, 10, 12);
        souls.add(ticket);
        Ticket[] actual = souls.search("Толмачево", "Аэропорт_1");
        Ticket[] expected = {ticket};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTestSearchWithSeveralTicket() {

        AviaSouls souls = new AviaSouls();

        souls.add(ticket_1);
        souls.add(ticket_2);
        souls.add(ticket_3);
        souls.add(ticket_4);
        souls.add(ticket_5);
        souls.add(ticket_6);

        Ticket[] actual = souls.search("Толмачево", "Аэропорт_3");
        Ticket[] expected = {ticket_3, ticket_6};

        Assertions.assertArrayEquals(expected, actual);
    }
}