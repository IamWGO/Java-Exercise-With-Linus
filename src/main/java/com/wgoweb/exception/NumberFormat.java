package com.wgoweb.exception;

public class NumberFormat {
  public static void main(String[] args) {
    String sample = "a"; // change to number to see result
    try {
      System.out.println("Yes!! it's a number");
      Integer.valueOf(sample);

    } catch (NumberFormatException ex) {
      System.out.println("Exception : " + ex.getMessage() + " is not number");
    }
  }
}
