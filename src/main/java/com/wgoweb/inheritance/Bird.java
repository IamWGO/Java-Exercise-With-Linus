package com.wgoweb.inheritance;

public class Bird extends Animal {
  @Override
  String getName() {
    return "Bird";
  }
  @Override
  void information() {
    System.out.println("Bird is wide animal. it has 2 legs with wings");
  }

  void eat(){
    System.out.println("Seed food");
  }

}
