package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.LockerFullException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperLockerRobot implements Robot {

    private List<Locker> lockers;

    public SuperLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    private Optional<Locker> findMaxEmptyRateLocker() {
        return lockers.stream()
                .max(Comparator.comparing(Locker::getEmptyRate));
    }

    @Override
    public Ticket store(Bag bag) {
        Locker needStoreLocker = findMaxEmptyRateLocker().orElseThrow(LockerFullException::new);
        Ticket ticket = needStoreLocker.store(bag);
        return ticket;
    }

    @Override
    public Bag take(Ticket ticket) {
        return null;
    }
}
