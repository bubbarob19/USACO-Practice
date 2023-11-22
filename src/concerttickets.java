import utils.Kattio;

import java.util.ArrayList;
import java.util.Collections;

public class concerttickets {
    public static void main(String[] args) throws Exception {
        Kattio io = new Kattio();

        int nTickets = io.nextInt();
        int nCustomers = io.nextInt();

        ArrayList<Integer> ticketPrices = new ArrayList<>();
        ArrayList<Integer> customers = new ArrayList<>();

        for (int i = 0; i < nTickets; i++) {
            ticketPrices.add(io.nextInt());
        }
        Collections.sort(ticketPrices);
        for (int i = 0; i < nCustomers; i++) {
            customers.add(io.nextInt());
        }

        for (int customer : customers) {
            int index = ticketPrices.isEmpty() ? -1 : findTicketIndex(customer, ticketPrices, 0, ticketPrices.size() - 1);
            int price = index != -1 ? ticketPrices.remove(index) : -1;
            io.println(price);
        }

        io.close();
    }

    public static int findTicketIndex(int customer, ArrayList<Integer> ticketPrices, int start, int end) {
        if (customer < ticketPrices.get(start))
            return -1;

        if (start == end)
            return start;
        if (start + 1 == end) {
            if (ticketPrices.get(start + 1) <= customer)
                return start + 1;
            if (ticketPrices.get(start) <= customer)
                return start;
            else
                return -1;
        }

        int middle = (end + start) / 2;
        if (ticketPrices.get(middle) > customer)
            return findTicketIndex(customer, ticketPrices, 0, middle);
        if (ticketPrices.get(middle) == customer)
            return middle;
        else {
            return findTicketIndex(customer, ticketPrices, middle, end);
        }
    }
}