package com.vttp2022.ssfminiproject01.mvcservice;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vttp2022.ssfminiproject01.mvcmodels.Names;

@Service
public class NamesSvc {
    private static final Logger logger = LoggerFactory.getLogger(NamesSvc.class);
    private static String URL = "https://api.nytimes.com/svc/books/v3/lists.json";

    @Value("${api-key}")
    private static String apiKey;
    private boolean hasKey;
    @PostConstruct
    private void init(){hasKey = null != apiKey;
        logger.info(">>> API KEY set : "  + hasKey);}

    public Optional<Names> getNames(){
        String namesUrl = UriComponentsBuilder.fromUriString(URL)
            .queryParam("updated", "MONTHLY")
            .queryParam("api-key", apiKey)
            .toUriString();


        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = null;

        try{
            resp = template.getForEntity(namesUrl, String.class);
            Names n = Names.createJson(resp.getBody());
            return Optional.of(n);
        }catch(Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
