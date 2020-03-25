package cn.xpbootcamp.gilded_rose;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private Integer size;
    private Map<Ticket, Bag> ticketBagMap = new HashMap<>();

    public void setTicketBagMap(Ticket ticket, Bag bag) {
        ticketBagMap.put(ticket, bag);
    }

    public Locker(int i) {
        this.size = i;
    }

    public Ticket lock(Bag bag) throws Exception {
        if (size == 19) {
            throw new Exception("柜子已满");
        }
        size += 1;
        Ticket ticket = new Ticket(generateTicket());
        ticketBagMap.put(ticket, bag);
        return ticket;
    }


    private String generateTicket() {
        return String.valueOf(System.currentTimeMillis());
    }

    public Bag unlock(Ticket ticket) throws Exception {
        size -= 1;
        if (ticket == null) {

        }
        return ticketBagMap.get(ticket);
    }
}
