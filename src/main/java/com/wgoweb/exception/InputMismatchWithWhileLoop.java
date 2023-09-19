package com.wgoweb.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchWithWhileLoop {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean isLoop = false;
    while (true) {
      try {
        System.out.print("input a number : ");
        // if we use nextLine() or nextInt() -> do not do it
        // program will loop infinity when program get exception
        String inputString = input.next();
        int number = Integer.parseInt(inputString);
        System.out.println("Your input : " + number);
        break;
      } catch (InputMismatchException ex) {
        System.out.println("IllegalArgumentException  : " + ex.getMessage() + " - ArgumentException");
      } catch (NumberFormatException ex) {
        System.out.println("Exception : " + ex.getMessage() + " is not number");
      }
    }
  }
}
