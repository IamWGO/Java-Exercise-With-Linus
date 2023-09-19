package com.wgoweb.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionInputNumberWithWhileLoop {
  static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    solution1();
  }

  // Linus code : better
  static void solution1() {
    while (true) {
      try {
        System.out.print("input a number : ");
        int inputInteger = input.nextInt();
        System.out.println("Your input : " + inputInteger);
        break;
      } catch (InputMismatchException ex) {
        System.out.println("IllegalArgumentException  : " + ex.getMessage() + " - ArgumentException");
        // get the next input (to fix infinity loop)  ** input issue
        input.next();
      }
    }
  }


  // it is working, but we need to input as String then convert to int
  static void solution2(){
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
