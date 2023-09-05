package com.wgoweb.loopExercise;


import java.util.Scanner;

/**
 * Använd en for loop, användaren ska skriva in ett nummer (inga negativa nummer)
 * och sen ska programmet skriva ut alla siffror från 0 till nummret.
 * Skriv om uppgift 1 med en while loop.
 * */
public class Exercise1 {

  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Input number  -> ");
    int number = input.nextInt();

    if (number < 0) {
      System.out.println(number + " is  negative number");
    } else {
      System.out.println(" == Result ==");
      for (int i=0;i<=number;i++) {
        System.out.println(i);
      }
      System.out.println(" -- End --");
    }
  }
}
