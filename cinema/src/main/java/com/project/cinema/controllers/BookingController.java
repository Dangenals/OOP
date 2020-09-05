package com.project.cinema.controllers;


import com.project.cinema.model.Booking;
import com.project.cinema.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/bookings/{id}")
    public Booking getBookingById(@PathVariable int id){
        return bookingService.getBookingById(id);
    }

    @PostMapping("/bookings")
    public String createBooking(@RequestBody Booking booking){
        bookingService.createBooking(booking);
        return "Booking was added";
    }

    @DeleteMapping("/bookings/{id}")
    public String deleteBookingById(@PathVariable int id){
        bookingService.deleteBookingById(id);
        return "Booking was deleted";
    }

}
