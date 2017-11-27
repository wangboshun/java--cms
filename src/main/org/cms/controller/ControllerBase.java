package cms.controller;

import cms.controller.admin.UserInfoController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerBase {
    public static Logger log = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    public Jedis redis;

    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    public HttpServletRequest request;

    @Autowired
    public HttpServletResponse response;
}
