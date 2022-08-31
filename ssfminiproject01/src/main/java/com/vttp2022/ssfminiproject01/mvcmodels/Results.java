package com.vttp2022.ssfminiproject01.mvcmodels;

import java.util.Random;

public class Results {

    private String displayName;
    private String oldestPublishedDate;
    private String newestPublishedDate;
    private String update;
    private String id;
    private boolean checksum;
    
    public Results() {this.id = generateId(8);}
    private String generateId(int i) {
        Random r = new Random();
        StringBuilder strBuilder = new StringBuilder();
        while (strBuilder.length() < i) {
            strBuilder.append(Integer.toHexString(r.nextInt()));
        }
        return strBuilder.toString().substring(0, i);
    }

    public boolean isChecksum() {return checksum;}
    public void setChecksum(boolean checksum) {this.checksum = checksum;}
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getDisplayName() {return displayName;}
    public void setDisplayName(String displayName) {this.displayName = displayName;}
    public String getOldestPublishedDate() {return oldestPublishedDate;}
    public void setOldestPublishedDate(String oldestPublishedDate) {this.oldestPublishedDate = oldestPublishedDate;}
    public String getNewestPublishedDate() {return newestPublishedDate;}
    public void setNewestPublishedDate(String newestPublishedDate) {this.newestPublishedDate = newestPublishedDate;}
    public String getUpdate() {return update;}
    public void setUpdate(String update) {this.update = update;}
    public void setInsertCount(int x) {}
    public void setUpdateCount(int nrsResult) {}

}
