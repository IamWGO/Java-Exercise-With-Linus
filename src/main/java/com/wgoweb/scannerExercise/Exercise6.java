package com.wgoweb.scannerExercise;

import java.util.Scanner;

public class Exercise6 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("6) Skriv ett program bestämmer priset på en produkt som är på rea, du ska både skriva in hur många %-rabatt det är och ordinarie priset på produkten. Räkna ut det nya priset och skriv ut svaret.");
    discountProduct();
  }

  static void discountProduct() {
    System.out.println("Price : ");
    int price = input.nextInt();
    System.out.println("% Discount : ");
    int percentDiscount = input.nextInt();

    double answer = price * ((double) percentDiscount / 100);

    System.out.println(" Product Price : "+ price
            + " % discount : "+ percentDiscount +" %"
            + " sale price : " + answer);

  }
}
