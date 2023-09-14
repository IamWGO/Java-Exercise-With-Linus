package com.wgoweb.scanner;

import java.util.Scanner;

public class Exercise1 {

  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("1) Skriv ett program som ber användaren mata in sitt namn, Svara med en mening där användarens namn finns med.");
    whatIsYourName();
  }

  static void whatIsYourName(){
    System.out.println("What is your name : ");
    String name  = input.nextLine();
    System.out.println("Nice to meet you " + name + ".");

  }

}
