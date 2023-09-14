package com.wgoweb.exception;

import java.io.IOException;

/*
Why we use exception
*  - for example : read file, api, exception rule  ( ex. device)
*  - for indicating error or other exceptional circumstances
*  - For information specifically relate to the error or exceptional circumstance
*  - don't use for standard app control flow or conditional logic
*  - don't use for bypassing parameters or method return value
* */
public class Main {
  public static void main(String[] args) {
    checkIfNumber();
    notAllowDivideByZero();
  }

  static void checkIfNumber(){
    String sample = "a";
    try {
      Integer.valueOf(sample);
    } catch (NumberFormatException ex) {
      System.out.println("Exception : " + ex.getMessage() + " is not number");
    }
  }

  static void notAllowDivideByZero(){
    int i = 12;
    int j = 2;

    try {
      int result = i / (j - 2);
      System.out.println(result);

    } catch (ArithmeticException ex) {
      System.out.println("Invalid math operation - " + ex.getMessage());
    } catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    }
  }
}
