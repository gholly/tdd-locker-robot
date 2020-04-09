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
        Locker locker = new Locker(20);
        //when
        Ticket ticket = locker.store(new Bag());
        //then
        assertThat(ticket).isNotNull();
        assertThat(locker.getEmptyCapacity()).isEqualTo(19);
    }

    @Test
    public void should_throw_locker_full_exception_when_store_bag_given_locker_is_full() {
        //given
        Locker locker = new Locker(1);
        locker.store(new Bag());
        //when then
        assertThrows(LockerFullException.class, () -> locker.store(new Bag()));
    }

    @Test
    public void should_return_bag_when_take_bag_given_locker_is_not_empty_and_right_ticket() throws Exception {
        //given
        Locker locker = new Locker(20);
        Bag bag = new Bag();

        Ticket ticket = locker.store(bag);
        //when
        Bag unlockedBag = locker.take(ticket);
        //then
        assertThat(unlockedBag).isNotNull();
        assertThat(locker.getEmptyCapacity()).isEqualTo(20);
    }


    @Test
    public void should_throw_ticket_error_exception_when_take_bag_given_ticket_is_wrong() {
        //given
        Locker locker = new Locker(20);
        Bag bag = new Bag();
        Ticket ticket = new Ticket();
        //when
        locker.store(bag);
        //then
        assertThrows(TicketErrorException.class, () -> locker.take(ticket));
    }

}
