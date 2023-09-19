package com.wgoweb.exception;

import java.util.Scanner;

/*
Why we use exception
*  - for example : read file, api, exception rule  ( ex. device), you also can write your own exception code
*  - for indicating error or other exceptional circumstances
*  - For information specifically relate to the error or exceptional circumstance
*  - don't use for standard app control flow or conditional logic
*  - don't use for bypassing parameters or method return value
* */
public class ExceptionCheckDivideOperator {
  static final Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
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
