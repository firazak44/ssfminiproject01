package com.vttp2022.ssfminiproject01.mvcmodels;

import java.io.Serializable;

public class Names implements Serializable {
    
    private String status;
    private String copyright;
    private Results[] results;
    
    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
    public String getCopyright() {return copyright;}
    public void setCopyright(String copyright) {this.copyright = copyright;}
    public Results[] getResults() {return results;}
    public void setResults(Results[] results) {this.results = results;}

}