package com.wgoweb.loopExercise;

import java.util.Scanner;

/**
 *
 5.Skriv ett program som skriver ut multiplikationstabellen för ett heltal, upp till det angivna talet.
 Så om användaren skriver in 4 ska resultatet bli “4 8 12 16”.
 * */

public class Exercise5 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Input number  -> ");
    int number = input.nextInt();

    if (number < 0) {
      System.out.println(number + " is  negative number");
    } else {

      for (int i=1; i<=4; i++) {
        System.out.print(number * i + " ");
      }
    }
  }
}

