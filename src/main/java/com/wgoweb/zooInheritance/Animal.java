package com.wgoweb.zooInheritance;

public abstract class Animal {
  // abstract -> expect the child class do something
  abstract String getName();
  abstract void information();
  // default -> child class don't need to have
  void eat(){
    System.out.println("Normal food");
  }
}
