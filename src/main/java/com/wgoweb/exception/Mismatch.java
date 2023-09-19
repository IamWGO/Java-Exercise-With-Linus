package com.wgoweb.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Mismatch {
  static final Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    try {
      System.out.print("input a number : ");
      int inputInteger = input.nextInt();
      System.out.println("Your input : " + inputInteger);
    } catch (InputMismatchException ex) {
      System.out.println("IllegalArgumentException  : " + ex.getMessage() + " - ArgumentException");
    }
  }
}
