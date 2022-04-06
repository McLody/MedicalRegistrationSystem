package com.mclody.mrs.msm.controller;

import com.mclody.mrs.common.result.Result;
import com.mclody.mrs.msm.service.MsmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/msm")
public class MsmApiController {
    @Autowired
    private MsmService msmService;
    @Autowired
    private RedisTemplate redisTemplate;
    //发送手机验证码
//    @GetMapping("send/{phone}")
//    public Result sendCode(@PathVariable String phone) {
//        //从redis获取验证码，如果获取获取到，返回ok
//        // key 手机号  value 验证码
//        String code = (String) redisTemplate.opsForValue().get(phone);
//        if(!StringUtils.isEmpty(code)) {
//            return Result.ok();
//        }
//        //如果从redis获取不到，
//        // 生成验证码，
//        code = msmService.getCode();
//        if (msmService.send(phone,code)){
//            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
//            return Result.ok();
//        }else {
//            return Result.fail();
//        }
//    }

    //发送手机验证码
    @GetMapping("/send/{email}")
    public Result sendEmailCode(@PathVariable String email) {
        //从redis获取验证码，如果获取获取到，返回ok
        // key 手机号  value 验证码
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        String code = (String) redisTemplate.opsForValue().get(email);
        if(!StringUtils.isEmpty(code)) {
            return Result.ok();
        }

        //如果从redis获取不到，
        // 生成验证码，
        code = msmService.getCode();

        if (msmService.sendEmail(email,code)){
            redisTemplate.opsForValue().set(email,code,5, TimeUnit.MINUTES);
            return Result.ok();
        }else {
            return Result.fail();
        }



    }
}

