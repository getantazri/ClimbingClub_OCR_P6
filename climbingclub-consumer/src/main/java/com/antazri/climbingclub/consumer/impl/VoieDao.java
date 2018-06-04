package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IVoieDao;
import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;

import javax.sql.DataSource;
import java.util.List;

public class VoieDao extends AbstractDao implements IVoieDao {

    public Voie findById(int pId) {
        return null;
    }

    public List<Voie> findBySecteur(Secteur pSecteur) {
        return null;
    }

    public List<Voie> findByCotation(Cotation pCotation) {
        return null;
    }

    public List<Voie> findAll() {
        return null;
    }

    public Voie create(Voie pSpot) {
        return null;
    }

    public Voie update(Voie pSpot) {
        return null;
    }

    public void delete(Voie pSpot) {

    }
}
