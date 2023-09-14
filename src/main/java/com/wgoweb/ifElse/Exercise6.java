package com.wgoweb.ifElse;

import java.util.Scanner;

/*
Skriv ett program som tar emot en integer från användaren
 och returnerar sant eller falskt. 1 eller högre = sant och 0 eller mindre = falskt.
* */
public class Exercise6 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    oneOrZeroNumber();
  }

  static void oneOrZeroNumber() {
    System.out.println("Input number: ");
    int number = input.nextInt();

    if (number >= 1) System.out.println("number :" + number + " = True");
    else System.out.println("Number :" + number + " = false");
  }
}
