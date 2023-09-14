package com.wgoweb.math;

/**
 * 1. Skriv ett program som avrundar decimaltal till närmsta heltal.*/
public class Exercise1 {

  public static void main(String[] args) {
    double a = 2.7;
    System.out.println("1) " + a + " till närmsta heltal : " +
            roundDecimal(a));
  }

  static double roundDecimal(double a){
    return Math.round(a);
  }
}
