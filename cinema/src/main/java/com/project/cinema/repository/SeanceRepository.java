package com.project.cinema.repository;

import com.project.cinema.model.Seance;
import com.project.cinema.model.Ticket;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SeanceRepository {
    private JdbcTemplate jdbcTemplate;

    public SeanceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Seance> getAllSeances() {
        String sql = "SELECT * FROM seance";
        return jdbcTemplate.query(sql, new RowMapper<Seance>() {
            @Override
            public Seance mapRow(ResultSet resultSet, int i) throws SQLException {
                Seance seance = new Seance();
                seance.setSeanceId(resultSet.getInt(1));
                seance.setSeanceTime(resultSet.getString(2));
                seance.setSeanceDate(resultSet.getString(3));
                seance.setSeancePrice(resultSet.getInt(4));
                seance.setRoomId(resultSet.getInt(5));
                seance.setMovieId(resultSet.getInt(6));
                return seance;
            }
        });
    }

    public Seance getSeanceById(int SeanceId) {
        String sql = "SELECT * FROM seance WHERE seance_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{SeanceId}, new BeanPropertyRowMapper<>(Seance.class));
    }

    public void deleteSeanceById(int SeanceId) {
        String sql = "DELETE FROM seance WHERE seance_id = ?";
        jdbcTemplate.update(sql , SeanceId);
    }

    public void insertSeance(Seance seance){
        String sql = "INSERT INTO seance VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, seance.getSeanceId(),seance.getSeanceTime(),seance.getSeanceDate(),
                seance.getSeancePrice(),seance.getRoomId(),seance.getMovieId());
    }
}