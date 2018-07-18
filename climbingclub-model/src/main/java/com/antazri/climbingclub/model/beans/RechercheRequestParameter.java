package com.antazri.climbingclub.model.beans;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RechercheRequestParameter {

    private Map<String, String> parameters = new HashMap<>();
    private Map<String, String> columns = new HashMap<>();

    private String sql = "SELECT * FROM public.topo" +
            "JOIN public.region ON topo.region_id = region.region_id " +
            "WHERE region_id = :region";

    public void setNom(String pNom) {
        columns.put("topo.topo_nom", ":nom");
        parameters.put(":nom", pNom);
    }

    public void setNomRegion(String pNomRegion) {
        columns.put("region.region_nom", ":region");
        parameters.put(":region", pNomRegion);
    }

    public void setNomCotation(String pNomCotation) {
        columns.put("cotation.cotation_nom", ":cotation");
        parameters.put(":cotation", pNomCotation);
    }

    public void setHauteurMin(String pHauteurMin) {
        columns.put("spot.hauteur", ":hauteurMin");
        parameters.put(":hauteurMin", pHauteurMin);
    }

    public void setHauteurMax(String pHauteurMax) {
        columns.put("spot.hauteur", ":hauteurMax");
        parameters.put(":hauteurMax", pHauteurMax);
    }

    public String generateWhere(Map<String, String> parameters) {
        String where = "WHERE ";

        if (parameters.isEmpty()) {
            return "";
        }

        for (Iterator<String> i = columns.keySet().iterator(); i.hasNext();) {
            String key = i.next();

            where += key + " LIKE " + columns.get(key);

            if (i.hasNext()) {
                where += " AND ";
            }
        }

        return where;
    }
}
