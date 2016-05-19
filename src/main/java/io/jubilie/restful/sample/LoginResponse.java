package io.jubilie.restful.sample;

public class LoginResponse {

	private int responseCode;
	private String loginToken;
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getLoginToken() {
		return loginToken;
	}
	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}
	@Override
	public String toString() {
		return "LoginResponse [responseCode=" + responseCode + ", loginToken=" + loginToken + "]";
	}
}
