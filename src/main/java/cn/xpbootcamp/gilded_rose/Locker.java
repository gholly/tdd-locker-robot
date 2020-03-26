package cn.xpbootcamp.gilded_rose;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private Integer size;
    private Map<Ticket, Bag> ticketBagMap = new HashMap<>();

    public void setTicketBagMap(Ticket ticket, Bag bag) {
        ticketBagMap.put(ticket, bag);
    }

    public Integer getSize() {
        return size;
    }

    public Locker(int size) {
        this.size = size;
    }

    public Ticket lock(Bag bag) throws Exception {
        if (size == 0) {
            throw new Exception("柜子已满");
        }
        size += 1;
        Ticket ticket = new Ticket(generateTicket());
        ticketBagMap.put(ticket, bag);
        return ticket;
    }

    public Bag unlock(Ticket ticket) throws Exception {
        if (ticket == null) {
            throw new Exception("请出示您的票据");
        }
        if (!ticketBagMap.containsKey(ticket)) {
            throw new Exception("票据不合法");
        }
        size -= 1;
        Bag bag = ticketBagMap.get(ticket);
        ticketBagMap.remove(ticket);
        return bag;
    }

    private String generateTicket() {
        return String.valueOf(System.currentTimeMillis());
    }
}
