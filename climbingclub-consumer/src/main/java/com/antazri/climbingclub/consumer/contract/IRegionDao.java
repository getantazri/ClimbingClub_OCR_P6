package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Region;

import java.util.List;

public interface IRegionDao {

    public Region findById(int pId);
    public Region findByName(String pName);
    public List<Region> findAll();
    public Region create(Region pRegion);
    public Region update(Region pRegion);
    public void delete(Region pRegion);
}
