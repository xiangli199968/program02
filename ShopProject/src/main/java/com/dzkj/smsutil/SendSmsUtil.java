package com.dzkj.smsutil;
import java.util.Random;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SendSmsUtil {

	  /***
	   * 阿里云短信平台发送验证码短信
	   * @param phone：接收验证码短信的手机号码
	   * @return:返回短信验证码
	   */
	  public static String sendCheckMSM(String phone) {
		  	DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIv2rhuqp47t4H", "9zPk2e6Mdi27McUVqQRhlZAdJoDIAy");
	        IAcsClient client = new DefaultAcsClient(profile);
	        CommonRequest request = new CommonRequest();
	        request.setMethod(MethodType.POST);
	        request.setDomain("dysmsapi.aliyuncs.com");
	        request.setVersion("2017-05-25");
	        request.setAction("SendSms");
	        request.putQueryParameter("RegionId", "cn-hangzhou");
	        request.putQueryParameter("PhoneNumbers", phone);// 手机号码
	        request.putQueryParameter("SignName", "爱豆小小只");// 签名名称
	        request.putQueryParameter("TemplateCode", "SMS_171858681");//模板CODE
	        // 随机生成6为数字的验证码
	        String code = "";
	        Random ran = new Random();
	        for (int i = 1; i <= 6; i++) {
	        	int num = ran.nextInt(10);
	        	code+=num;
			}
	        request.putQueryParameter("TemplateParam", "{'code':'"+code+"'}");// 验证码内容,格式：{'模板中变量的名字':'值'}
	        try {
	            CommonResponse response = client.getCommonResponse(request);
	            System.out.println(response.getData());
	        } catch (ServerException e) {
	            e.printStackTrace();
	        } catch (ClientException e) {
	            e.printStackTrace();
	        }
	        return code;
	    }
	  
	  /***
	       *  【项目未上线，不可用短信通知】
	       *  阿里云短信平台发送下单短信通知
	   * @param phone：接收验证码短信的手机号码
	   * @param username：下单用户名
	   * @return:返回验证码
	   */
	  public static void sendOrderMSM(String phone,String username) {
		  	DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIqB4fBsXSjqQx", "gWP0LI9Zkm4abOTWkCrzsCxp7wEPZc");
	        IAcsClient client = new DefaultAcsClient(profile);
	        CommonRequest request = new CommonRequest();
	        request.setMethod(MethodType.POST);
	        request.setDomain("dysmsapi.aliyuncs.com");
	        request.setVersion("2017-05-25");
	        request.setAction("SendSms");
	        request.putQueryParameter("RegionId", "cn-hangzhou");
	        request.putQueryParameter("PhoneNumbers", phone);// 手机号码
	        request.putQueryParameter("SignName", "电科快乐购");// 签名名称
	        request.putQueryParameter("TemplateCode", "SMS_168730362");//模板CODE
	        request.putQueryParameter("TemplateParam", "{'name':'"+username+"'}");// 验证码内容,以json格式传递,键为模板中的名字
	        try {
	            CommonResponse response = client.getCommonResponse(request);
	            System.out.println(response.getData());
	        } catch (ServerException e) {
	            e.printStackTrace();
	        } catch (ClientException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  /***
	       *  【项目未上线，不可用短信通知】
	       *  阿里云短信平台发送收货短信通知
	   * @param phone：接收验证码短信的手机号码
	   * @param username：收货用户名
	   * @return:返回验证码
	   */
	  public static void sendReceiveMSM(String phone,String username) {
		  	DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIqB4fBsXSjqQx", "gWP0LI9Zkm4abOTWkCrzsCxp7wEPZc");
	        IAcsClient client = new DefaultAcsClient(profile);
	        CommonRequest request = new CommonRequest();
	        request.setMethod(MethodType.POST);
	        request.setDomain("dysmsapi.aliyuncs.com");
	        request.setVersion("2017-05-25");
	        request.setAction("SendSms");
	        request.putQueryParameter("RegionId", "cn-hangzhou");
	        request.putQueryParameter("PhoneNumbers", phone);// 手机号码
	        request.putQueryParameter("SignName", "电科快乐购");// 签名名称
	        request.putQueryParameter("TemplateCode", "SMS_168730401");//模板CODE
	        request.putQueryParameter("TemplateParam", "{'name':'"+username+"'}");// 验证码内容,以json格式传递,键为模板中的名字
	        try {
	            CommonResponse response = client.getCommonResponse(request);
	            System.out.println(response.getData());
	        } catch (ServerException e) {
	            e.printStackTrace();
	        } catch (ClientException e) {
	            e.printStackTrace();
	        }
	    }
}
