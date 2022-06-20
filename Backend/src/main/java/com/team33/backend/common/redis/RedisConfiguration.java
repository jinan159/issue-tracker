package com.team33.backend.common.redis;

import com.team33.backend.emoji.controller.dto.cache.CommentCache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Bean
    public RedisTemplate<String, CommentCache> emotionCacheRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, CommentCache> emotionCacheRedisTemplate = new RedisTemplate<>();
        emotionCacheRedisTemplate.setKeySerializer(new StringRedisSerializer());
        emotionCacheRedisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        emotionCacheRedisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        emotionCacheRedisTemplate.setConnectionFactory(redisConnectionFactory);
        emotionCacheRedisTemplate.afterPropertiesSet();
        return emotionCacheRedisTemplate;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisHost);
        redisStandaloneConfiguration.setPort(redisPort);
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }
}
