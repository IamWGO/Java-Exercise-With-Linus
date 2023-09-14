package com.wgoweb.scanner;

import java.util.Scanner;

public class Exercise2 {

  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("2) Skriv ett program som ber användaren mata in ett nummer. Programmet ska räkna ut roten ur numret och print svaret.");
    squareRootOfNumber();
  }

  static  void  squareRootOfNumber(){
    System.out.println("Input number: ");
    int number = input.nextInt();
    System.out.println("square Root Of "+ number +" : " + Math.sqrt(number) + ".");
  }

}
