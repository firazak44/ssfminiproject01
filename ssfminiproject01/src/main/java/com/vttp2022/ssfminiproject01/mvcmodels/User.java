package com.vttp2022.ssfminiproject01.mvcmodels;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String username;
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
    public User() {
        this.id = generateId(8);
    }
    private String generateId(int i) {
        Random ranD = new Random();
        StringBuilder stringB = new StringBuilder();
        while (stringB.length() < i) {
            stringB.append(Integer.toHexString(ranD.nextInt()));
        } return id;
    }
    public User(String user) {
        this.id = generateId(8);
        this.username = user;
    }

    // private CopyOnWriteArrayList<Lists> lists = new CopyOnWriteArrayList<>();
    // private CopyOnWriteArrayList<Lists> listsadd;
    // public CopyOnWriteArrayList<Lists> getLists() {
    //     return lists;
    // }
    // public void setLists(CopyOnWriteArrayList<Lists> lists) {
    //     this.lists = lists;
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
