package com.wgoweb.inheritance;

public class Elephant extends Animal {
  @Override
  String getName() {
    return "Elephant";
  }
  @Override
  void information() {
    System.out.println("Elephant is wide animal. it has 4 legs");
  }

  void eat(){
    System.out.println("Sugar cane food");
  }

}
