package com.blend.androiddesignpattern.u_flyweight;

public class Test {

    public static void client() {
        Ticket ticket1 = TicketFactory.getTicket("青岛", "北京");
        ticket1.showTicketInfo("硬卧");
        Ticket ticket2 = TicketFactory.getTicket("青岛", "北京");
        ticket2.showTicketInfo("硬座");
        Ticket ticket3 = TicketFactory.getTicket("青岛", "北京");
        ticket3.showTicketInfo("软卧");
    }

}
