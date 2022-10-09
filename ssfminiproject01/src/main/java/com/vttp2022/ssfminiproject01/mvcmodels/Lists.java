package com.vttp2022.ssfminiproject01.mvcmodels;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Component
public class Lists implements Serializable{
    private static final long serialVersionUID = 1L;

    // public List<Lists> lists;
    // private ArrayList<HashMap> list;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String[] results;
    private String title;
    private String description;
    private String contributor;
    private String author;
    private String publisher;
    // private String[] isbns;
    // private String isbn10;
    // private String isbn13;
    // private int[] ranks_history;
    // private int rank;
    private String[] reviews;
    private String book_review_link;
    private String id;
    public Lists(){}
    public Lists(String title, String author, String description, 
                String publisher, String contributor, String book_review_link){
        this.title=title;
        this.author = author;
        this.description = description;
        this.publisher = publisher;
        this.contributor = contributor;
        this.book_review_link = book_review_link;
    }
    
    // @Override
    // public String toString() {
    //   return "Lists [title=" + title + ", author=" + author + ", description=" + description
    //       + ", publisher=" + publisher + ", contributor=" + contributor
    //       + ", book_review_link" + book_review_link + "]";
    // }

    // public ArrayList<HashMap> getList() {return list;}
    // public void setList(ArrayList<HashMap> list) {this.list = list;}
    // public List<Lists> getLists() {return lists;}
    // public void setLists(List<Lists> lists) {this.lists = lists;}
    public String[] getResults() {return results;}
    public void setResults(String[] results) {this.results = results;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getContributor() {return contributor;}
    public void setContributor(String contributor) {this.contributor = contributor;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public String getPublisher() {return publisher;}
    public void setPublisher(String publisher) {this.publisher = publisher;}
    // public String[] getIsbns() {return isbns;}
    // public void setIsbns(String[] isbns) {this.isbns = isbns;}
    // public String getIsbn10() {return isbn10;}
    // public void setIsbn10(String isbn10) {this.isbn10 = isbn10;}
    // public String getIsbn13() {return isbn13;}
    // public void setIsbn13(String isbn13) {this.isbn13 = isbn13;}
    // public int[] getRanks_history() {return ranks_history;}
    // public void setRanks_history(int[] ranks_history) {this.ranks_history = ranks_history;}
    // public int getRank() {return rank;}
    // public void setRank(int rank) {this.rank = rank;}
    public String[] getReviews() {return reviews;}
    public void setReviews(String[] reviews) {this.reviews = reviews;}
    public String getBook_review_link() {return book_review_link;}
    public void setBook_review_link(String book_review_link) {this.book_review_link = book_review_link;}
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public static CopyOnWriteArrayList<Lists> createJson(String json) throws IOException{
        CopyOnWriteArrayList<Lists> lists = new CopyOnWriteArrayList<>();
        try (InputStream is = new ByteArrayInputStream(json.getBytes())) {
            JsonReader r = Json.createReader(is);
            JsonObject o = r.readObject();
            JsonArray results = o.getJsonArray("results");
            for (int i = 0; i < results.size(); i++) {
                JsonObject ob = results.getJsonObject(i);
                Lists li = createJson(ob);
                lists.add(li); 
            }
        }
        return lists;
    }
// NullPointerException *https://stackoverflow.com/questions/218384/what-is-a-nullpointerexception-and-how-do-i-fix-it
// The variable can have a default value (and setName can prevent it being set to null):
// private String name = "";
// Either the print or printString method can check for null, for example:
// printString((name == null) ? "" : name);
    private static Lists createJson(JsonObject ob) {
        Lists lbkr = new Lists();
        lbkr.setId(ob.getString("id"));
        JsonObject ob2 = ob.getJsonObject("info");
        lbkr.title = (ob2.getString("title") == null) ? "" : ob2.getString("title");
        lbkr.description = (ob2.getJsonString("description") == null) ? "" : ob2.getString("description");
        lbkr.contributor = (ob2.getJsonString("contributor") == null) ? "" : ob2.getString("contributor");
        lbkr.author = (ob2.getJsonString("author") == null) ? "": ob2.getString("author");
        lbkr.publisher = (ob2.getJsonString("publisher") == null) ? "" : ob2.getString("publisher");

        return lbkr;
    }

    // public static Lists createJson(String title, String description, String contributor, String author, String publisher){
    //     Lists lbkr = new Lists();
    //     lbkr.setTitle(title);
    //     lbkr.setAuthor(author);
    //     lbkr.setDescription(description);
    //     lbkr.setContributor(contributor);
    //     lbkr.setPublisher(publisher);
    //     // lbkr.setTitle(jol.getString("title"));
    //     // lbkr.setDescription(jol.getString("description"));
    //     // lbkr.setContributor(jol.getString("contributor"));
    //     // lbkr.setAuthor(jol.getString("author"));
    //     // lbkr.setPublisher(jol.getString("publisher"));
    //     return lbkr;
    // }

    // public static Lists create(JsonObject jo){
    //     Lists lbkr = new Lists();
    //     lbkr.setTitle(jo.getString("title"));
    //     lbkr.setAuthor(jo.getString("author"));
    //     lbkr.setDescription(jo.getString("description"));
    //     lbkr.setContributor(jo.getString("contributor"));
    //     lbkr.setPublisher(jo.getString("publisher"));
    //     return lbkr;
    // }

    // public static Lists create(String js) {
    //     StringReader strR = new StringReader(js);
    //     JsonReader jsR = Json.createReader(strR);
    //     return create(jsR.readObject());
    // }

    // public JsonObject toJson(){
    //     return Json.createObjectBuilder().add("title", this.title)
    //         .add("author", author)
    //         .add("description", description)
    //         .add("contributor", contributor)
    //         .add("publisher", publisher).build();
    // }
}

