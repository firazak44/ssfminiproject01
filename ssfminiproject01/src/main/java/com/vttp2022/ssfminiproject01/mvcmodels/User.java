package com.vttp2022.ssfminiproject01.mvcmodels;

import java.io.Serializable;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Component
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;
    private String username;
    private CopyOnWriteArrayList<Lists> listsBk = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<Lists> getListsBk() {
        return listsBk;
    }
    public void setListsBk(CopyOnWriteArrayList<Lists> listsBk) {
        this.listsBk = listsBk;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    private String generateId(int i) {
        Random ranD = new Random();
        StringBuilder stringB = new StringBuilder();
        while (stringB.length() < i) {
            stringB.append(Integer.toHexString(ranD.nextInt()));
        } return id;
    }
    public User() {
        this.id = generateId(8);
    }
    public User(String user) {
        this.id = generateId(8);
        this.username = user;
    }
    public void addBk(String add, CopyOnWriteArrayList<Lists> lookup){
        Lists lists = new Lists();
        for(Lists li : lookup){
            if(String.valueOf(li.getId()).equals(add)){
                lists = li;
                for(Lists l: listsBk){
                    if(l.getId() == lists.getId()){
                        return;
                    }
                }
                listsBk.add(lists);
            }
        }
    }
    
    public void removeBk(String remove){
        for(Lists lists: listsBk){
            if(String.valueOf(lists.getId()).equals(remove)){
                listsBk.remove(lists);
            }
        }
    }

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
