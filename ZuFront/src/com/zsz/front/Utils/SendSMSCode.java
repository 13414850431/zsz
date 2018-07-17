package com.zsz.front.Utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zsz.tools.CommonUtils;
import com.zsz.tools.VerifyCodeUtils;

public class SendSMSCode {
	//发送验证码的请求路径URL
	private static final String SERVER_URL = "https://api.netease.im/sms/sendcode.action";
	
	//网易云信分配的账号
	private static final String 
    APP_KEY="32cff450f69c6b6ee8075134060070f4";

	//网易云信分配的密钥
	private static final String APP_SECRET = "7dbccd7f1cef";
	
	private static String NONCE ;//短信的验证码
	
	//短信模板
	private static String TEMPLATEID;
	
	//验证码长度，范围4～10，默认为4
	private static final String CODELEN="6";
	
	private static String authCode  ;

   
    public static SMSResult sendCode(String phoneNum){
    	
    	//短信模板
    	TEMPLATEID = "4022693";
    	
    	
    	NONCE = "123456";//
    	
    	authCode  = VerifyCodeUtils.generateSMSCode(6);

		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		CloseableHttpResponse response = null;
		    
	    HttpPost httpPost = new HttpPost(SERVER_URL);
	    
	    String curTime = String.valueOf((new Date()).getTime()/1000L);
	    
	    /*
	     * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
	     */
	    String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);
	
	    //设置请求的header
	    httpPost.addHeader("AppKey",APP_KEY);
		
		httpPost.addHeader("Nonce",NONCE);
		
		httpPost.addHeader("CurTime", curTime);
		
		httpPost.addHeader("CheckSum", checkSum);
		
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
    
		//设置请求的参数，requestBody参数
		
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		
		nvps.add(new BasicNameValuePair("templateId", TEMPLATEID));
		
		nvps.add(new BasicNameValuePair("mobile", phoneNum));
		
		nvps.add(new BasicNameValuePair("authCode", authCode));
		
		nvps.add(new BasicNameValuePair("codeLen", CODELEN));
		
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps,"utf-8"));
			
			//执行请求
			response = httpClient.execute(httpPost);
			
			HttpEntity entity = response.getEntity();
			
			String message = EntityUtils.toString(entity,"utf-8");//把返回的实体变成字符串读出来
			
			Gson gson = new Gson();
			
			Type type  = new TypeToken<SMSResult>(){}.getType();
			
			return gson.fromJson(message,type);
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally{
			//关闭资源
			if(response!=null){
				try {
					response.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(httpClient!=null){
				try {
					httpClient.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
				
    }
}
