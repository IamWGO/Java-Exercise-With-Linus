package com.wgoweb.scanner;

import java.util.Scanner;

public class Exercise5 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("5) Skriv ett program som frågar om avståndet (km) mellan 2 platser, räkna ut hur lång tid det tar att köra om man kör 70 km/h, skriv ut svaret.");
    distanceBetweenTwoPlaces();
  }

  static  void  distanceBetweenTwoPlaces() {
    System.out.println("Distance Between 2 Places (km) : ");
    int distanceInKm = input.nextInt();

    double timeTakePerMinute = (double) 70 / 60;

    System.out.println(" Distance "+ distanceInKm + "km takes : "
            + distanceInKm * timeTakePerMinute);

  }

}
