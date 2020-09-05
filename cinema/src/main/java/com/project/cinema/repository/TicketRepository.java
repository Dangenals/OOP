package com.project.cinema.repository;

import com.project.cinema.model.Ticket;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TicketRepository {
    private JdbcTemplate jdbcTemplate;

    public TicketRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Ticket> getAllTickets(){
        String sql = "SELECT * FROM ticket";
        return jdbcTemplate.query(sql, new RowMapper<Ticket>() {
            @Override
            public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
                Ticket ticket = new Ticket();
                ticket.setTicketId(resultSet.getInt(1));
                ticket.setTicketType(resultSet.getString(2));
                ticket.setBookingId(resultSet.getInt(3));
                return ticket;
            }
        });
    }

    public Ticket getTicketById(int id){
        String sql = "SELECT * FROM ticket WHERE ticket_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Ticket.class));
    }

    public void deleteTicketById(int id){
        String sql = "DELETE FROM ticket WHERE ticket_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void insertTicket(Ticket ticket){
        String sql = "INSERT INTO ticket VALUES (?,?,?)";
        jdbcTemplate.update(sql, ticket.getTicketId(), ticket.getTicketType(), ticket.getBookingId());
    }
}
