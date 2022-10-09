package com.vttp2022.ssfminiproject01.mvccontroller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vttp2022.ssfminiproject01.mvcmodels.Lists;
import com.vttp2022.ssfminiproject01.mvcmodels.User;
import com.vttp2022.ssfminiproject01.mvcservice.ListsSvc;
import com.vttp2022.ssfminiproject01.mvcservice.RedisRepo;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;

@RestController
@RequestMapping("/")
public class ListsRESTCtrl {

    @Autowired
    RedisRepo redisRepo;

    @Autowired
    ListsSvc listsSvc;

    @Autowired
    User user;

    // @GetMapping(value = "/api/user/{username}",produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<User> getLists(@PathVariable String username) throws IOException {
    //     User user = redisRepo.getUserbyUsername(username);
    //     if (((Map<String, JsonValue>) user).isEmpty()) {
    //         return (ResponseEntity<User>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    //     }
    //     return ResponseEntity.ok(user);
    // }

    // @GetMapping(value="/search/{searchKeyword}", produces= MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<CopyOnWriteArrayList<Lists>> searchResults(@PathVariable String lookup) throws IOException {
    //     CopyOnWriteArrayList<Lists> listsS = listsSvc.getLists(lookup);
    //     if (listsS == null) {
    //         return ResponseEntity.status(504).build();
    //     }
    //     return ResponseEntity.ok(listsS);
    // }
}