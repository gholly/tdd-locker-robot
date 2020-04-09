package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.LockerFullException;
import cn.xpbootcamp.gilded_rose.exception.TicketErrorException;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartLockerRobotTest {

    @Test
    public void should_return_ticket_when_store_bag_given_smart_locker_robot_is_not_full_and_have_empty_capacity_is_3_and_empty_capacity_is_1() {
        //given
        Locker locker = new Locker(20, 16);
        Locker locker01 = new Locker(20, 16);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(locker, locker01));
        //when
        Ticket ticket = smartLockerRobot.storeBag(new Bag());
        //then
        assertThat(ticket).isNotNull();
    }

    @Test
    public void should_throw_locker_full_exception_when_store_bag_given_smart_locker_robot_is_full() {
        //given
        Locker locker = new Locker(20, 0);
        Locker locker01 = new Locker(20, 0);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(locker, locker01));
        //when then
        assertThrows(LockerFullException.class, () -> smartLockerRobot.storeBag(new Bag()));
    }


    @Test
    public void should_return_bag_when_take_bag_given_smart_locker_robot_is_not_empty_and_right_ticket() throws Exception {
        //given
        Bag bag = new Bag();
        Locker locker = new Locker(20, 19);
        Locker locker01 = new Locker(20, 0);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(locker, locker01));

        Ticket ticket = smartLockerRobot.storeBag(bag);
        //when
        Bag unlockedBag = smartLockerRobot.takeBag(ticket);
        //then
        assertThat(unlockedBag).isNotNull();
    }

    @Test
    public void should_throw_ticket_error_exception_when_take_bag_given_ticket_is_wrong() {
        //given
        Locker locker = new Locker(20, 19);
        Locker locker01 = new Locker(20, 0);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(locker, locker01));
        Ticket ticket = new Ticket();
        //then
        assertThrows(TicketErrorException.class, () -> smartLockerRobot.takeBag(ticket));
    }
}
