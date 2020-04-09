package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.LockerFullException;
import cn.xpbootcamp.gilded_rose.exception.TicketErrorException;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartLockerRobotTest {

    @Test
    public void should_return_ticket_and_store_1st_locker_when_store_bag_given_smart_locker_robot_have_two_lockers_and_1st_locker_empty_capacity_is_3_and_2nd_locker_empty_capacity_is_1() {
        //given
        Locker firstLocker = new Locker(3);
        Locker secondLocker = new Locker(1);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(firstLocker, secondLocker));
        //when
        Bag bag = new Bag();
        Ticket ticket = smartLockerRobot.store(bag);
        //then
        assertThat(ticket).isNotNull();
        assertThat(firstLocker.take(ticket)).isEqualTo(bag);
    }

    @Test
    public void should_return_ticket_when_store_bag_given_smart_locker_robot_is_not_full_and_have_empty_capacity_is_1_and_empty_capacity_is_3() {
        //given
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(3);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(firstLocker, secondLocker));
        //when
        Bag bag = new Bag();
        Ticket ticket = smartLockerRobot.store(bag);
        //then
        assertThat(ticket).isNotNull();
        assertThat(secondLocker.take(ticket)).isEqualTo(bag);
    }

    @Test
    public void should_return_ticket_when_store_bag_given_smart_locker_robot_is_not_full_and_have_empty_capacity_is_2_and_empty_capacity_is_2() {
        //given
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(firstLocker, secondLocker));
        //when
        Bag bag = new Bag();
        Ticket ticket = smartLockerRobot.store(bag);
        //then
        assertThat(ticket).isNotNull();
        assertThat(firstLocker.take(ticket)).isEqualTo(bag);
    }

    @Test
    public void should_throw_locker_full_exception_when_store_bag_given_smart_locker_robot_lockers_is_full() {
        //given
        Locker firstLocker = getFullLocker();
        Locker secondLocker = getFullLocker();
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(firstLocker, secondLocker));
        //when then
        assertThrows(LockerFullException.class, () -> smartLockerRobot.store(new Bag()));
    }

    private Locker getFullLocker() {
        Locker locker = new Locker(1);
        locker.store(new Bag());
        return locker;
    }


    @Test
    public void should_return_bag_when_take_bag_given_smart_locker_robot_is_not_empty_and_2nd_locker_right_ticket() {
        //given
        Bag bag = new Bag();
        Locker firstLocker = new Locker(20);
        Locker secondLocker = new Locker(20);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(firstLocker, secondLocker));

        Ticket ticket = secondLocker.store(bag);
        //when
        Bag unlockedBag = smartLockerRobot.take(ticket);
        //then
        assertThat(unlockedBag).isEqualTo(bag);
    }

    @Test
    public void should_return_bag_when_take_bag_given_smart_locker_robot_is_not_empty_and_1st_locker_right_ticket() {
        //given
        Bag bag = new Bag();
        Locker firstLocker = new Locker(20);
        Locker secondLocker = new Locker(20);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(firstLocker, secondLocker));

        Ticket ticket = firstLocker.store(bag);
        //when
        Bag unlockedBag = smartLockerRobot.take(ticket);
        //then
        assertThat(unlockedBag).isEqualTo(bag);
    }

    @Test
    public void should_throw_ticket_error_exception_when_take_bag_given_ticket_is_wrong() {
        //given
        Locker firstLocker = new Locker(20);
        Locker secondLocker = new Locker(20);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(firstLocker, secondLocker));
        Ticket ticket = new Ticket();
        //then
        assertThrows(TicketErrorException.class, () -> smartLockerRobot.take(ticket));
    }
}
