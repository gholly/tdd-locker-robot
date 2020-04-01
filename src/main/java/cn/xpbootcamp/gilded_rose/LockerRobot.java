package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.LockerFullException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LockerRobot {
    private List<Locker> lockers;
    private Map<Ticket, Locker> ticketLockerMap = new HashMap<>();


    public LockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket storeBag(Bag bag) {
        Locker needStoreLocker = lockers.stream()
                .filter(locker -> !locker.isFull())
                .findFirst()
                .orElseThrow(LockerFullException::new);
        Ticket ticket = needStoreLocker.storeBag(bag);
        ticketLockerMap.put(ticket, needStoreLocker);
        return ticket;
    }

    public Bag takeBag(Ticket ticket) {
        Bag bag = ticketLockerMap.get(ticket).takeBag(ticket);
        ticketLockerMap.remove(ticket);
        return bag;
    }
}
