package top.coolidea.security.demo.common;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author: 魏薏恩
 * @date: 2019/3/4 09:44
 * @description: Redis操作类
 */
@Slf4j
@Component
public class RedisUtils {
    private static final String NULL = "null";
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 检查是否有值存在
     *
     * @param key
     * @return
     */
    public boolean contains(String key) {
        return !StrUtil.isBlankIfStr(redisTemplate.opsForValue().get(key));
    }

    /**
     * 设置列表项目
     *
     * @param key   关键字
     * @param value 对象
     */
    public void push(String key, Object value) {
        log.info("set list:" + key + ";value:" + value);
        redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 获取列表头部对象
     *
     * @param key
     * @return
     */
    public Object pop(String key) {
        log.info("get list:" + key);
        Object object = redisTemplate.opsForList().leftPop(key);
        return object;
    }

    /**
     * 设置缓存值
     *
     * @param key   缓存关键字
     * @param value 缓存值
     */
    public void setValue(String key, Object value) {
        log.info("SETVALUE key:" + key + ";value:" + value);
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置缓存值,带过期时间,默认单位秒
     *
     * @param key   缓存关键字
     * @param value 缓存值
     * @param time  秒数
     */
    public void setValue(String key, Object value, Long time) {
        log.info("SETVALUE key:" + key + ";value:" + value);
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    /**
     * 设置缓存值,带过期时间,自定义单位
     *
     * @param key      缓存关键字
     * @param value    缓存值
     * @param time     时长
     * @param timeUnit 时间单位
     */
    public void setValue(String key, Object value, Long time, TimeUnit timeUnit) {
        log.info("SETVALUE key:" + key + ";value:" + value);
        redisTemplate.opsForValue().set(key, value, time, timeUnit);
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param time
     * @param timeUnit
     */
    public void expire(String key, Long time, TimeUnit timeUnit) {
        this.redisTemplate.expire(key, time, timeUnit);
    }

    /**
     * 删除缓存
     *
     * @param key 缓存关键字
     */
    public void deleteValue(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
    }

    /**
     * 获取缓存
     *
     * @param key 缓存关键字
     * @return 获取到的缓存字符串
     */
    public String getValue(String key) {
        String result = String.valueOf(redisTemplate.opsForValue().get(key));
        //redis获取的一个不存在的键时值为"null",Hutool工具包的检查中没有包含此项检查
        if (StrUtil.isEmpty(result) || NULL.equals(result)) {
            return null;
        }
        log.info("GETVALUE key:" + key + ";value:" + result);
        result.replace("\r\n", "");
        return result;
    }

    /**
     * 获取缓存
     *
     * @param key 缓存关键字
     * @return 获取到的缓存字符串
     */
    public Object getBaseObjectValue(String key) {
        Object result = redisTemplate.opsForValue().get(key);
        if (result == null || NULL.equals(result)) {
            return null;
        }
        return result;
    }

}
