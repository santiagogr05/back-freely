package com.freely.freely.repositories;

import com.freely.freely.entities.FreelancerService;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceRowMapper implements RowMapper<FreelancerService> {
    @Override
    public FreelancerService mapRow(ResultSet rs, int rowNum) throws SQLException {
        return FreelancerService.builder().
                id(rs.getObject("id",Integer.class))
                .service(rs.getString("service"))
                .description(rs.getString("description"))
                .category(rs.getString("category")).build();
    }
}
