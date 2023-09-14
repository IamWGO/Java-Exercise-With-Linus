package com.wgoweb.loopExercise;

import java.util.Scanner;

/**
 * 2.Skriv om uppgift 1 med en while loop.*/

public class Exercise2 {

  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Input number  -> ");
    int number = input.nextInt();

    if (number < 0) {
      System.out.println(number + " is  negative number");
    } else {
      System.out.println(" == Result ==");

      int i=0;
      while (i <=number) {
        System.out.println(i);
        i++;
      }

      System.out.println(" -- End --");
    }
  }
}
