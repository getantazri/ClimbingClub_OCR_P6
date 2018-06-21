package com.antazri.climbingclub.consumer.extractor;

import com.antazri.climbingclub.model.beans.Commentaire;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentaireExtractor implements ResultSetExtractor {

    public Commentaire extractData(ResultSet rs) throws SQLException, DataAccessException {


        return null;
    }
}
