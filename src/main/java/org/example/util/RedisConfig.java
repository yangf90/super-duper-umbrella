package org.example.util;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    /*
     * RedisTemplate是SpringDataRedis中对JedisApi的高度封装，提供了redis各种操作、异常处理及序列化，支持发布订阅。
     *
     * */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory res){
        RedisTemplate<String,Object> rs=new RedisTemplate<>();
        rs.setConnectionFactory(res);
        /*rs.setKeySerializer(new StringRedisSerializer());
        rs.setValueSerializer(new GenericJackson2JsonRedisSerializer());*/
        return  rs;
    }
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        //生成两套默认配置，通过RedisCacheConfiguration对缓存进行自定义配置
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                //设置key的序列化
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                //设置value序列化
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        //返回redis缓存管理器
        RedisCacheManager cacheManager = RedisCacheManager.builder(factory)
                .cacheDefaults(config) //缓存的默认配置为上面自定义的config
                .build();
        return cacheManager;
    }
}
