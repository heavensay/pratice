package com.pratice;

public class OauthConfig {

	private String oauthServerPort;
	
	private String redirectUri;
	private String tokenUri;
	private String clientID;
	private String clientSecret;
	private String authorizeUrl;
	private String profileURL;
	public String getOauthServerPort() {
		return oauthServerPort;
	}
	public void setOauthServerPort(String oauthServerPort) {
		this.oauthServerPort = oauthServerPort;
	}
	public String getTokenUri() {
		return tokenUri;
	}
	public void setTokenUri(String tokenUri) {
		this.tokenUri = tokenUri;
	}
	public String getRedirectUri() {
		return redirectUri;
	}
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getAuthorizeUrl() {
		return authorizeUrl;
	}
	public void setAuthorizeUrl(String authorizeUrl) {
		this.authorizeUrl = authorizeUrl;
	}
	public String getProfileURL() {
		return profileURL;
	}
	public void setProfileURL(String profileURL) {
		this.profileURL = profileURL;
	}

	
}
