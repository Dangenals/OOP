package com.project.cinema.services;

import com.project.cinema.model.Booking;
import com.project.cinema.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.getAllBookings();
    }

    public Booking getBookingById(int id) {
        return bookingRepository.getBookingById(id);
    }

    public void createBooking(Booking booking) {
        bookingRepository.insertBooking(booking);
    }

    public void deleteBookingById(int id) {
        bookingRepository.deleteBookingById(id);
    }
}
