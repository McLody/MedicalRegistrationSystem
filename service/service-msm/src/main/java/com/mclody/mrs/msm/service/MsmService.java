package com.mclody.mrs.msm.service;

import com.mclody.mrs.vo.msm.MsmVo;

public interface MsmService {

//    //发送手机验证码
//    boolean send(String phone, String code);

    String getCode();

    boolean sendEmail(String email, String code);

    boolean send(MsmVo msmVo);
}

