package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Region;

import java.util.List;

public interface IRegionDao {

    Region findById(int pId);
    Region findByName(String pName);
    List<Region> findAll();
    Region create(Region pRegion);
    Region update(Region pRegion);
    void delete(Region pRegion);
}
