package com.wgoweb.exception;

import java.io.IOException;

/*
Why we use exception
*  - for example : read file, api, exception rule  ( ex. device), you also can write your own exception code
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
    String sample = "a"; // change to number to see result
    try {
      System.out.println("Yes!! it's a number");
      Integer.valueOf(sample);
    } catch (NumberFormatException ex) {
      System.out.println("Exception : " + ex.getMessage() + " is not number");
    }
  }

  static void notAllowDivideByZero(){
    int i = 12;
    int j = 2; // change to a number (2 -> ArithmeticException)

    try {
      int result = i / (j - 2);
      System.out.println(i + " / ("+ j + " - 2) = " + result);

    } catch (ArithmeticException ex) {
      System.out.println("Invalid math operation - " + ex.getMessage());
    } catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    }
  }
}
