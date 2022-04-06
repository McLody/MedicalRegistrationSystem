package com.mclody.mrs.msm.service.impl;

import com.mclody.mrs.msm.service.MsmService;
import com.mclody.mrs.vo.msm.MsmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


@Service
public class MsmServiceImpl implements MsmService {

    @Autowired
    JavaMailSenderImpl javaMailSender;

//    @Override
//    public boolean send(String phone, String code) {
//        //判断手机号是否为空
//        if(StringUtils.isEmpty(phone)) {
//            return false;
//        }
//        //整合阿里云短信服务
//        //设置相关参数
//        DefaultProfile profile = DefaultProfile.
//                getProfile(ConstantPropertiesUtils.REGION_Id,
//                        ConstantPropertiesUtils.ACCESS_KEY_ID,
//                        ConstantPropertiesUtils.SECRECT);
//        IAcsClient client = new DefaultAcsClient(profile);
//        CommonRequest request = new CommonRequest();
//        //request.setProtocol(ProtocolType.HTTPS);
//        request.setMethod(MethodType.POST);
//        request.setDomain("dysmsapi.aliyuncs.com");
//        request.setVersion("2017-05-25");
//        request.setAction("SendSms");
//
//        //手机号
//        request.putQueryParameter("PhoneNumbers", phone);
//        //签名名称
//        request.putQueryParameter("SignName", "我的谷粒在线教育网站");
//        //模板code
//        request.putQueryParameter("TemplateCode", "SMS_180051135");
//        //验证码  使用json格式   {"code":"123456"}
//        Map<String,Object> param = new HashMap();
//        param.put("code",code);
//        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));
//
//        //调用方法进行短信发送
//        try {
//            CommonResponse response = client.getCommonResponse(request);
//            System.out.println(response.getData());
//            return response.getHttpResponse().isSuccess();
//        } catch (ServerException e) {
//            e.printStackTrace();
//        } catch (ClientException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    @Override
    public String getCode() {
        int random = (int) (Math.random() * 1000000);
        System.out.println(random);
        String code = String.format("%06d", random);
        System.out.println(code);
        return code;
    }

    @Override
    public boolean sendEmail(String email, String code) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("尚医通项目登录验证码");
        simpleMailMessage.setText("尊敬的:"+email+"您的注册校验验证码为：" + code + "有效期5分钟");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("863122445@qq.com");
        javaMailSender.send(simpleMailMessage);
        return true;
    }

    @Override
    public boolean send(MsmVo msmVo) {
        if(!StringUtils.isEmpty(msmVo.getPhone())) {
//            String code = (String)msmVo.getParam().get("code");
//            return this.send(msmVo.getPhone(),code);
        }
        log.println("我发邮件了");
        return true;
    }

}



