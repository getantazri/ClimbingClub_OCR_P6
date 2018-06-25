package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Cotation;

import java.util.List;

public interface ICotationDao {

    Cotation findById(int pId);
    Cotation findByName(String pName);
    List<Cotation> findAll();
    int create(Cotation pCotation);
    int update(Cotation pCotation);
    void delete(Cotation pCotation);
}
