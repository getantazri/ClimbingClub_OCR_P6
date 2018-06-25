package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Region;

import java.util.List;

public interface IRegionDao {

    Region findById(int pId);
    Region findByName(String pName);
    List<Region> findAll();
    int create(Region pRegion);
    int update(Region pRegion);
    void delete(Region pRegion);
}
