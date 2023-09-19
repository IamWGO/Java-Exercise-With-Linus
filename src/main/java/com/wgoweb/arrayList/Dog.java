package com.wgoweb.arrayList;

public class Dog {
  String name;
  int birthDate;
  String race;
  String color;
  String owner;
  boolean specialNeeds;
  int weight;
  String bark;
  boolean isHere = false;

  public Dog(String name, int birthDate, String race, String color, String owner,
             boolean specialNeeds, int weight, String bark) {
    this.name = name;
    this.birthDate = birthDate;
    this.race = race;
    this.color = color;
    this.owner = owner;
    this.specialNeeds = specialNeeds;
    this.weight = weight;
    this.bark = bark;
  }

  @Override
  public String toString() {
    return "Dog{" +
            "name='" + name + '\'' +
            ", birthDate=" + birthDate +
            ", race='" + race + '\'' +
            ", color='" + color + '\'' +
            ", owner='" + owner + '\'' +
            ", specialNeeds=" + specialNeeds +
            ", weight=" + weight +
            ", bark='" + bark + '\'' +
            '}';
  }
}