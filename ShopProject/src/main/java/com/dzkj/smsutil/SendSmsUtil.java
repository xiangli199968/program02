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
	   * �����ƶ���ƽ̨������֤�����
	   * @param phone��������֤����ŵ��ֻ�����
	   * @return:���ض�����֤��
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
	        request.putQueryParameter("PhoneNumbers", phone);// �ֻ�����
	        request.putQueryParameter("SignName", "����ССֻ");// ǩ������
	        request.putQueryParameter("TemplateCode", "SMS_171858681");//ģ��CODE
	        // �������6Ϊ���ֵ���֤��
	        String code = "";
	        Random ran = new Random();
	        for (int i = 1; i <= 6; i++) {
	        	int num = ran.nextInt(10);
	        	code+=num;
			}
	        request.putQueryParameter("TemplateParam", "{'code':'"+code+"'}");// ��֤������,��ʽ��{'ģ���б���������':'ֵ'}
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
	       *  ����Ŀδ���ߣ������ö���֪ͨ��
	       *  �����ƶ���ƽ̨�����µ�����֪ͨ
	   * @param phone��������֤����ŵ��ֻ�����
	   * @param username���µ��û���
	   * @return:������֤��
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
	        request.putQueryParameter("PhoneNumbers", phone);// �ֻ�����
	        request.putQueryParameter("SignName", "��ƿ��ֹ�");// ǩ������
	        request.putQueryParameter("TemplateCode", "SMS_168730362");//ģ��CODE
	        request.putQueryParameter("TemplateParam", "{'name':'"+username+"'}");// ��֤������,��json��ʽ����,��Ϊģ���е�����
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
	       *  ����Ŀδ���ߣ������ö���֪ͨ��
	       *  �����ƶ���ƽ̨�����ջ�����֪ͨ
	   * @param phone��������֤����ŵ��ֻ�����
	   * @param username���ջ��û���
	   * @return:������֤��
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
	        request.putQueryParameter("PhoneNumbers", phone);// �ֻ�����
	        request.putQueryParameter("SignName", "��ƿ��ֹ�");// ǩ������
	        request.putQueryParameter("TemplateCode", "SMS_168730401");//ģ��CODE
	        request.putQueryParameter("TemplateParam", "{'name':'"+username+"'}");// ��֤������,��json��ʽ����,��Ϊģ���е�����
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
