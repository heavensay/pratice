package com.pratice;
import java.io.IOException;
import java.io.InputStream;
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

public class OauthServlet extends HttpServlet {

	private OauthConfig oauthConfig;
	
	private static Logger logger = LoggerFactory.getLogger(OauthServlet.class);
	
	/**
	 * 访问cas服务器进行认证 ;/cas/oauth2.0/authorize
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String authorizeUrl = oauthConfig.getAuthorizeUrl()+"?response_type=code&client_id="
        					+oauthConfig.getClientID()+"&redirect_uri="+oauthConfig.getRedirectUri();        
        		
		logger.debug("第三方cas oauth服务认证地址,authorize url:"+authorizeUrl);
		
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
		resp.getWriter().write("<title>第三方cas oauth服务授权</title>");
		resp.getWriter().write("</head>");
		
		resp.getWriter().write("<body>");
		resp.getWriter().write("<a href='"+authorizeUrl+"'>进入第三方授权认证(cas Oauth)</a>");
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
