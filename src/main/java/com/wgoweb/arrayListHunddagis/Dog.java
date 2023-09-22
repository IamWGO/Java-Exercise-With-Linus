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
    this.bark = bark.isEmpty() ? "woff" : bark;
  }

  public void setIsHere() {
    this.isHere = !this.isHere;
  }

  public String objectToLineFormat(){
    return this.name + "," +
                this.birthDate + "," +
                this.race + "," +
                this.color + "," +
                this.owner + "," +
                this.specialNeeds + "," +
                this.weight + "," +
                this.bark;
  }

  static class Output {
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

    public static void  printDogRow(int rowIndex, Dog dog) {
      String row =
              Output.addWhiteSpace((rowIndex + 1) + ".", 5) +
                      Output.addWhiteSpace( ((!dog.name.isEmpty()) ? dog.name : "-"), Output.maxName)  + "| " +
                      Output.addWhiteSpace(((dog.birthDate > 1000) ? String.valueOf(dog.birthDate) : "-"), Output.maxBirthYear)  + "| " +
                      Output.addWhiteSpace(((!dog.race.isEmpty()) ? dog.race : "-"), Output.maxBreed)  + "| " +
                      Output.addWhiteSpace(((!dog.color.isEmpty()) ? dog.color : "-"), Output.maxColor)  + "| " +
                      Output.addWhiteSpace(((!dog.owner.isEmpty()) ? dog.owner : "-"), Output.maxOwner)   + "| " +
                      Output.addWhiteSpace( (dog.specialNeeds ? "Yes" : "No"), Output.maxSpecialNeeds)   + "| " +
                      Output.addWhiteSpace(dog.weight + "kg.", Output.maxWeight)  + "| " +
                      Output.addWhiteSpace(((!dog.bark.isEmpty()) ? dog.bark : "-"), Output.maxBark)+ "| " +
                      Output.addWhiteSpace( (dog.isHere ? "checked" : "-"), Output.maxSpecialNeeds);

      System.out.println(row);
    }
  }
}
