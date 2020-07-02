package boot.redis;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;


}
