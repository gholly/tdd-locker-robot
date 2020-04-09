package cn.xpbootcamp.gilded_rose;


public interface Robot {

    Ticket store(Bag bag);

    Bag take(Ticket ticket);
}
