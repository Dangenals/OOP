package com.project.cinema.controllers;


import com.project.cinema.model.Ticket;
import com.project.cinema.services.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/tickets/{id}")
    public Ticket getTicketById(@PathVariable int id){
        return ticketService.getTicketById(id);
    }

    @DeleteMapping("/tickets/{id}")
    public String deleteTicketById(@PathVariable int id){
        ticketService.deleteTicketById(id);
        return "Ticket was deleted";
    }

    @PostMapping("/tickets")
    public String createTicket(@PathVariable Ticket ticket){
        ticketService.createTicket(ticket);
        return "Ticket was added";
    }
}
