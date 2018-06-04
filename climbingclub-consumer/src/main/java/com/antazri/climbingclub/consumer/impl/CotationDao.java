package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ICotationDao;
import com.antazri.climbingclub.model.beans.Cotation;

import javax.sql.DataSource;
import java.util.List;

public class CotationDao extends AbstractDao implements ICotationDao {

    public Cotation findById(int pId) {
        return null;
    }

    public Cotation findByName(String pName) {
        return null;
    }

    public List<Cotation> findAll() {
        return null;
    }

    public Cotation create(Cotation pCotation) {
        return null;
    }

    public Cotation update(Cotation pCotation) {
        return null;
    }

    public void delete(Cotation pCotation) {

    }
}
