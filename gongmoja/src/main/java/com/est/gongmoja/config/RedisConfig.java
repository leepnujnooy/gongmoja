package com.est.gongmoja.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 30)
public class RedisConfig {

    @Value("${spring.data.redis.port}")
    private int port;

    @Value("${spring.data.redis.host}")
    private String host;

//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory(host,port);
//    }
    @Bean
    public RedisConnectionFactory lettuceConnectionFactory() {
        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration(host, port);
        return new LettuceConnectionFactory(standaloneConfiguration);
    }

    @Bean
    public RedisTemplate<String,String> redisTemplate(){

        // 템플릿이 redis 에서 하나의 객체역할
        // Key : String (유저이름)
        // Value : String (refreshToken)
        RedisTemplate<String , String> redisTemplate = new RedisTemplate<>();

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setConnectionFactory(lettuceConnectionFactory());

        return redisTemplate;
    }

}
