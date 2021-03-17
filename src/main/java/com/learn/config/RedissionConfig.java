package com.learn.config;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedissionConfig {
        @Autowired
        private RedisProperties redisProperties;

        @Configuration
        @ConditionalOnClass({Redisson.class})
        @ConditionalOnExpression("'${redisson.redis.mode}'=='single'")
        protected class RedissonSingleClientConfiguration {
            /**
             * 单机模式 redisson 客户端
             */
            @Bean
            @ConditionalOnProperty(name = "redisson.redis.mode", havingValue = "single")
            RedissonClient redissonSingle() {
                Config config = new Config();
                String node = redisProperties.getSingle().getAddress();
                node = node.startsWith("redis://") ? node : "redis://" + node;
                SingleServerConfig serverConfig = config.setCodec(new JsonJacksonCodec())
                        .useSingleServer()
                        .setAddress(node)
                        .setTimeout(redisProperties.getConnTimeout())
                        .setConnectionPoolSize(redisProperties.getSize())
                        .setConnectionMinimumIdleSize(redisProperties.getMinIdle());
                if (StringUtils.isNotBlank(redisProperties.getPassword())) {
                    serverConfig.setPassword(redisProperties.getPassword());
                }
                return Redisson.create(config);
            }
        }
    }