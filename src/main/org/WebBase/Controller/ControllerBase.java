package webbase.controller;

import cms.controller.UserInfoRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import redis.clients.jedis.Jedis;

@Controller
public abstract class ControllerBase {

    public static Logger log = LoggerFactory.getLogger(UserInfoRestController.class);

    @Autowired
    public Jedis redis;

    @Autowired
    public RedisTemplate redisTemplate;

    public ControllerBase() {

    }
}
