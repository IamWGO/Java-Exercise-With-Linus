package com.wgoweb.powerFizzProject.Authentication;

import com.wgoweb.powerFizzProject.Authentication.dataClass.Admin;
import com.wgoweb.powerFizzProject.Authentication.dataClass.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
* This example we do put text files and data class to dataClass folder
*
* */
public class AuthenticationController {
  Scanner scan = new Scanner(System.in);
  String filename;
  // get path ctrl+ shift + c
  final String filepath = "src/main/java/com/wgoweb/powerFizzProject/Authentication/dataClass/";

  boolean isAdmin;
  int maxTry = 3;
  int nextTryInSecond = 10;
  ArrayList<Admin> admins = new ArrayList<>();
  ArrayList<Customer> customers = new ArrayList<>();

  public AuthenticationController(boolean isAdmin) {
    this.isAdmin = isAdmin;
    filename =  (this.isAdmin) ? "Admin.txt" : "Customer.txt";
  }

  public void doLogin(){
    getContentFromFile();
    System.out.println(" Admin : " + admins.size());
    System.out.println(" Customer : " + customers.size());


    int countTry = 0;
    String username;
    String password;

    boolean run = true;
    while (run) {

      if (maxTry == countTry) {
        System.out.println("You have tried " + maxTry + " times. Try again in "+ nextTryInSecond + " seconds");
        delay();
        countTry = 0;
      }

      System.out.println("::::: Login :::: ");

      System.out.print("Username: ");
      username = scan.nextLine();

      System.out.print("Password: ");
      password = scan.nextLine();

      boolean isSuccess;
      if (isAdmin) {
        isSuccess = isAdminLoginSuccess(username, password);
      } else {
        isSuccess = isCustomerLoginSuccess(username,password);
      }

      if (isSuccess) {
        System.out.println(" Welcome !!!");
        run = false;
        // exit while loop
      } else {
        countTry++;
        System.out.println(" Wrong username or password !!! you have "
                +(maxTry - countTry) + " left.");
      }

    }
  }

  private void delay(){
    try {
      Thread.sleep(nextTryInSecond * 1000L); // Convert seconds to milliseconds
    } catch (InterruptedException e) {
      // Handle the exception if necessary
    }

  }


  private boolean isAdminLoginSuccess(String username, String password){
    for (Admin admin : admins) {
      if (admin.getUsername().equals(username) && admin.getPassword().equals(password))
        return true;
    }
    return false;
  }

  private boolean isCustomerLoginSuccess(String username, String password){
    for (Customer customer : customers) {
      if (customer.getUsername().equals(username) && customer.getPassword().equals(password))
        return true;
    }
    return false;
  }

  private void getContentFromFile(){
    Scanner contentLines;
    try {
      contentLines  = new Scanner(new File( filepath +filename));
      while (contentLines.hasNextLine()) {
        String contentLine = contentLines.nextLine();
        // ignore if empty line
        if (!contentLine.isEmpty()) saveContentLineToArrayList(contentLine);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found " + ex);
    }
  }

  private void saveContentLineToArrayList(String contentLine) {
    String[] parts = contentLine.split(",");
    try {
      String username = parts[0];
      String password = parts[1];

      if (isAdmin) {
        Admin newAdmin = new Admin(username, password);
        admins.add(newAdmin);
      } else {
        Customer newCustomer = new Customer(username,password);
        customers.add(newCustomer);
      }

    } catch (IllegalStateException ex) {  // Skip
      System.out.println("Invalid input string. Expected 2 fields." + ex);
    }
  }

}
