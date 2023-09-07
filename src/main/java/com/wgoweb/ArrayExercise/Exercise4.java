package com.wgoweb.ArrayExercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

/*
* Skapa ett program där användaren skriver in 10 String värden i en array
* och skriver sedan ut dem 3 längsta Strängarna, längst först.
*
* Create a program where the user enters 10 String values into an array
* and then prints the 3 longest Strings, longest first.
* */
public class Exercise4 {

  static Scanner input = new Scanner(System.in);
  static int maxArray = 10;
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

    System.out.println("\ninput Words :  " + Arrays.toString(inputWords));
    System.out.println("order from longest : " + Arrays.toString(strOrderFromLongest(inputWords)));
    System.out.println("the 3 longest Strings :  " + Arrays.toString(firstThreeStrings(inputWords)));

  }

  static String[] strOrderFromLongest(String[] strArray){
    Arrays.sort(strArray, new Comparator<String>() {
      @Override
      public int compare(String str1, String str2) {
        return Integer.compare(str2.length(), str1.length());
      }
    });

    return strArray;
  }

  static String[] firstThreeStrings(String[] words) {
    String[] threeLongest = new String[3];
    System.arraycopy(words, 0, threeLongest, 0, 3);
    return threeLongest;
  }

}
