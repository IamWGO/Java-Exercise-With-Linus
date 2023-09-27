package com.wgoweb.powerFizzProject.authentication;

public class Main {
  public static void main(String[] args) {
    // isAdmin = false : Customer.txt
    // isAmin = true : Admin.txt
    AuthenticationController auth = new AuthenticationController(false);
    auth.doLogin();

  }
}
