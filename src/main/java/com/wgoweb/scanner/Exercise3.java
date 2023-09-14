package com.wgoweb.scanner;

import java.util.Scanner;

public class Exercise3 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("3) Skriv ett program som ber användaren mata in 3 nummer, räkna ut medelvärdet och skriv ut svaret.");
    averageOfThreeNumbers();
  }

  static void  averageOfThreeNumbers() {
    System.out.println("Input number 1 : ");
    int number = input.nextInt();
    System.out.println("Input number 2 : ");
    int number2 = input.nextInt();
    System.out.println("Input number 3 : ");
    int number3 = input.nextInt();

    double average = (double)(number + number2 + number3) / 3;
    System.out.println("average of "+ number+", "+ number2 + ", "+ number3 +" =  " + average + ".");
  }

}