package com.vttp2022.ssfminiproject01.mvcservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.vttp2022.ssfminiproject01.mvcmodels.Lists;
import com.vttp2022.ssfminiproject01.mvcmodels.User;

@Repository
public class RedisRepo implements RedisSaveIntf{
    private User user;
    private CopyOnWriteArrayList<Lists> lookuplists = new CopyOnWriteArrayList<>();

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    // public interface RedisSaveIntf {
    //     public void save(String username , Lists model);
    // }

    public void saveLists(String username,Lists model) { //save user into redis
        redisTemplate.opsForValue().set(username, model);
    }
    // Results result = (Results) redisTemplate.opsForValue().get(nrs.getId());
    // if (result != null)
    //     return 1;
    // return 0;

    public Lists getLisResults(String username) { //get objectlist from user redis
        Lists lists = (Lists) redisTemplate.opsForValue().get(username);
        return lists;
    }

    public User getUsername(User username) {
        return username;
    }

    public CopyOnWriteArrayList<Lists> getLookuplists() {
        return lookuplists;
    }
    public void setLookuplists(CopyOnWriteArrayList<Lists> lists) {
        this.lookuplists = lists;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    
    // public Set<String> searchKeys(String index) {
    //     String pattern = "*%s*".formatted(index);
    //     return redisTemplate.keys(pattern);
    // }

}
