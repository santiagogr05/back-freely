package com.freely.freely.respositories;

import com.freely.freely.entities.Services;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceRowMapper implements RowMapper<Services> {
    @Override
    public Services mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Services.builder().
                id(rs.getObject("id",Integer.class))
                .service(rs.getString("service"))
                .description(rs.getString("description"))
                .category(rs.getString("category")).build();
    }
}
