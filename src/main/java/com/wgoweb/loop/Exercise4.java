package com.wgoweb.loop;

import java.util.Scanner;

/**
 *
 4.Skriv ett program där användaren matar in ett positivt heltal.
 Programmet ska då skriva ut alla jämna tal med början på 0,
 där det sista talet är heltalet som användaren skrev in.
 Kontrollera att talet är ett positivt tal innan loopen startar,
 annars skriv ut ett felmeddelande och be användaren skriva in ett nytt tal.* */

public class Exercise4 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {

    int exitProgram;
    do {

      System.out.print("\n Input a number -> ");
      int inputNumber = input.nextInt();

      if (inputNumber >= 0) {
        for (int i=0;i<=inputNumber;i++) {
          if (i%2 != 0)  System.out.println(i); //even -> i%2 != 0 , odd -> i%2 == 0
        }
      } else {
        System.out.print("\n Your number less than 0 ");
      }

      // Ask if you want to continue ....
      System.out.print("\n\n==== Do you want to exit ==== \n  [0]  to exit , [any number]  to continue -> ");
      exitProgram = input.nextInt();
    } while (exitProgram != 0);

  }
}
