package com.masters.crud.dao;

import com.masters.crud.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketDao extends CrudRepository<Ticket, Integer> {
}
