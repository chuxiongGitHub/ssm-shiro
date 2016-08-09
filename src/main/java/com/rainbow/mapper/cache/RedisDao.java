package com.rainbow.mapper.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.rainbow.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by rainbow on 2016/8/9.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class RedisDao {
    private static Logger logger = LoggerFactory.getLogger(RedisDao.class);

    private JedisPool jedisPool;

    private RuntimeSchema<User> schema = RuntimeSchema.createFrom(User.class);

    public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }

    //获取对象
    public User getUser(long userId) {
        //redis逻辑操作
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "user:" + userId;
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes == null) {
                    //空对象
                    User user = schema.newMessage();
                    ProtobufIOUtil.mergeFrom(bytes, user, schema);
                    //seckill被反序列化
                    return user;
                }

            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //将获取到的对象插入到redis中
    public String putUser(User user) {
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "user:" + user.getUserId();
                byte[] bytes = ProtobufIOUtil.toByteArray(user, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));

                //调用set方法
                //超时缓存
                int timeout = 60 * 60;
                String result = jedis.setex(key.getBytes(), timeout, bytes);

                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
