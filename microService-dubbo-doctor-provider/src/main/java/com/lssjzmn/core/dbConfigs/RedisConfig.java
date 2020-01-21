package com.lssjzmn.core.dbConfigs;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

//@Configuration
//@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{
	
	 /**
     * RedisConfig logger
     */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;
 
    /**
     * 
     * 注解@Cache的管理器，设置过期时间的单位是秒
     * @Title: cacheManager
     * @author: 谢川立
     * @date 2018年7月27日 下午5:32:28
     * @param redisTemplate
     * @return CacheManager
     */
    @Bean 
    public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        //设置缓存过期时间  秒
        cacheManager.setDefaultExpiration(600);
        return cacheManager;
    }
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
        StringRedisTemplate template = new StringRedisTemplate(factory);
        setSerializer(template);//设置序列化工具
        template.afterPropertiesSet();
        return template;
    }
     private void setSerializer(StringRedisTemplate template){
            @SuppressWarnings({ "rawtypes", "unchecked" })
            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jackson2JsonRedisSerializer.setObjectMapper(om);
            template.setValueSerializer(jackson2JsonRedisSerializer);
     }
     
     /**
      * redis数据操作异常处理 这里的处理：在日志中打印出错误信息，但是放行
      * 保证redis服务器出现连接等问题的时候不影响程序的正常运行，使得能够出问题时不用缓存
      * 
      * @return
      */
     @Bean
     @Override
     public CacheErrorHandler errorHandler() {
         CacheErrorHandler cacheErrorHandler = new CacheErrorHandler() {
			@Override
			public void handleCacheGetError(RuntimeException exception,
					Cache cache, Object key) {
				 RedisErrorException(exception, key);
			}

			@Override
			public void handleCachePutError(RuntimeException exception,
					Cache cache, Object key, Object value) {
				RedisErrorException(exception, key);
			}

			@Override
			public void handleCacheEvictError(RuntimeException exception,
					Cache cache, Object key) {
				RedisErrorException(exception, key);
			}

			@Override
			public void handleCacheClearError(RuntimeException exception,
					Cache cache) {
				RedisErrorException(exception, null);
			}
             
         };
         return cacheErrorHandler;
     }
     
     protected void RedisErrorException(Exception exception,Object key){
         logger.error("redis异常：key=[{}]", key, exception);
     }
}