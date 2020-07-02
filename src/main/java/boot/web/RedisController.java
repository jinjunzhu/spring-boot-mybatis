package boot.web;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("/{key}")
    @ResponseBody
    public String get(@PathVariable String key){
        return (String) redisTemplate.opsForValue().get(key);
    }
}
