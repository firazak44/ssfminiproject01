package com.vttp2022.ssfminiproject01.mvcservice;

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

@Service
public class ListsSvc {
    private static final Logger logger = LoggerFactory.getLogger(ListsSvc.class);
    private static String URL = "https://api.nytimes.com/svc/books/v3/lists/best-sellers/history.json" + "?api-key=pjo1HY9s2wXBLV8ftGikAhxH9PdVhlgY";
    // private static final String API_KEY = System.getenv("API_KEY");
    private CopyOnWriteArrayList<Lists> lists= new CopyOnWriteArrayList<>();
    private String username;
    public String lookup;

    
    @Value("${API_KEY}")
    private String apiKey;
    private boolean hasKey;
    
    @PostConstruct
    private void init(){hasKey = null != apiKey;
    logger.info(">>> API KEY set : "  + hasKey);}

    //Call Api//
    public CopyOnWriteArrayList<Lists> getLists(String looKup) {
        this.lookup = looKup;
        String nytrvURL = UriComponentsBuilder.fromUriString(URL)
            .query("title=" + looKup)
            .query("author=" + looKup)
            .query("isbn=" + looKup)
            .query("publisher=" + looKup)
            .toUriString();
        logger.info(">>> Complete NYT URI API address  : "  + nytrvURL);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> respEnt = template.getForEntity(nytrvURL, String.class);
        CopyOnWriteArrayList<Lists> lists = new CopyOnWriteArrayList<>();
            try {
                // respEnt = template.getForEntity(URL, String.class);
                lists = Lists.createList(respEnt.getBody());
            } catch (Exception e) {
                e.printStackTrace();}
        return lists;  
    }

    // @Autowired(required=!true)
    // RedisTemplate<String, Object> template;
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
