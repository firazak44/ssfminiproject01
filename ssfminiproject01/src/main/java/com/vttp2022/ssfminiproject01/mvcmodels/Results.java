package com.vttp2022.ssfminiproject01.mvcmodels;

import jakarta.json.JsonObject;

public class Results {

    private String displayName;
    private String oldestPublishedDate;
    private String newestPublishedDate;
    private String update;
    
    public String getDisplayName() {return displayName;}
    public void setDisplayName(String displayName) {this.displayName = displayName;}
    public String getOldestPublishedDate() {return oldestPublishedDate;}
    public void setOldestPublishedDate(String oldestPublishedDate) {this.oldestPublishedDate = oldestPublishedDate;}
    public String getNewestPublishedDate() {return newestPublishedDate;}
    public void setNewestPublishedDate(String newestPublishedDate) {this.newestPublishedDate = newestPublishedDate;}
    public String getUpdate() {return update;}
    public void setUpdate(String update) {this.update = update;}
    
    public static Results createJson(JsonObject o){
        Results r = new Results();
        r.displayName = String.format(o.getString("display_name"));
        r.oldestPublishedDate = "%s".formatted(o.getString("oldest_published_date"));
        r.newestPublishedDate = "%s".formatted(o.getString("newest_published_date"));
        r.update = "%S".formatted(o.getString("updated"));
        return r;
    }
}
