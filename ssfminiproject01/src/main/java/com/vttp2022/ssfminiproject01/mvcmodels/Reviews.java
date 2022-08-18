package com.vttp2022.ssfminiproject01.mvcmodels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.json.JsonObject;

public class Reviews {
    
    private String status;
    private String copyright;
    private String numResults;
    private List<Resultsreviews> results = new ArrayList<>();

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
    public String getCopyright() {return copyright;}
    public void setCopyright(String copyright) {this.copyright = copyright;}
    public String getNumResults() {return numResults;}
    public void setNumResults(String numResults) {this.numResults = numResults;}
    public List<Resultsreviews> getResults() {return results;}
    public void setResults(List<Resultsreviews> results) {this.results = results;}

    public void addResultsreviews(String summary, String isbn13, String url){
        Resultsreviews rr = new Resultsreviews();
        rr.setSummary(summary);
        rr.setIsbn13(isbn13);
        rr.setUrl(url);
        results.add(rr);
        
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(results);
            System.out.println(json);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static Reviews createJson(JsonObject o)throws IOException {
        Reviews rv = new Reviews();
        rv.status = o.getString("status");
        rv.copyright = o.getString("copyright");
        rv.numResults = o.getString("num_results");
        return rv;
    }
}
