package com.wgoweb.dogCareExercise;

public class Dog {
  String code;
  String name;
  int age;
  boolean isHere;

  public Dog(String code, String name, int age) {
    this.code = code;
    this.name = name;
    this.age = age;
    this.isHere = false;
  }

  @Override
  public String toString() {
    return "Code: "+ this.code+
            " Name: " + this.name +
            " Age: " + this.age +
            " Is here: " + this.isHere;
  }

}
//public class Dog {
//  String name;
//  int birthDate;
//  String race;
//  String color;
//  String owner;
//  boolean specialNeeds;
//  int weight;
//  String bark;
//  boolean isHere = false;
//
//  public Dog(String name, int birthDate, String race, String color, String owner,
//             boolean specialNeeds, int weight, String bark) {
//    this.name = name;
//    this.birthDate = birthDate;
//    this.race = race;
//    this.color = color;
//    this.owner = owner;
//    this.specialNeeds = specialNeeds;
//    this.weight = weight;
//    this.bark = bark;
//  }
//
//  @Override
//  public String toString() {
//    return "Dog{" +
//            "name='" + name + '\'' +
//            ", birthDate=" + birthDate +
//            ", race='" + race + '\'' +
//            ", color='" + color + '\'' +
//            ", owner='" + owner + '\'' +
//            ", specialNeeds=" + specialNeeds +
//            ", weight=" + weight +
//            ", bark='" + bark + '\'' +
//            '}';
//  }
//}
