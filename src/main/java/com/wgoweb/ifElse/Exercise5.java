package com.wgoweb.ifElseExercise;

import java.util.Scanner;

/*
Skriv ett program som tar emot en integer från användaren.
Kontrollerar ifall talet är ett jämnt eller udda tal
och skriv sedan ut svaret i konsolen. (Använd modulus - %)
* */
public class Exercise5 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    evenOddNumber();
  }

  static void evenOddNumber() {
    System.out.println("Input number: ");
    int number = input.nextInt();

    if (number%2 == 0) System.out.println("Odd number :" + number + "%");
    else System.out.println("Even number :" + number + "%");
  }
}
