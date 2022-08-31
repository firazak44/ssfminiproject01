package com.vttp2022.ssfminiproject01.mvcmodels;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;

public class Query {
    private int isbn;
    private String title;
    private String author;
    public int getIsbn() {return isbn;}
    public void setIsbn(int isbn) {this.isbn = isbn;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    private static final Logger logger = LoggerFactory.getLogger(Query.class);
    public static Query createJson(JsonObject o){
        logger.info("createJson query");
        Query q = new Query();
        JsonObject queryObject = o.getJsonObject("query");
        JsonNumber jsNum = queryObject.getJsonNumber("isbn");
        q.isbn = jsNum.intValue();
        String titleString = queryObject.getString("title");
        q.title = titleString;
        String authorString = queryObject.getString("author");
        q.author = authorString;

        return q;
    }
}
