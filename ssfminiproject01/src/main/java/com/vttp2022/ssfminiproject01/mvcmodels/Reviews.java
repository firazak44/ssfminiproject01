package com.vttp2022.ssfminiproject01.mvcmodels;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Reviews {
    
    private String status;
    private String copyright;
    private String numResults;
    private Resultsreviews[] resultsreviews;
    private Query query;

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
    public String getCopyright() {return copyright;}
    public void setCopyright(String copyright) {this.copyright = copyright;}
    public String getNumResults() {return numResults;}
    public void setNumResults(String numResults) {this.numResults = numResults;}
    public Resultsreviews[] getResults() {return resultsreviews;}
    public void setResults(Resultsreviews[] results) {this.resultsreviews = results;}
    public Query getQuery() {return query;}
    public void setQuery(Query query) {this.query = query;}
    
    public static Reviews createJson(JsonObject o) {
        Reviews rv = new Reviews();
        rv.status = o.getString("status");
        rv.copyright = o.getString("copyright");
        rv.numResults = o.getString("num_results");
        return rv;
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder()
        .add("status",status)
        .add("copyright",copyright)
        .add("num_results",numResults)
        .build();
    }
    public void setIsbn(int isbn) {
    }
}
