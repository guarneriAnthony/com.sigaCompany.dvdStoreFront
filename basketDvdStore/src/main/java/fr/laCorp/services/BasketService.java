package fr.laCorp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BasketService {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BasketService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void calculate(int id){
        jdbcTemplate.execute("CALL public.calculateprice(" +id +");");
    }


}
