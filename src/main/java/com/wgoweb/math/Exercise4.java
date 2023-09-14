package com.wgoweb.math;

/**
 * 4. Skriv ett program som slumpar fram ett tal mellan 50 och 100.*/
public class Exercise4 {
  public static void main(String[] args) {
    int min1 = 50;
    int max1 = 100;
    System.out.println("4) slumpar fram ett tal mellan " + min1 + " och " + max1 + " : "
            + randomNumber(min1, max1));
  }

  static int randomNumber(int min, int max) {
    int range = max - min + 1;
    return  (int)(Math.random() * range) + min;
  }

}
