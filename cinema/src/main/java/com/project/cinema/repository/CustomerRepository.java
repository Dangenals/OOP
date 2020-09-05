package com.project.cinema.repository;

import com.project.cinema.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class  CustomerRepository {
   private JdbcTemplate jdbcTemplate;


    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> getAllCustomers(){
        String sql = "SELECT * FROM customer";
       return jdbcTemplate.query(sql, new RowMapper<Customer>(){
           @Override
           public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
               Customer customer = new Customer();
               customer.setCustomerId(resultSet.getInt(1));
               customer.setCustomerFirstName(resultSet.getString(2));
               customer.setCustomerLastName(resultSet.getString(3));
               customer.setCustomerPhoneNumber(resultSet.getString(4));
               customer.setCustomerEmail(resultSet.getString(5));
               return customer;
           }
       });
    }

    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM customer WHERE customer_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Customer.class));
    }

    public void deleteCustomerById(int id) {
        String sql ="DELETE FROM customer WHERE customer_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void insertCustomer(Customer customer) {
        String sql = "INSERT INTO customer VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, customer.getCustomerId(), customer.getCustomerFirstName(),
                customer.getCustomerLastName(), customer.getCustomerPhoneNumber(), customer.getCustomerEmail());
    }
}
