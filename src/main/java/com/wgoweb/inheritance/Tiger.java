package com.wgoweb.inheritance;

public class Tiger extends Animal {
  @Override
  String getName() {
    return "Tiger";
  }

  @Override
  void information() {
    System.out.println("Tiger is wide animal. it has 4 legs");
  }


}
