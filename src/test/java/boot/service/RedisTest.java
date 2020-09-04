package boot.service;

import boot.support.AbstractSpringbootTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

public class RedisTest extends AbstractSpringbootTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void testGet(){
        //Assert.assertEquals(redisTemplate.opsForValue().get("zhujinjun"), "123456");
        redisTemplate.opsForValue().set("foo", "12345678");
        System.out.println(redisTemplate.opsForValue().get("foo"));
    }
}
