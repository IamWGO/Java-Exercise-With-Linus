package com.wgoweb.scannerExercise;

import java.util.Scanner;

public class Exercise4 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("4) Skriv ett program som frågar om en radien i en cirkel, räknar ut arean i cirkeln ock skriver ut svaret.");
    areaOfCircle();
  }

  static void areaOfCircle() {
    //Area of a circle = π × r2
    //π  =  3.14
    System.out.println("Input Radius : ");
    int radius = input.nextInt();

    double answer = 3.14 * Math.pow(radius, 2);
    System.out.println("Area of circle "+ radius +" : " + answer + ".");

  }
}
