package com.wgoweb.ifElseExercise;

import java.util.Scanner;

/*
 * Be användaren mata in 2 integers som inte är samma.
 * Kontrollera så att dem inte är samma och skriv sedan ut dem i numerisk ordning,
 *  minst först. Samma som fråga 2 men med 3 integers.
 *  */
public class Exercise3 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    inputThreeNumbers();
  }

  static void inputThreeNumbers() {
    System.out.print("\nInput number 1 : ");
    int number1 = input.nextInt();
    System.out.print("\nInput number 2 : ");
    int number2 = input.nextInt();
    System.out.print("\nInput number 3 : ");
    int number3 = input.nextInt();

    if (number1 == number2 || number1 == number3 || number2 == number3){

      System.out.println("Talen får inte vara samma tal");

    } else if (number1 < number2 && number1 < number3) {

      if (number2 < number3)
        System.out.println(" min - max " + number1 + " " + number2 + " " + number3);
      else
        System.out.println(" min - max " + number1 + " " + number3 + " " + number2);

    } else if (number2 < number1 && number2 < number3) {

      if (number1 < number3)
        System.out.println(" min - max " + number2 + " " + number1 + " " + number3);
      else
        System.out.println(" min - max " + number2 + " " + number3 + " " + number1);

    } else {

      if (number1 < number2)
        System.out.println(" min - max " + number3 + " " + number1 + " " + number2);
      else
        System.out.println(" min - max " + number3 + " " + number2 + " " + number1);

    }
  }
}
