package com.masters.crud.controller;

import com.masters.crud.dao.TicketDao;
import com.masters.crud.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketDao ticketDao;

    @PostMapping("/book/tickets")
    public String bookTicket(@RequestBody List<Ticket> tickets) {
        ticketDao.saveAll(tickets);
        return "Ticket Booked";
    }

    @GetMapping("/get/tickets")
    public List<Ticket> getTickets() {
        return (List<Ticket>) ticketDao.findAll();
    }
}
