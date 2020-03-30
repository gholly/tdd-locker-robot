package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.LockerFullException;
import cn.xpbootcamp.gilded_rose.exception.TicketErrorException;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private Integer size;
    private Map<Ticket, Bag> ticketBagMap = new HashMap<>();


    public Integer getSize() {
        return size;
    }

    public Locker(int size) {
        this.size = size;
    }

    public Ticket storeBag(Bag bag) {
        if (size == 0) {
            throw new LockerFullException();
        }
        size -= 1;
        Ticket ticket = new Ticket(generateTicket());
        ticketBagMap.put(ticket, bag);
        return ticket;
    }

    public Bag takeBag(Ticket ticket) {
        if (!ticketBagMap.containsKey(ticket)) {
            throw new TicketErrorException();
        }
        size += 1;
        Bag bag = ticketBagMap.get(ticket);
        ticketBagMap.remove(ticket);
        return bag;
    }

    private String generateTicket() {
        return String.valueOf(System.currentTimeMillis());
    }
}
