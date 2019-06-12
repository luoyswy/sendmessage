package cn.com.yiyuan.application.sms;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class HttpRequest {
	private static final Log log = LogFactory.getLog(HttpRequest.class);

	  public static String sendPost(String url, String content) {
	    CloseableHttpClient httpClient = null;
	    HttpPost httpPost = null;
	    CloseableHttpResponse httpResponse = null;
	    try {
	      httpClient = HttpClients.createDefault();
	      int CONNECTION_TIMEOUT = 10000;
	      RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(CONNECTION_TIMEOUT).setConnectTimeout(CONNECTION_TIMEOUT).setSocketTimeout(CONNECTION_TIMEOUT).build();
	      httpPost = new HttpPost(url);
	      httpPost.setConfig(requestConfig);
	      httpPost.addHeader("Content-Type", "application/json");
	      StringEntity requestEntity = new StringEntity(content, "UTF-8");
	      httpPost.setEntity(requestEntity);
	      httpResponse = httpClient.execute(httpPost, new BasicHttpContext());
	      HttpEntity entity = httpResponse.getEntity();
	      if (entity != null) {
	        String resultStr = EntityUtils.toString(entity);
	        String str1 = resultStr;
	        return str1;
	      }
	    } catch (Exception e) {
	      log.error("TWL-网络错误", e);
	      return "netError";
	    } finally {
	      if (httpResponse != null)
	        try {
	          httpResponse.close();
	        }
	        catch (Exception localException7) {
	        }
	      if (httpPost != null)
	        try {
	          httpPost.releaseConnection();
	        }
	        catch (Exception localException8) {
	        }
	      if (httpClient != null)
	        try {
	          httpClient.close();
	        }
	        catch (Exception localException9)
	        {
	        }
	    }
	    if (httpResponse != null)
	      try {
	        httpResponse.close();
	      }
	      catch (Exception localException10) {
	      }
	    if (httpPost != null)
	      try {
	        httpPost.releaseConnection();
	      }
	      catch (Exception localException11) {
	      }
	    if (httpClient != null)
	      try {
	        httpClient.close();
	      }
	      catch (Exception localException12)
	      {
	      }
	    return "";
	  }

	  public static JSONObject sendGet(String url) {
	    CloseableHttpClient httpClient = null;
	    HttpGet httpGet = null;
	    CloseableHttpResponse httpResponse = null;
	    try {
	      httpClient = HttpClients.createDefault();
	      int CONNECTION_TIMEOUT = 10000;
	      RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(CONNECTION_TIMEOUT).setConnectTimeout(CONNECTION_TIMEOUT).setSocketTimeout(CONNECTION_TIMEOUT).build();
	      httpGet = new HttpGet(url);
	      httpGet.setConfig(requestConfig);
	      httpGet.addHeader("Content-Type", "application/json");
	      httpResponse = httpClient.execute(httpGet, new BasicHttpContext());
	      HttpEntity entity = httpResponse.getEntity();
	      if (entity != null) {
	        String resultStr = EntityUtils.toString(entity, "UTF-8");
	        JSONObject result = JSONObject.fromObject(resultStr);
	        JSONObject localJSONObject1 = result;
	        return localJSONObject1;
	      }
	    } catch (Exception e) {
	      log.error("TWL-网络错误", e);
	    }
	    finally {
	      if (httpResponse != null)
	        try {
	          httpResponse.close();
	        }
	        catch (Exception localException7) {
	        }
	      if (httpGet != null)
	        try {
	          httpGet.releaseConnection();
	        }
	        catch (Exception localException8) {
	        }
	      if (httpClient != null)
	        try {
	          httpClient.close();
	        }
	        catch (Exception localException9)
	        {
	        }
	    }
	    if (httpResponse != null)
	      try {
	        httpResponse.close();
	      }
	      catch (Exception localException10) {
	      }
	    if (httpGet != null)
	      try {
	        httpGet.releaseConnection();
	      }
	      catch (Exception localException11) {
	      }
	    if (httpClient != null)
	      try {
	        httpClient.close();
	      }
	      catch (Exception localException12)
	      {
	      }
	    return null;
	  }

	  public static String getAllDesPhones(Collection<String> destPhones)
	  {
	    StringBuffer destPhonesStr = new StringBuffer();
	    for (String destPhone : destPhones) {
	      destPhonesStr.append(destPhone).append(",");
	    }
	    destPhonesStr = destPhonesStr.replace(destPhonesStr.length() - 1, destPhonesStr.length(), "");
	    return destPhonesStr.toString();
	  }
}
