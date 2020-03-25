package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LockerTest {

    @Test
    public void should_return_ticket_when_lock_bag_given_locker_is_not_full() {
        Locker locker = new Locker(16);
        Ticket ticket = locker.lock(new Bag());
        assertThat(ticket).isNotNull();
    }

    @Test
    public void should_return_exception_when_unlock_bag_given_locker_is_full() {
        Locker locker = new Locker(19);
        try {
            locker.unlock(new Ticket());
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("柜子已满");
        }
    }
}
