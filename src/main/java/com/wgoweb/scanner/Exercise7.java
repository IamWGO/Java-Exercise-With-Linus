package com.wgoweb.scanner;

import java.util.Scanner;

public class Exercise7 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("7) Skriv ett program som kan räkna ut distansen till horisonten när man är till havs. Svaret kommer påverkas av användaren längd. Användaren kommer behöva mata in sin längd i meter. (Detta är möjligt med hjälp av Pythagoras sats, se om du kan hitta en formel online som kan hjälpa dig.)");
    distanceToHorizon();
  }

  //https://www.omnicalculator.com/physics/distance-to-horizon
  static void  distanceToHorizon (){
    System.out.println(" The radius of the planet/object : ");
    int r = input.nextInt();
    System.out.println(" The height of the observer above the surface : ");
    int h = input.nextInt();

    double answer = Math.sqrt(Math.pow((r+h), 2) - Math.pow(r, 2));
    System.out.println(" r : "+ r
            + "  The height : "+ h +" "
            + " Answer : " + answer);
  }
}
