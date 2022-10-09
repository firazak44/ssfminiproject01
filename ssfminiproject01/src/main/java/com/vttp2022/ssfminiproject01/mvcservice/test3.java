// package com.vttp2022.ssfminiproject01.mvcservice;

// import java.io.Reader;
// import java.io.StringReader;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Map;

// import javax.annotation.PostConstruct;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;
// import org.springframework.web.util.UriComponentsBuilder;

// import com.vttp2022.ssfminiproject01.mvcmodels.Reviews;

// import jakarta.json.Json;
// import jakarta.json.JsonArray;
// import jakarta.json.JsonObject;
// import jakarta.json.JsonReader;

// @Service
// public class ReviewsSvc {
//     private static final Logger logger = LoggerFactory.getLogger(ReviewsSvc.class);
//     private static String URL = "https://api.nytimes.com/svc/books/v3/reviews";
//     String payload;

//     @Value("${API_KEY}")
//         private String apiKey;
//         private boolean hasKey;
//     @PostConstruct
//         private void init(){hasKey = null != apiKey;
//         logger.info(">>> API KEY set : "  + hasKey);}

//     public List<Reviews> getReviews(){
//         String nytrvURL = UriComponentsBuilder.fromUriString(URL)
//             .query("title=")
//             .query("author=")
//             .queryParam("api-key", apiKey)
//             .toUriString();
//         logger.info(">>> Complete NYT URI API address  : "  + nytrvURL);

//         RestTemplate template = new RestTemplate();
//         ResponseEntity<String> resp;
//         HttpHeaders headers = new HttpHeaders();
//         // headers.setContentType(MediaType.APPLICATION_JSON);
//         HttpEntity<String> entity = new HttpEntity<String>(headers);
//         resp = template.exchange(nytrvURL, HttpMethod.GET, entity, String.class);
//         payload = resp.getBody();
//         System.out.println("payload: " + payload);
//         Reader strReader = new StringReader(payload);
//         JsonReader jr = Json.createReader(strReader);
//         JsonObject reviewsResult = jr.readObject();
//         JsonArray result = reviewsResult.getJsonArray("results");
//         List<Reviews> list = new LinkedList<>();
//         for (int i = 0; i < result.size(); i++) {
//             JsonObject jo = result.getJsonObject(i);
//             list.add(Reviews.createJson(jo));
//         }
//         return list;
//     }
// }
