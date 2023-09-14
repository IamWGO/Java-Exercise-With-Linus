package com.wgoweb.ArrayExercise;

/*
 * Skapa ett program där användaren skriver in 10 String värden i en array
 * och skriver sedan ut dem 3 längsta Strängarna, längst först.
 *
 * Create a program where the user enters 10 String values into an array
 * and then prints the 3 longest Strings, longest first.
 * */

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Exercise4V2 {
  static Scanner input = new Scanner(System.in);
  static int maxArray = 5;

  public static void main(String[] args) {
    int exitProgram;
    do {

      runJob();

      System.out.print("\n\n==== Do you want to exit ==== \n  [0]  to exit , [any key]  to continue -> ");
      String command = input.next();

      if (Objects.equals(command, "0")) break;

    } while (true);

    System.out.println("\n **** Program is ended *** ");
  }

  static void runJob(){
    String[] inputWords = new String[maxArray];

    for (int i=0; i< maxArray; i++) {
      System.out.print("Input number "+ (i+1) +" : ");
      inputWords[i] = input.nextLine();
    }

    String[] orderFromLongest = getOrderFromLongest(inputWords);
    String[] firstThreeWords = getFirstThreeWords(orderFromLongest);

    System.out.println("\nInput Words :  " + Arrays.toString(inputWords));
    System.out.println("Order from longest :  " + Arrays.toString(orderFromLongest));
    System.out.println("the 3 longest Strings :  " + Arrays.toString(firstThreeWords));

  }

  static String[] getOrderFromLongest(String[] wordsArray){
    String[] soredNumbers = new String[wordsArray.length];

    for (int i = 0; i < wordsArray.length - 1; i++) {
      for (int j = 0; j < wordsArray.length - 1 - i; j++) {
        if (wordsArray[j].length() < wordsArray[j + 1].length()) {
          // Swap the elements
          String temp = wordsArray[j];
          wordsArray[j] = wordsArray[j + 1];
          wordsArray[j + 1] = temp;
        }
      }
    }

    return wordsArray;
  }

  static String[] getFirstThreeWords(String[] words) {
    String[] threeLongest = new String[3];
    System.arraycopy(words, 0, threeLongest, 0, 3);
    return threeLongest;
  }
}
