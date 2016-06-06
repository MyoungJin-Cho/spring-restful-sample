package io.jubilie.restful.sample;

public class UserResponse {

    private String loginToken;

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    @Override
    public String toString() {
        return "UserResponse [loginToken=" + loginToken + "]";
    }
}
