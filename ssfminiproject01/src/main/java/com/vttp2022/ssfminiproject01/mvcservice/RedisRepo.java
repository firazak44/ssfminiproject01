package com.vttp2022.ssfminiproject01.mvcservice;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.vttp2022.ssfminiproject01.mvcmodels.Lists;
import com.vttp2022.ssfminiproject01.mvcmodels.User;

@Repository
public class RedisRepo{
    private User user;
    private String username;
    private CopyOnWriteArrayList<Lists> lookuplists = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Lists> addtolists = new CopyOnWriteArrayList<>();

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public RedisRepo(){}
    // public RedisRepo (String username) {this.username = username;}
    public void save(User user) { //save user into redis
        redisTemplate.opsForValue().set(user.getUsername(), user);
    }
    // Results result = (Results) redisTemplate.opsForValue().get(nrs.getId());
    // if (result != null)
    //     return 1;
    // return 0;

    public Lists getLisResults(String username) { //get list from user redis
        Lists lists = (Lists) redisTemplate.opsForValue().get(username);
        return lists;
    }

    public User getUser(String username) {
        User result = null;
        Set<String> searchKeys = redisTemplate.keys("*");
        if (searchKeys.contains(username)){
            result = (User) redisTemplate.opsForValue().get(username);    
        }
        // redisTemplate.opsForValue().get(username);
        // public Set<String> searchKeys(String index) {
        //     String pattern = "*%s*".formatted(index);
        //     return redisTemplate.keys(pattern);
        // }
        return result;
    }

    public CopyOnWriteArrayList<Lists> getLookuplists() {
        return lookuplists;
    }
    public void setLookuplists(CopyOnWriteArrayList<Lists> lists) {
        this.lookuplists = lists;
    }
    public CopyOnWriteArrayList<Lists> getAddtolists() {
        return addtolists;
    }
    public void setAddtolists(CopyOnWriteArrayList<Lists> addtolists) {
        this.addtolists = addtolists;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    // public int update(Results nrs) {
        
    //     logger.info("Save results > " + logger);
    //     if (nrs.isChecksum())
    //         redisTemplate.opsForValue().setIfAbsent(nrs.getId(), nrs);
    //     else
    //         redisTemplate.opsForValue().setIfPresent(nrs.getId(), nrs);
    //     Results result = (Results) redisTemplate.opsForValue().get(nrs.getId());
    //     if (result != null)
    //         return 1;
    //     return 0;
    // }

}
