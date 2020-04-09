package cn.xpbootcamp.gilded_rose;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmartLockerRobotTest {

    @Test
    public void should_return_ticket_when_store_bag_given_smart_locker_robot_is_not_full() {
        //given
        Locker locker = new Locker(20, 16);
        Locker locker01 = new Locker(20, 16);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(locker, locker01));
        //when
        Ticket ticket = smartLockerRobot.storeBag(new Bag());
        //then
        assertThat(ticket).isNotNull();
    }

}
