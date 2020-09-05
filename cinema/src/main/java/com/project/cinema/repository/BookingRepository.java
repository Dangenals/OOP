package com.project.cinema.repository;

import com.project.cinema.model.Booking;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookingRepository {
    private JdbcTemplate jdbcTemplate;

    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Booking> getAllBookings() {
        String sql = "SELECT * FROM booking";
        return jdbcTemplate.query(sql, new RowMapper<Booking>() {
            @Override
            public Booking mapRow(ResultSet resultSet, int i) throws SQLException {
                Booking booking = new Booking();
                booking.setBookingId(resultSet.getInt(1));
                booking.setBookingDate(resultSet.getString(2));
                booking.setBookingTime(resultSet.getString(3));
                booking.setTicketNumber(resultSet.getInt(4));
                booking.setSeanceId(resultSet.getInt(5));
                booking.setCustomerId(resultSet.getInt(6));
                return booking;
            }
        });
    }

    public Booking getBookingById(int id) {
        String sql = "SELECT * FROM booking WHERE booking_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Booking.class));
    }

    public void deleteBookingById(int id) {
        String sql = "DELETE FROM booking WHERE booking_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void insertBooking(Booking booking) {
        String sql = "INSERT INTO booking VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, booking.getBookingId(),booking.getBookingDate(),booking.getBookingTime(),
                booking.getTicketNumber(),booking.getSeanceId(),booking.getCustomerId());
    }
}
