package com.vttp2022.ssfminiproject01.mvcservice;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

import com.vttp2022.ssfminiproject01.mvcmodels.Results;

public class Redis implements Repo {
    private static final Logger logger = LoggerFactory.getLogger(Redis.class);
    
    @Autowired
    @Qualifier("books")
    RedisTemplate<String, Results> redisTemplate;
    
    @Override
    public int save(Results nrs) {
        logger.info("Save results > " + logger);
        redisTemplate.opsForValue().set(nrs.getId(), nrs);
        Results result = (Results) redisTemplate.opsForValue().get(nrs.getId());
        if (result != null)
            return 1;
        return 0;
    }

    @Override
    public Results findById(String nrsId) {
        logger.info("find results by id> " + nrsId);
        Results result = (Results) redisTemplate.opsForValue().get(nrsId);
        return result;
    }

    @Override
    public int update(Results nrs) {
        logger.info("Save results > " + logger);
        if (nrs.isChecksum())
            redisTemplate.opsForValue().setIfAbsent(nrs.getId(), nrs);
        else
            redisTemplate.opsForValue().setIfPresent(nrs.getId(), nrs);
        Results result = (Results) redisTemplate.opsForValue().get(nrs.getId());
        if (result != null)
            return 1;
        return 0;
    }
    
    public Set<String> searchKeys(String index) {
        String pattern = "*%s*".formatted(index);
        return redisTemplate.keys(pattern);
    }
}
