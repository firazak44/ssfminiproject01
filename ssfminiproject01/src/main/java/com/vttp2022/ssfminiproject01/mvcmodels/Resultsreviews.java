package com.vttp2022.ssfminiproject01.mvcmodels;

import java.util.Random;

import jakarta.json.JsonObject;

public class Resultsreviews {

    private String url;
    private String booktitle;
    private String bookauthor;
    private String summary;
    private String isbn13;

    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}
    public String getBooktitle() {return booktitle;}
    public void setBooktitle(String booktitle) {this.booktitle = booktitle;}
    public String getBookauthor() {return bookauthor;}
    public void setBookauthor(String bookauthor) {this.bookauthor = bookauthor;}
    public String getSummary() {return summary;}
    public void setSummary(String summary) {this.summary = summary;}
    public String getIsbn13() {return isbn13;}
    public void setIsbn13(String isbn13) {this.isbn13 = isbn13;}

    public Resultsreviews(){this.isbn13 = this.generateIsbn13(13);}

    private synchronized String generateIsbn13(int numChars){
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < numChars){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0,numChars);
    }

    public static Resultsreviews createJson(JsonObject o){
        Resultsreviews rr = new Resultsreviews();
        rr.url = String.format(o.getString("url"));
        rr.booktitle = String.format(o.getString("book_title"));
        rr.bookauthor = String.format(o.getString("book_author"));
        rr.summary = String.format(o.getString("summary"));
        rr.isbn13 = String.format(o.getString("isbn13"));
        return rr;
    }
    
}
