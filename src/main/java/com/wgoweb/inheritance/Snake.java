package com.wgoweb.inheritance;

public class Snake extends Animal {
  @Override
  String getName() {
    return "Snake";
  }
  @Override
  void information() {
    System.out.println("Snake is wide animal. it has 0 legs");
  }




}
