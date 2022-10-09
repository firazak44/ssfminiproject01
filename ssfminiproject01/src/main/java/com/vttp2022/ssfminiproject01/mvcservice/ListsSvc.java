package com.vttp2022.ssfminiproject01.mvcservice;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.redis.core.RedisTemplate;
import com.vttp2022.ssfminiproject01.mvcmodels.Lists;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class ListsSvc {
    private static final Logger logger = LoggerFactory.getLogger(ListsSvc.class);
    private static String URL = "https://api.nytimes.com/svc/books/v3/lists/best-sellers/history.json";
    // private static final String API_KEY = System.getenv("API_KEY");
    // private CopyOnWriteArrayList<Lists> lists= new CopyOnWriteArrayList<>();
    public String lookup;
    private String username;
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    @Autowired(required=!true)
    RedisTemplate<String, Object> template;

    @Value("${API_KEY}")
    private String apiKey;
    private boolean hasKey;
    
    @PostConstruct
    private void init(){hasKey = null != apiKey;
    logger.info(">>> API KEY set : "  + hasKey);}

    //Call Api//
    public CopyOnWriteArrayList<Lists> getLists(String keywords) {
    this.lookup = keywords;
        String nytURL = UriComponentsBuilder.fromUriString(URL)
            .queryParam("api-key", apiKey)
            .queryParam("title" , keywords)
            .toUriString();
        logger.info(">>> Complete NYT URI API address  : "  + nytURL);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> respEnt = null;
        CopyOnWriteArrayList<Lists> lists = new CopyOnWriteArrayList<>();
            try {
                respEnt = template.getForEntity(URL, String.class);
                lists = Lists.createJson(respEnt.getBody());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return lists;  
        }

        // public String getList(){
        //     Set<String> userList = template.keys("*");
        //     StringBuilder strB= new StringBuilder();
        //     for (String username:userList){
        //         strB.append(username +"\n");
        //     }
        //     String list = strB.substring(0, strB.length()-1).toString();
        //     return list;
        // }
    
    //     String payload = respEnt.getBody();
    //     Reader strR = new StringReader(payload);
    //     JsonReader jsR = Json.createReader(strR);
    //     JsonObject listsRes = jsR.readObject();
    //     JsonArray listsData = listsRes.getJsonArray("results");
    //     ArrayList<Lists> list = new ArrayList<>();
    //     for (int i = 0; i < listsData.size(); i++) {
    //         JsonObject jo = listsData.getJsonObject(i);
    //         JsonObject info =jo.getJsonObject("info");
    //         String title =info.getString("title");
    //         String author =info.getString("author");
    //         String description =info.getString("description");
    //         String contributor =info.getString("contributor");
    //         String publisher = info.getString("publisher");
    //         list.addAll(Lists.createList(title,author,description,contributor,publisher));
    //     }
    //     return list;  
    // }

    // public String getList(){
    //     Set<String> usernameList = template.keys("*");
    //     StringBuilder stringB= new StringBuilder();
    //     for (String username:usernameList){
    //         stringB.append(username +"\n");
    //     }String list = stringB.substring(0, stringB.length()-1).toString();
    //     return list;
    // }

    // public void addLists(String save, CopyOnWriteArrayList<Lists> lookup) {
    //     Lists lists = new Lists();
    //     for (Lists i : lookup) {
    //         if (String.valueOf(i.getId()).equals(save)) {
    //             lists = i;
    //             // for (Lists lists2: listsadd){
    //                 // if(lists2.getId() == lists.getId()){
    //                 //     return;}
    //             // }
    //         }listsadd.add(lists);
    //     }
    // }
}
