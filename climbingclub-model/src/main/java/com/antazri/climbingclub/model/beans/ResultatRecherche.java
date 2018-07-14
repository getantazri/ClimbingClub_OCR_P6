package com.antazri.climbingclub.model.beans;

import java.util.ArrayList;
import java.util.List;

public class ResultatRecherche {

    private List<Object> results = new ArrayList<Object>();

    public List<Object> getResults() {
        return results;
    }

    public void setResults(List<Object> results) {
        this.results = results;
    }

    public void addResult(Object object) {
        getResults().add(object);
    }

    public void addAllResults(List<? extends Object> results) {
        getResults().addAll(results);
    }
}
