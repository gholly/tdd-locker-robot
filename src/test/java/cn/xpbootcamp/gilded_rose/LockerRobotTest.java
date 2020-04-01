package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.LockerFullException;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerRobotTest {

    @Test
    public void should_return_ticket_when_store_bag_given_locker_robot_is_not_full() {
        //given
        Locker locker = new Locker(20, 16);
        Locker locker01 = new Locker(20, 16);
        LockerRobot lockerRobot = new LockerRobot(Lists.newArrayList(locker, locker01));
        //when
        Ticket ticket = lockerRobot.storeBag(new Bag("my bag"));
        //then
        assertThat(ticket).isNotNull();
    }

    @Test
    public void should_throw_locker_full_exception_when_store_bag_given_locker_robot_is_full() {
        //given
        Locker locker = new Locker(20, 0);
        Locker locker01 = new Locker(20, 0);
        LockerRobot lockerRobot = new LockerRobot(Lists.newArrayList(locker, locker01));
        //when then
        assertThrows(LockerFullException.class, () -> lockerRobot.storeBag(new Bag("my bag")));
    }


}
