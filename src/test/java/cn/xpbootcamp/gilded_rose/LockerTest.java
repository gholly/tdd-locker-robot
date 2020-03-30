package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.LockerFullException;
import cn.xpbootcamp.gilded_rose.exception.TicketErrorException;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerTest {
    @Test
    public void should_return_ticket_when_store_bag_given_locker_is_not_full() {
        //given
        Locker locker = new Locker(20, 16);
        //when
        Ticket ticket = locker.storeBag(new Bag("my bag"));
        //then
        assertThat(ticket).isNotNull();
        assertThat(locker.getEmptyCapacity()).isEqualTo(15);
        assertThat(locker.getTotalCapacity()).isEqualTo(20);
    }

    @Test
    public void should_throw_locker_full_exception_when_store_bag_given_locker_is_full() {
        //given
        Locker locker = new Locker(20, 0);
        //when then
        assertThrows(LockerFullException.class, () -> locker.storeBag(new Bag("my bag")));
    }

    @Test
    public void should_return_bag_when_take_bag_given_locker_is_not_empty_and_right_ticket() throws Exception {
        //given
        Locker locker = new Locker(20, 19);
        Bag bag = new Bag("bag-id");

        Ticket ticket = locker.storeBag(bag);
        //when
        Bag unlockedBag = locker.takeBag(ticket);
        //then
        assertThat(unlockedBag).isNotNull();
        assertThat(unlockedBag.getId()).isEqualTo("bag-id");
        assertThat(locker.getEmptyCapacity()).isEqualTo(19);
        assertThat(locker.getTotalCapacity()).isEqualTo(20);
    }


    @Test
    public void should_throw_ticket_error_exception_when_take_bag_given_ticket_is_wrong() {
        //given
        Locker locker = new Locker(20, 19);
        Bag bag = new Bag("bag-id");
        Ticket ticket = new Ticket("ticket-id");
        //when
        locker.storeBag(bag);
        //then
        assertThrows(TicketErrorException.class, () -> locker.takeBag(ticket));
    }

}
