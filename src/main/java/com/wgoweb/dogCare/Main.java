package com.wgoweb.dogCare;

public class Main {
  public static void main(String[] args) {
    DogCareService dogDayCare = new DogCareService();

    do {
      dogDayCare.menu();
      dogDayCare.doProcess();
    } while (dogDayCare.getContinue());

  }
}
