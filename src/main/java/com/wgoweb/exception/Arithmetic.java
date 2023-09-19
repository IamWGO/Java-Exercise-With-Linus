package com.wgoweb.exception;

public class Arithmetic {
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
