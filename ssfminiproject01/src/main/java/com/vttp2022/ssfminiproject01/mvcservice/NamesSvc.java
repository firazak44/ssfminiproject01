package com.vttp2022.ssfminiproject01.mvcservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vttp2022.ssfminiproject01.mvcmodels.Names;
import com.vttp2022.ssfminiproject01.mvcmodels.Results;

@Service
public class NamesSvc {
    private static final Logger logger = LoggerFactory.getLogger(NamesSvc.class);
    
    private JSONObject jo;
    private JSONArray ja;
    private Results[] resultsArray;
    private Names names = new Names();
    private RestTemplate template = new RestTemplate();

    @Value("${API_KEY}")
        private String apiKey;
        private boolean hasKey;
    @PostConstruct
        private void init(){hasKey = null != apiKey;
        logger.info(">>> API KEY set : "  + hasKey);}

    public Names getNameLists() throws Exception{

        List<Names> topList = new ArrayList<>();
        
        String URL = "https://api.nytimes.com/svc/books/v3/lists/names";

        String nytURL = UriComponentsBuilder.fromUriString(URL) //create URL with query
            .queryParam("list")
            .queryParam("api-key", apiKey)
            .toUriString();
        logger.info(">>> Complete NYT URI API address  : "  + nytURL);
        
        HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<Map> namesList = template.exchange(nytURL, HttpMethod.GET, entity,Map.class);
        if (namesList.getStatusCode()==HttpStatus.OK){
            jo = new JSONObject(namesList.getBody());
            names.setStatus(jo.getString("status"));
            names.setCopyright(jo.getString("copyright"));
            
            ja = jo.getJSONArray("results");
            resultsArray = new Results[ja.length()];
            for(int i=0; i<ja.length(); i++) {
                resultsArray[i]=new Results();
                resultsArray[i].setDisplayName(ja.getJSONObject(i).getString("display_name"));
                resultsArray[i].setOldestPublishedDate(ja.getJSONObject(i).getString("oldest_published_date"));
                resultsArray[i].setNewestPublishedDate(ja.getJSONObject(i).getString("newest_published_date"));
                resultsArray[i].setUpdate(ja.getJSONObject(i).getString("updated"));
                names.setResults(resultsArray);
                topList.add(names);
            }
        }
        return topList.get(0);
    }
}

