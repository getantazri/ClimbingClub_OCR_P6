package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.consumer.contract.IUtilisateurDao;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TopoRM implements RowMapper {

    public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Topo topo = new Topo();

        topo.setTopoId(rs.getInt("topo_id"));

        topo.setNom(rs.getString("nom"));
        topo.setDisponible(rs.getBoolean("disponible"));

        return topo;
    }
}

