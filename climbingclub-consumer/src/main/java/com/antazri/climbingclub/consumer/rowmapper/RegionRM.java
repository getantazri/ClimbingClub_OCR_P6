package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.Region;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionRM implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Region region = new Region();

        region.setRegion_id(rs.getInt("region_id"));
        region.setNom(rs.getString("nom"));

        return region;
    }
}
