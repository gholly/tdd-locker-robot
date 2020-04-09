package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.LockerFullException;
import cn.xpbootcamp.gilded_rose.exception.TicketErrorException;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private Integer totalCapacity;
    private Integer emptyCapacity;
    private Map<Ticket, Bag> ticketBagMap = new HashMap<>();


    public Integer getEmptyCapacity() {
        return totalCapacity - ticketBagMap.size();
    }

    public Integer getTotalCapacity() {
        return totalCapacity;
    }

    public Locker(Integer totalCapacity, Integer emptyCapacity) {
        this.totalCapacity = totalCapacity;
        this.emptyCapacity = emptyCapacity;
    }

    public boolean isFull() {
        return emptyCapacity == 0;
    }

    public Ticket storeBag(Bag bag) {
        if (emptyCapacity == 0) {
            throw new LockerFullException();
        }
        emptyCapacity -= 1;
        Ticket ticket = new Ticket();
        ticketBagMap.put(ticket, bag);
        return ticket;
    }

    public Bag takeBag(Ticket ticket) {
        if (!ticketBagMap.containsKey(ticket)) {
            throw new TicketErrorException();
        }
        emptyCapacity += 1;
        Bag bag = ticketBagMap.get(ticket);
        ticketBagMap.remove(ticket);
        return bag;
    }

}
