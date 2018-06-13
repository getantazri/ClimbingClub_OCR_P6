package com.antazri.climbingclub.business.bo.impl;

import com.antazri.climbingclub.business.bo.contract.IRegionBo;
import com.antazri.climbingclub.consumer.contract.IRegionDao;
import com.antazri.climbingclub.model.beans.Region;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RegionBo implements IRegionBo {

    @Autowired
    IRegionDao regionDao;

    public Region findById(int pId) {
        return regionDao.findById(pId);
    }

    public Region findByName(String pName) {
        return regionDao.findByName(pName);
    }

    public List<Region> findAll() {
        return regionDao.findAll();
    }

    public Region create(Region pRegion) {
        return regionDao.create(pRegion);
    }

    public Region update(Region pRegion) {
        return regionDao.update(pRegion);
    }

    public void delete(Region pRegion) {
        regionDao.delete(pRegion);
    }
}
