package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.LockerFullException;
import cn.xpbootcamp.gilded_rose.exception.TicketErrorException;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private Integer totalCapacity;
    private Map<Ticket, Bag> ticketBagMap = new HashMap<>();


    public Integer getEmptyCapacity() {
        return totalCapacity - ticketBagMap.size();
    }

    public Integer getTotalCapacity() {
        return totalCapacity;
    }

    public Locker(Integer totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public boolean isFull() {
        return getEmptyCapacity() == 0;
    }

    public Ticket storeBag(Bag bag) {
        if (getEmptyCapacity() == 0) {
            throw new LockerFullException();
        }
        Ticket ticket = new Ticket();
        ticketBagMap.put(ticket, bag);
        return ticket;
    }

    public Bag takeBag(Ticket ticket) {
        if (!ticketBagMap.containsKey(ticket)) {
            throw new TicketErrorException();
        }
        Bag bag = ticketBagMap.get(ticket);
        ticketBagMap.remove(ticket);
        return bag;
    }

}
