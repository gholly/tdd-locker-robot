package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.LockerFullException;

import java.util.Comparator;
import java.util.List;

public class SmartLockerRobot {

    private List<Locker> lockers;


    public SmartLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket storeBag(Bag bag) {
        Locker needStoreLocker = lockers.stream()
                .sorted(Comparator.comparing(Locker::getEmptyCapacity).reversed())
                .filter(locker -> !locker.isFull())
                .findFirst()
                .orElseThrow(LockerFullException::new);
        Ticket ticket = needStoreLocker.storeBag(bag);
        return ticket;
    }
}
