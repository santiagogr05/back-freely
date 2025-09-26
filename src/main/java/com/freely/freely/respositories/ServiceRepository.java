package com.freely.freely.respositories;

import com.freely.freely.DTO.ServicesDTO;
import com.freely.freely.entities.Services;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
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
        return (Services) jdbc.query("""
                SELECT * FROM services WHERE id = ?
                """, mapper, id);
    }

    public Services create(ServicesDTO service) throws SQLException {
        try{
            jdbc.query("""
                    INSERT INTO services (service, description, category) VALUES (?, ?, ?)
                    """, mapper, service.service(), service.description(), service.category());
            return new Services(service.service(), service.description(), service.category());
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new Services();
        }
    }


}
