package com.vttp2022.ssfminiproject01.mvcmodels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.json.JsonObject;

public class Names {
    
    private String status;
    private String copyright;
    private String numResults;
    private List<Results> results = new ArrayList<>();

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
    public String getCopyright() {return copyright;}
    public void setCopyright(String copyright) {this.copyright = copyright;}
    public String getNumResults() {return numResults;}
    public void setNumResults(String numResults) {this.numResults = numResults;}
    public List<Results> getResults() {return results;}
    public void setResults(List<Results> results) {this.results = results;}

    public void addResults(String newestPublishedDate, String update){
        Results r = new Results();
        r.setNewestPublishedDate(newestPublishedDate);
        r.setUpdate(update);
        results.add(r);
        
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(results);
            System.out.println(json);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static Names createJson(JsonObject o)throws IOException {
        Names n = new Names();
        n.status = o.getString("status");
        n.copyright = o.getString("copyright");
        n.numResults = o.getString("num_results");
        return n;
    }
    public static Names createJson(String body) {
        return null;
    }
}
