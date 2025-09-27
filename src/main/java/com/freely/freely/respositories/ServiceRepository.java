package com.freely.freely.respositories;

import com.freely.freely.DTO.ServicesDTO;
import com.freely.freely.entities.Services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Services> create(ServicesDTO service) throws SQLException {
        try{
            jdbc.update("""
                    INSERT INTO services (service, description, category) VALUES (?, ?, ?)
                    """, service.service(), service.description(), service.category());
            Services response = new Services(service.service(), service.description(), service.category());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new Services(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Services update(Integer id, ServicesDTO service) throws SQLException {
        try{
            jdbc.update("""
                    UPDATE services SET service = ?, description = ?, category = ?
                    WHERE id = ?
                    """,mapper,service.service(), service.description(), service.category(),id);
            return new Services(service.service(), service.description(), service.category());

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new Services();
        }
    }


}
