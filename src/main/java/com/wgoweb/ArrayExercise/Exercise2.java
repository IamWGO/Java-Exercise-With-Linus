package com.wgoweb.ArrayExercise;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

/*
* Skapa en array som innehåller 10 integers med värden mellan 0 och 100.
* Du får själv bestämma hur du populerar din array.
*  Be sedan användaren skriva in ett nummer och kolla om det finns med i din array.
* Informera sedan användaren om det fanns med
* och på vilket/vilka array index som värdet finns på.
*
*
* Create an array containing 10 integers with values between 0 and 100.
*  You can decide for yourself how to populate your array.
* Then ask the user to enter a number and check if it is in your array.
*  Then inform the user if it was with and on which array index(s) the value is located.
* */
public class Exercise2 {

  static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    do {

      runJob();

      System.out.print("\n\n==== Do you want to exit ==== \n  [0]  to exit , [any key]  to continue -> ");
      String command = input.next();

      if (Objects.equals(command, "0")) break;

    } while (true);

    System.out.println("\n **** Program is ended *** ");

  }

  static void runJob(){
    int[] randomNumbers = new int[10];
    // random 10 numbers between 0 - 100
    for (int i=0; i<10; i++) {
      randomNumbers[i] = randomNumber(0, 100);
    }

    // Input Guess number
    System.out.print("Input a number 0 - 100 : ");
    int guessNumber = input.nextInt();
    // Check if guessNumber contains in random numbers
    boolean isCorrect = Arrays.asList(randomNumbers).contains(guessNumber);
    if (isCorrect) {
      System.out.print(guessNumber + " is correct!");
    } else {
      System.out.print(" Incorrect! the random numbers are " + printNumbers(randomNumbers) );
    }
  }

  static String printNumbers(int[] randomNumbers) {
    return Arrays.toString(randomNumbers);
  }
  static int randomNumber(int min, int max) {
    int range = max - min + 1;
    return  (int)(Math.random() * range) + min;
  }
}
