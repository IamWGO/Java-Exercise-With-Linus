package com.wgoweb.mathExercise;

/**
 * 3. Skriv ett program som slumpar fram ett tal mellan 0 och 10.*/
public class Exercise3 {

  public static void main(String[] args) {
    int min = 1;
    int max = 10;
    System.out.println("3) slumpar fram ett tal mellan " + min + " och " + max + " : "
            + randomNumber(min, max));
  }

  /**
   * 5. Skriv ett program som slumpar fram ett tal mellan 50 och 100.
   * Reference : https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
   * @min        Min number.
   * @max Max number.
   */
  static int randomNumber(int min, int max) {
    int range = max - min + 1;
    return  (int)(Math.random() * range) + min;
  }
}
