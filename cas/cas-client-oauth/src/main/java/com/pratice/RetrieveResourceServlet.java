package com.pratice;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.SSLContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RetrieveResourceServlet extends HttpServlet {

	private OauthConfig oauthConfig;
	
	private static Logger logger = LoggerFactory.getLogger(RetrieveResourceServlet.class);
	
	/**
	 * 1根据cas服务器提供的code获取cas oauth服务器的access_token
	 * 2通过access_token获取cas oauth服务器的用户信息，profile_url接口代表oauth服务方认证通过，可以访问的用户资源
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/************************获取第三方oauth服务的access_token************************************/
		//通过OauthServelet，第三方oauth服务方(cas)通过之后，会回调redirect_url，并且带上code参数
		//下面通过code获取access_taken
        String code = req.getParameter("code"); 
        String params = "grant_type=authorization_code&client_id=" + oauthConfig.getClientID() + "&client_secret=" + oauthConfig.getClientSecret() +
                "&code=" + code + "&redirect_uri=" + oauthConfig.getRedirectUri();
        String tokenUri = oauthConfig.getTokenUri()+"?"+params;
        
        logger.debug("待访问的access_taken url地址:"+tokenUri);
        
        //信任所有https请求
        SSLContext sc = null;
		try {
			sc = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy(){
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType)
						throws CertificateException {
					// TODO Auto-generated method stub
					return true;
				}
			}).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        //NoopHostnameVerifier  https//不校验域名
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(  
                sc,NoopHostnameVerifier.INSTANCE);
		HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory)
				.build();
		
        
		HttpPost postReq = new HttpPost(tokenUri);
		HttpResponse tokenResponse = httpClient.execute(postReq);
		String tokenResult = EntityUtils.toString(tokenResponse.getEntity(),"UTF-8");
		postReq.releaseConnection();
		
		logger.debug("oauth服务方回应内容，正确的话会返回access_token;  token response:"+tokenResult);

		
		
		/*****************通过access_token获取用户信息，profile_url接口代表oauth服务方认证通过，可以访问的用户资源********************/
		String accessToken = tokenResult.split("&")[0].split("=")[1];
		String profileUri = oauthConfig.getProfileURL()+"?access_token="+accessToken;
		logger.debug("待访问的profile url地址:"+profileUri);
		
		
		HttpGet getReq = new HttpGet(profileUri);
		HttpResponse profileResponse = httpClient.execute( getReq);
		String profileResult = EntityUtils.toString(profileResponse.getEntity(),"UTF-8");
		
		logger.debug("获取oauth服务方提供的用户信息资源，用户 profile response:"+profileResult);
		
		getReq.releaseConnection();
		httpClient.getConnectionManager().shutdown();
		
		
		
		
		/********************页面展示oauth服务方提供的用户信息*****************/
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
		resp.getWriter().write("<title>第三方oauth服务资源</title>");
		resp.getWriter().write("</head>");
		
		resp.getWriter().write("<body>");
		resp.getWriter().write("第三方oauth服务返回的的用户资源信息："+profileResult);
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");        
	}
	
	/**
	 * 读取oauth服务相关配置信息
	 * @throws ServletException
	 */
	@Override
	public void init() throws ServletException {
		String configPath = "/WEB-INF/classes/oauth.properties";
        InputStream in = this.getServletContext().getResourceAsStream(configPath);  
        Properties props = new Properties();  
        try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
        oauthConfig = new OauthConfig();
        
        oauthConfig.setOauthServerPort(props.getProperty("server.port"));  
        oauthConfig.setRedirectUri(props.getProperty("redirect_uri"));  
        oauthConfig.setTokenUri(props.getProperty("token_uri"));  
        oauthConfig.setClientID(props.getProperty("client_id"));
        oauthConfig.setClientSecret(props.getProperty("client_secret"));  
        oauthConfig.setAuthorizeUrl(props.getProperty("authorize_url"));  
        oauthConfig.setProfileURL(props.getProperty("profile_url"));  
	}
}
