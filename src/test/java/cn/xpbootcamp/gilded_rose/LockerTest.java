package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LockerTest {

    @Test
    public void should_return_ticket_when_lock_bag_given_locker_is_not_full() throws Exception {
        Locker locker = new Locker(16);
        Ticket ticket = locker.lock(new Bag("my bag"));
        assertThat(ticket).isNotNull();
        assertThat(locker.getSize()).isEqualTo(15);
    }

    @Test
    public void should_return_exception_when_lock_bag_given_locker_is_full() {
        Locker locker = new Locker(0);
        try {
            locker.lock(new Bag("my bag"));
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("柜子已满");
        }
    }

    @Test
    public void should_return_bag_when_unlock_bag_given_locker_is_not_empty_and_right_ticket() throws Exception {
        //given
        Locker locker = new Locker(19);
        Bag bag = new Bag("bag-id");
        Ticket ticket = new Ticket("ticket-id");

        locker.setTicketBagMap(ticket, bag);
        //when
        Bag unlockedBag = locker.unlock(ticket);
        //should
        assertThat(unlockedBag).isNotNull();
        assertThat(unlockedBag.getId()).isEqualTo("bag-id");
        assertThat(locker.getSize()).isEqualTo(20);


    }

    @Test
    public void should_return_exception_when_unlock_bag_given_ticket_is_null() {
        //given
        Locker locker = new Locker(19);
        Bag bag = new Bag("bag-id");
        Ticket ticket = new Ticket("ticket-id");

        locker.setTicketBagMap(ticket, bag);
        //when
        try {
            locker.unlock(null);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("请出示您的票据");
        }
    }

    @Test
    public void should_return_exception_when_unlock_bag_given_ticket_is_wrong() {
        //given
        Locker locker = new Locker(19);
        Bag bag = new Bag("bag-id");
        Ticket ticket = new Ticket("ticket-id");

        locker.setTicketBagMap(ticket, bag);
        //when
        try {
            locker.unlock(new Ticket("错误的票据"));
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("票据不合法");
        }
    }


}
