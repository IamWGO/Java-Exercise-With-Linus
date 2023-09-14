package com.wgoweb.loop;

import java.util.Scanner;

/** 8.
 * a) Skriv ett program där användaren får skriva in 10 numer och sen skriver programmet ut det största numret.
 * b) Lägg till så användaren får först skriva in antalet tal som ska jämföras.
 * c) Nu ska användaren skriva in nya tal, fram tills att man skriver 0. Då vissas reesultatet och programmet avslutas.
 * */

public class Exercise8 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    boolean isExitProgram = false;
    int maxNumber;
    int firstNumber;

    do {
      maxNumber = 0;
      firstNumber = 0;

      System.out.print("\n ====Start===== \n ");
      System.out.println("\nenter 10 numbers and order min to max\n");

      for (int i=1;i<=10;i++) {

        // 2. input a number
        System.out.print("Enter number " + i + " -> ");
        int inputNumber = input.nextInt();

        // 3.  exit program if inputNumber = 0
        if (inputNumber == 0) {
          isExitProgram = true;
          break;
        }

        // 4. remember the first number
        if (i == 1) firstNumber = inputNumber;

        // 5. check if inputNumber is maximum
        if (inputNumber > maxNumber) maxNumber = inputNumber;

        // 6. print out the maxNumber before get the next one
        System.out.println("    Maximum number :" + maxNumber);
      }

      // 7. ask if remember the first number
      System.out.print("\n--------\nCan you remember the first number -> ");
      int guessFistNumber = input.nextInt();

      // 8. check the answer
      if (guessFistNumber == firstNumber)
        System.out.println(">> Correct! The fist number is : " + firstNumber);
      else
        System.out.println(">> Incorrect! the first number is : " + firstNumber);

      // 9. check if user input 0 (if isExitProgram = true then exit)
      if (!isExitProgram) {
        // 9.1. Ask if you want to continue ....
        System.out.print("\n ========= \n [0]  to exit ,  [any number]  to continue -> ");
        int exitProgram = input.nextInt();
        isExitProgram = exitProgram == 0;
      } else break;

      // 10. check if not exit then do it again
    } while (!isExitProgram);

    // 11. print out End Program
    System.out.print("\n ====End Program===== \n ");

  }
}

