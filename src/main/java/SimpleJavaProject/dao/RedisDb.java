package SimpleJavaProject.dao;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Service
public class RedisDb {

    @Resource(name="redisTemplate")
    private RedisTemplate<String,String> stringRedisTemplate;

    private RedisConnection redisConnection;

    @PostConstruct
    private void init()
    {
        redisConnection = stringRedisTemplate.getConnectionFactory().getConnection();
    }
    public void setData(String key,String value) {
        redisConnection.
                set(key.getBytes(StandardCharsets.UTF_8),value.getBytes(StandardCharsets.UTF_8));
    }

    public String getData(String key)
    {
         if( redisConnection.get(key.getBytes(StandardCharsets.UTF_8)) == null)
         {
             redisConnection.set(key.getBytes(StandardCharsets.UTF_8),"0".getBytes(StandardCharsets.UTF_8));
         }
        return new String(redisConnection.
                get(key.getBytes(StandardCharsets.UTF_8)));
    }
}
