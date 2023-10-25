package org.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public boolean set(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
        return true;
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
    /**
     * 删除key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
