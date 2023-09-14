package com.wgoweb.ifElse;

import java.util.Scanner;

/*
1. Programmet ska be användaren först skriva in ett tal mellan 0 och 10.
Om talet är mellan 0 - 10 ska vi skriva ut talet i konsolen.
Om talet inte är mellan 0 - 10, då ska det skrivas ut om talet var större än 10
eller mindre än 0.
* */
public class Exercise1 {

  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    inputNumberZeroToTen();
  }

  static void inputNumberZeroToTen() {
    System.out.println("Input number 1-10 : ");
    int number = input.nextInt();


    if (number < 0) {
      System.out.println("talet var mindre än 0");
    } else if (number > 10) {
      System.out.println("talet var större än 10");
    } else {
      System.out.println(" talet i konsolen");
    }
  }
}
