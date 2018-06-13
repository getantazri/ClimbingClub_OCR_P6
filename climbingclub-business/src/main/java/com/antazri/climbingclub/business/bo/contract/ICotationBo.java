package com.antazri.climbingclub.business.bo.contract;

import com.antazri.climbingclub.model.beans.Cotation;

import java.util.List;

public interface ICotationBo {

    Cotation findById(int pId);
    Cotation findByName(String pName);
    List<Cotation> findAll();
    Cotation create(Cotation pCotation);
    Cotation update(Cotation pCotation);
    void delete(Cotation pCotation);
}
