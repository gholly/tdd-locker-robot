package cn.xpbootcamp.gilded_rose;

import java.util.Map;

public class Locker {
    private Integer size;
    private Map<Ticket, Bag> ticketBagMap;

    public Locker(int i) {
        this.size=i;
    }

    public Ticket lock(Bag bag) {
        return new Ticket();
    }

    public Bag unlock(Ticket ticket) throws Exception {
        if (size == 19) {
            throw new Exception("柜子已满");
        }
        size-=1;
       return ticketBagMap.get(ticket);
    }
}
