package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.TicketErrorException;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerTest {
    //存包
    @Test
    public void should_return_ticket_when_lock_bag_given_locker_is_not_full() {
        Locker locker = new Locker(16);
        Ticket ticket = locker.storeBag(new Bag("my bag"));
        assertThat(ticket).isNotNull();
        assertThat(locker.getSize()).isEqualTo(15);
    }

    @Test
    public void should_return_exception_when_lock_bag_given_locker_is_full() {
        Locker locker = new Locker(0);
        assertThrows(
                TicketErrorException.class,
                () -> locker.storeBag(new Bag("my bag")));
    }

    @Test
    public void should_return_bag_when_unlock_bag_given_locker_is_not_empty_and_right_ticket() throws Exception {
        //given
        Locker locker = new Locker(19);
        Bag bag = new Bag("bag-id");

        Ticket ticket = locker.storeBag(bag);
        //when
        Bag unlockedBag = locker.takeBag(ticket);
        //should
        assertThat(unlockedBag).isNotNull();
        assertThat(unlockedBag.getId()).isEqualTo("bag-id");
        assertThat(locker.getSize()).isEqualTo(20);


    }


    @Test
    public void should_return_exception_when_unlock_bag_given_ticket_is_wrong() {
        //given
        Locker locker = new Locker(19);
        Bag bag = new Bag("bag-id");
        Ticket ticket = new Ticket("ticket-id");
        locker.storeBag(bag);

        assertThrows(
                TicketErrorException.class,
                () -> locker.takeBag(ticket));

    }


}
