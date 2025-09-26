package com.freely.freely.respositories;

import com.freely.freely.entities.Services;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceRepository {
    private final JdbcTemplate jdbc;
    private final ServiceRowMapper mapper = new ServiceRowMapper();

    public ServiceRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Services> findAll() {
        return jdbc.query("""
               SELECT * FROM services
               """,mapper);
    }

    public Services findById(String id) {

    }

}
