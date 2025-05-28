package com.masters.crud.service;

import com.masters.crud.dao.TicketDao;
import com.masters.crud.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketDao ticketDao;

    @Scheduled(fixedRate = 5000)
    public void addToDb(Ticket ticket) {
        Ticket ti = new Ticket();
        ti.setId(11);
        ticketDao.save(ti);
        System.out.println("Ticket saved " + ti.toString());
    }

    @Scheduled(cron = "*/15 * * * * *")
    public void findAll() {
        Iterable<Ticket> tickets = ticketDao.findAll();
        System.out.println("tickets " + tickets);
        System.out.println("Total tickets " + ticketDao.count());
    }
}
