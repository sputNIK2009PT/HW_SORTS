package ru.netology.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Саратов", "Казань", 4_000, 18, 19);
    Ticket ticket2 = new Ticket("Челябинск", "Сочи", 6_000, 15, 18);
    Ticket ticket3 = new Ticket("Екатеринбург", "Санкт-Петербург", 9_000, 10, 12);
    Ticket ticket4 = new Ticket("Воронеж", "Анапа", 6_000, 15, 16);
    Ticket ticket5 = new Ticket("Воронеж", "Анапа", 11_000, 11, 15);
    Ticket ticket6 = new Ticket("Воронеж", "Анапа", 8_000, 17, 19);

    @Test
    public void CompareEarlierTest() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        int expected = -1;
        int actual = ticket4.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void CompareSameTest() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        int expected = 0;
        int actual = ticket2.compareTo(ticket4);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void CompareLaterTest() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        int expected = 1;
        int actual = ticket3.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void SearchTest() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        Ticket[] expected = {ticket4, ticket6, ticket5};
        Ticket[] actual = pass.search("Воронеж", "Анапа");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void SearchOneTicketTest() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        Ticket[] expected = {ticket1};
        Ticket[] actual = pass.search("Саратов", "Казань");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchNoTicketTest() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = pass.search("Саратов", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ComparatorEarlierTest() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        TicketTimeComparator ticketComparator = new TicketTimeComparator();

        int expected = -1;
        int actual = ticketComparator.compare(ticket6, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ComparatorSameTest() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        TicketTimeComparator ticketComparator = new TicketTimeComparator();

        int expected = 0;
        int actual = ticketComparator.compare(ticket4, ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ComparatorLaterTest() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        TicketTimeComparator ticketComparator = new TicketTimeComparator();

        int expected = 1;
        int actual = ticketComparator.compare(ticket2, ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ComparatorSortTest() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        TicketTimeComparator ticketComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket6, ticket5};
        Ticket[] actual = pass.searchAndSort("Воронеж", "Анапа", ticketComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ComparatorOneTicketTest() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        TicketTimeComparator ticketComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3};
        Ticket[] actual = pass.searchAndSort("Екатеринбург", "Санкт-Петербург", ticketComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ComparatorNoTicketTest() {
        AviaSouls pass = new AviaSouls();
        pass.add(ticket1);
        pass.add(ticket2);
        pass.add(ticket3);
        pass.add(ticket4);
        pass.add(ticket5);
        pass.add(ticket6);

        TicketTimeComparator ticketComparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = pass.searchAndSort("Челябинск", "Санкт-Петербург", ticketComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
