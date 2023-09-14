package com.wgoweb.ifElse;

import java.util.Scanner;

/*
* Be användaren mata in 2 integers som inte är samma.
* Kontrollera så att dem inte är samma
* och skriv sedan ut dem i numerisk ordning, minst först.
 * */
public class Exercise2 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    inputTwoNumbers();
  }

  static void inputTwoNumbers() {
    System.out.println("Input number 1 : ");
    int number1 = input.nextInt();
    System.out.println("Input number 2 : ");
    int number2 = input.nextInt();

    if (number1 != number2) {
      if (number1 < number2) {
        System.out.println(" min - max " + number1 + " " + number1);
      } else {
        System.out.println(" min - max " + number2 + " " + number1);
      }
    } else {
      System.out.println(" Same number " + number1);
    }
  }
}
