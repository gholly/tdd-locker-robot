package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.LockerFullException;
import cn.xpbootcamp.gilded_rose.exception.TicketErrorException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimaryLockerRobot implements Robot{
    private List<Locker> lockers;
    private Map<Ticket, Locker> ticketLockerMap = new HashMap<>();


    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        Locker needStoreLocker = lockers.stream()
                .filter(locker -> !locker.isFull())
                .findFirst()
                .orElseThrow(LockerFullException::new);
        Ticket ticket = needStoreLocker.store(bag);
        ticketLockerMap.put(ticket, needStoreLocker);
        return ticket;
    }

    public Bag take(Ticket ticket) {
        if (!ticketLockerMap.containsKey(ticket)) {
            throw new TicketErrorException();
        }
        Bag bag = ticketLockerMap.get(ticket).take(ticket);
        ticketLockerMap.remove(ticket);
        return bag;
    }
}
