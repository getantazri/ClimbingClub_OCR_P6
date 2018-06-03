package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Cotation;

import java.util.List;

public interface ICotationDao {

    public Cotation findById(int pId);
    public Cotation findByName(String pName);
    public List<Cotation> findAll();
    public Cotation create(Cotation pCotation);
    public Cotation update(Cotation pCotation);
    public void delete(Cotation pCotation);
}
