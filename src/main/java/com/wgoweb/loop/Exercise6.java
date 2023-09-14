package com.wgoweb.loop;

import java.util.Scanner;

/**
 * 6. Bygg på 5 med att användaren får bestämma hur många tal i den angivna tabellen
 * som ska vissas. T.ex. om användaren skriver in 12 och 4 ska resultatet bli
 *    “1 * 12 = 12
 *    1 * 12 = 24
 *    3 * 12 = 36
 *    4 * 12 = 48” */

public class Exercise6 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Input number -> ");
    int number = input.nextInt();

    System.out.println("How manay times  -> ");
    int times = input.nextInt();

    if (number < 0 || times < 0) {
      System.out.println("You input negative number ");
    } else {
      for (int i=1; i<=times; i++) {
        System.out.println(i + " * "+ number +" = " + i * number);
      }
    }
  }
}

