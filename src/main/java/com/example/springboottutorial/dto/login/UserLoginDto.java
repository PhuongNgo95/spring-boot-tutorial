package com.example.springboottutorial.dto.login;

public class UserLoginDto {
    private int userId;
    private String userName;
    private String encrytedPassword;
    private String newPassword2Change;
    private int enabled;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public String getNewPassword2Change() {
        return newPassword2Change;
    }

    public void setNewPassword2Change(String newPassword2Change) {
        this.newPassword2Change = newPassword2Change;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "UserLoginDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", encrytedPassword='" + encrytedPassword + '\'' +
                ", newPassword2Change='" + newPassword2Change + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
