package com.freely.freely.respositories;

import com.freely.freely.DTO.ServicesDTO;
import com.freely.freely.entities.Services;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    public Services findById(Integer id) {
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

    public Optional<Services> update(Integer id, ServicesDTO service) throws SQLException {
        try{
            int rows = jdbc.update("""
                    UPDATE services SET service = ?, description = ?, category = ?
                    WHERE id = ?
                    """,service.service(), service.description(), service.category(),id);
            if (rows == 0) return Optional.empty();

            return jdbc.query("""
            SELECT id, service, description, category
            FROM services
            WHERE id = ?
        """, mapper, id).stream().findFirst();

        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new SQLException();
        }
    }

    public Optional<Services> delete(Integer id) throws SQLException {
        var list = jdbc.query("""
                SELECT * FROM services WHERE id = ?
                """, mapper, id);

        if (list.isEmpty()) return Optional.empty();
        jdbc.update("DELETE FROM services WHERE id = ?", id);

        return  list.stream().findFirst();
    }




}
