package com.wgoweb.arrayListHunddagis;

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

  public void checkInCheckOut() {
    this.isHere = !this.isHere;

    if (this.isHere) {
      System.out.println("\n*** " + this.name + " Check In !! \n");
    } else {
      System.out.println("\n*** " + this.name + " Check Out !!\n");
    }
  }

  public String printDogRow(int rowIndex) {
    return
      output.addWhiteSpace((rowIndex + 1) + ".", 5) +
      output.addWhiteSpace( ((!name.isEmpty()) ? name : "-"), output.maxName)  + "| " +
      output.addWhiteSpace(((birthDate > 1000) ? String.valueOf(birthDate) : "-"), output.maxBirthYear)  + "| " +
      output.addWhiteSpace(((!race.isEmpty()) ? race : "-"), output.maxBreed)  + "| " +
      output.addWhiteSpace(((!color.isEmpty()) ? color : "-"), output.maxColor)  + "| " +
      output.addWhiteSpace(((!owner.isEmpty()) ? owner : "-"), output.maxOwner)   + "| " +
      output.addWhiteSpace( (specialNeeds ? "Yes" : "No"), output.maxSpecialNeeds)   + "| " +
      output.addWhiteSpace(weight + "kg.", output.maxWeight)  + "| " +
      output.addWhiteSpace(((!bark.isEmpty()) ? bark : "-"), output.maxBark)+ "| " +
      output.addWhiteSpace( (isHere ? "checked" : "-"), output.maxSpecialNeeds);
  }

  static  class output {
    static int maxName = 15;
    static int maxBirthYear = 5;
    static int maxBreed = 20;
    static int maxColor = 10;
    static int maxOwner = 20;
    static int maxSpecialNeeds = 9;
    static int maxWeight = 6;
    static int maxBark = 15;
    public static String addWhiteSpace(String text, int maxAmount){
      if(text.length() > maxAmount){
        return text.substring(0, maxAmount - 3) + "...";
      }
      return text + " ".repeat(maxAmount - text.length());
    }

    public static void printHeadLine(){
      String headline = addWhiteSpace("No.", 3) + "| " +
              addWhiteSpace("Name", maxName) + "| " +
              addWhiteSpace("Year", maxBirthYear) + "| " +
              addWhiteSpace( "Breed", maxBreed) + "| " +
              addWhiteSpace( "Color", maxColor) + "| " +
              addWhiteSpace( "Owner", maxOwner) + "| " +
              addWhiteSpace( "Needs", maxSpecialNeeds) + "| " +
              addWhiteSpace( "Weight", maxWeight) + "| " +
              addWhiteSpace( "Bark", maxBark)+ "| " +
              addWhiteSpace( "checked", maxSpecialNeeds);
      System.out.println(headline);
      System.out.println("-".repeat(headline.length()));
    }
  }
}
