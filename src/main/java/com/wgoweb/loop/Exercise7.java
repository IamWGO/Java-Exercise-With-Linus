package com.wgoweb.loopExercise;

import java.util.Scanner;

/**  7. Skriv ett program där användaren skriver in ett heltal som blir x,
 *  vi ska sen skriva ut dem första x talen i 3:ans tabell (inkludera 0 i början).
 *  Skriver vi 5 blir resultatet “0, 3, 6, 9, 12”. */

public class Exercise7 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("(3 * times = ? --> How manay times  -> ");
    int times = input.nextInt();

    if (times < 0) {
      System.out.println("You input negative number");
    } else {
      for (int i=1; i<=times; i++) {
        System.out.println(i + " * 3 = " + i * 3);
      }
    }
  }
}

