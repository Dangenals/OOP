package com.project.cinema.services;

import com.project.cinema.model.Ticket;
import com.project.cinema.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService  {
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.getAllTickets();
    }

    public Ticket getTicketById(int id){
        return ticketRepository.getTicketById(id);
    }

    public void deleteTicketById(int id){
        ticketRepository.deleteTicketById(id);
    }

    public void createTicket(Ticket ticket){
        ticketRepository.insertTicket(ticket);
    }
}
