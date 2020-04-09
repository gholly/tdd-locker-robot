package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.LockerFullException;
import cn.xpbootcamp.gilded_rose.exception.TicketErrorException;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrimaryLockerRobotTest {

    @Test
    public void should_return_ticket_when_store_bag_given_locker_robot_is_not_full() {
        //given
        Locker locker = new Locker(20);
        Locker locker01 = new Locker(20);
        PrimaryLockerRobot lockerRobot = new PrimaryLockerRobot(Lists.newArrayList(locker, locker01));
        //when
        Ticket ticket = lockerRobot.storeBag(new Bag());
        //then
        assertThat(ticket).isNotNull();
    }

    @Test
    public void should_throw_locker_full_exception_when_store_bag_given_locker_robot_is_full() {
        //given
        Locker locker = new Locker(1);
        Locker locker01 = new Locker(1);
        PrimaryLockerRobot lockerRobot = new PrimaryLockerRobot(Lists.newArrayList(locker, locker01));
        //when
        locker.storeBag(new Bag());
        locker01.storeBag(new Bag());
        // then
        assertThrows(LockerFullException.class, () -> lockerRobot.storeBag(new Bag()));
    }

    @Test
    public void should_return_bag_when_take_bag_given_locker_robot_is_not_empty_and_right_ticket() throws Exception {
        //given
        Bag bag = new Bag();
        Locker locker = new Locker(20);
        Locker locker01 = new Locker(20);
        PrimaryLockerRobot lockerRobot = new PrimaryLockerRobot(Lists.newArrayList(locker, locker01));

        Ticket ticket = lockerRobot.storeBag(bag);
        //when
        Bag unlockedBag = lockerRobot.takeBag(ticket);
        //then
        assertThat(unlockedBag).isNotNull();
    }

    @Test
    public void should_throw_ticket_error_exception_when_take_bag_given_ticket_is_wrong() {
        //given
        Locker locker = new Locker(20);
        Locker locker01 = new Locker(20);
        PrimaryLockerRobot lockerRobot = new PrimaryLockerRobot(Lists.newArrayList(locker, locker01));
        Ticket ticket = new Ticket();
        //then
        assertThrows(TicketErrorException.class, () -> lockerRobot.takeBag(ticket));
    }

}
