package com.wgoweb.powerFizzProject.Authentication.dataClass;

public class Admin {
  String username;
  String password;

  public Admin(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
