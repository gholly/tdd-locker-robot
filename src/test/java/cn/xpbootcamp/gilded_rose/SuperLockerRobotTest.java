package cn.xpbootcamp.gilded_rose;

 import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SuperLockerRobotTest {


    @Test
    public void should_return_ticket_and_store_2st_locker_when_store_bag_given_super_robot_have_1st_locker_empty_capacity_rate_is_3_rate_4_and_2nd_locker_empty_capacity_rate_is_1() {
        //given
        Locker firstLocker = new Locker(4);
        Locker secondLocker = new Locker(2);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Lists.newArrayList(firstLocker, secondLocker));
        firstLocker.store(new Bag());

        //when
        Bag bag = new Bag();
        Ticket ticket = superLockerRobot.store(bag);
        //then
        assertThat(ticket).isNotNull();
        assertThat(secondLocker.take(ticket)).isEqualTo(bag);
    }




}
