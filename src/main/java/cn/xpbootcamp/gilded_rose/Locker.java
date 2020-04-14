package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.LockerFullException;
import cn.xpbootcamp.gilded_rose.exception.TicketErrorException;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private Integer totalCapacity;
    private Map<Ticket, Bag> ticketBagMap = new HashMap<>();

    public Locker(Integer totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Integer getEmptyCapacity() {
        return totalCapacity - ticketBagMap.size();
    }

    public Double getEmptyRate() {
        return Double.valueOf(getEmptyCapacity() / totalCapacity);
    }

    public boolean isFull() {
        return getEmptyCapacity() == 0;
    }

    public boolean isValidTicket(Ticket ticket) {
        return ticketBagMap.containsKey(ticket);
    }

    public Ticket store(Bag bag) {
        if (getEmptyCapacity() == 0) {
            throw new LockerFullException();
        }
        Ticket ticket = new Ticket();
        ticketBagMap.put(ticket, bag);
        return ticket;
    }

    public Bag take(Ticket ticket) {
        if (!ticketBagMap.containsKey(ticket)) {
            throw new TicketErrorException();
        }
        Bag bag = ticketBagMap.get(ticket);
        ticketBagMap.remove(ticket);
        return bag;
    }

}
