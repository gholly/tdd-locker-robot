package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.LockerFullException;
import cn.xpbootcamp.gilded_rose.exception.TicketErrorException;

import java.util.Comparator;
import java.util.List;

public class SmartLockerRobot implements Robot {

    private List<Locker> lockers;


    public SmartLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        Locker needStoreLocker = lockers.stream()
                .filter(locker -> !locker.isFull())
                .max(Comparator.comparing(Locker::getEmptyCapacity))
                .orElseThrow(LockerFullException::new);
        Ticket ticket = needStoreLocker.store(bag);
        return ticket;
    }

    public Bag take(Ticket ticket) {
        return lockers.stream()
                .filter(locker -> locker.isValidTicket(ticket))
                .map(locker -> locker.take(ticket))
                .findFirst()
                .orElseThrow(TicketErrorException::new);

    }
}
