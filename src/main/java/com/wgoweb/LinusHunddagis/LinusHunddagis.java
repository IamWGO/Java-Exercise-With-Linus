package com.wgoweb.LinusHunddagis;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LinusHunddagis {
  Dog dummyDog = new Dog("Kalle", 1999, "",
          "", "Karin P", false, 12, "woof");
  Dog dummyDog1 = new Dog("Fredrika", 1996, "",
          "", "Karin T", false, 12, "woof");
  Dog dummyDog2 = new Dog("Kar helmer", 1997, "",
          "", "Mats L", false, 12, "woof");
  Dog dummyDog3 = new Dog("Zixten", 1990, "",
          "", "Bengt K", false, 12, "woof");
  Dog dummyDog4 = new Dog("Big teddy", 2016, "",
          "", "Karin P", false, 12, "woof");
  Dog[] dogList = new Dog[]{dummyDog, dummyDog1, dummyDog2, dummyDog3, dummyDog4};

  ArrayList<Dog> dogArrayListList = new ArrayList<>();

  public LinusHunddagis() {
  }

  public void meny() {
    Scanner scan = new Scanner(System.in);
    boolean run = true;
    while (run) {
      System.out.println("\nLinus Hunddagis - Meny" +
              "\n1. Registrera en ny hund" +
              "\n2. Ta bort en hund" +
              "\n3. Checka in / Checka ut" +
              "\n4. Se alla registrerade hundar" +
              "\n5. Stäng programmet" +
              "\n\nVal: ");
      String choice = scan.nextLine();

      switch (choice) {
        case "1":
          registerDog();
          break;
        case "2":
          pickADogToRemoveFromList();
          break;
        case "3":
          printCheckInList();
          break;
        case "4":
          printAllDogs();
          break;
        case "5":
          System.out.println("Programmet Avslutas! Ha en fortsatt trevlig dag :)");
          run = false;
          break;
        default:
          System.out.println("Du måste välja mellan 1, 2, 3 eller 4.");
      }
    }
  }

  public void registerDog() {
    Scanner scan = new Scanner(System.in);

    String name = "";
    int birthYear = 0;
    String race = "";
    String color = "";
    String owner = "";
    boolean specialNeeds = false;
    int weight = 0;
    String bark = "";

    boolean run = true;
    while (run) {
      System.out.println("Registrera Hund" +
              "\n1. Name - " + name +
              "\n2. Birth year - " + birthYear +
              "\n3. Race - " + race +
              "\n4. Color - " + color +
              "\n5. Owner - " + owner +
              "\n6. SpecialNeeds - " + specialNeeds +
              "\n7. Weight - " + weight +
              "\n8. Bark - " + bark +
              "\n9. Spara" +
              "\nQ. Gå tillbaka" +
              "\n\n Val -");
      String choice = scan.nextLine();

      switch (choice) {
        case "1":
          System.out.println("Name: ");
          name = scan.nextLine();
          break;
        case "2":
          System.out.println("Birth year: ");
          birthYear = scan.nextInt();
          break;
        case "3":
          System.out.println("Race: ");
          race = scan.nextLine();
          break;
        case "4":
          System.out.println("Color: ");
          color = scan.nextLine();
          break;
        case "5":
          System.out.println("Owner: ");
          owner = scan.nextLine();
          break;
        case "6":
          specialNeeds = !specialNeeds;
          break;
        case "7":
          System.out.println("Weight: ");
          weight = scan.nextInt();
          break;
        case "8":
          System.out.println("Bark: ");
          bark = scan.nextLine();
          break;
        case "9":
          Dog tempDog = new Dog(name, birthYear, race, color, owner, specialNeeds, weight, bark);
          addDogToDaycare(tempDog);
          run = false;
          break;
        case "Q":
          run = false;
          break;
        default:
          System.out.println("Måste välja 1 - 9 eller Q.");
      }
    }
  }

  public void printAllDogs() {
    if (this.dogList.length == 0) {
      System.out.println("Inga hundar på detta dagiset!");
    } else {
      for (int i = 0; i < this.dogList.length; i++) {
        System.out.println(this.dogList[i].toString());
      }
    }
  }

  public void addDogToDaycare(Dog newDog) {
    this.dogList = Arrays.copyOf(this.dogList, this.dogList.length + 1);
    this.dogList[this.dogList.length - 1] = newDog;
  }

  public void printCheckInList() {
    Scanner scan = new Scanner(System.in);
    boolean run = true;
    while (run) {
      for (int i = 0; i < this.dogList.length; i++) {
        System.out.println((i + 1) + ". " + this.dogList[i].name + " " + this.dogList[i].isHere + " " + this.dogList[i].owner);
      }
      System.out.println("\nQ. Gå tillbaka" +
              "\n\nVälj en siffra för att ändra på en hunds isHere"
              + "\nVal -");
      String choice = scan.nextLine();

      if(choice.equalsIgnoreCase("q")){
        run = false;
      } else if(!onlyDigitInString(choice)) {
        System.out.println("Du måste välja 1 - " + this.dogList.length + " eller Q!");
      } else if (Integer.parseInt(choice) <= this.dogList.length && Integer.parseInt(choice) > 0){
        this.dogList[Integer.parseInt(choice) - 1].isHere = !this.dogList[Integer.parseInt(choice) - 1].isHere;
        if(this.dogList[Integer.parseInt(choice) - 1].isHere){
          System.out.println(this.dogList[Integer.parseInt(choice) - 1].name + " har checkat in!");
        } else {
          System.out.println(this.dogList[Integer.parseInt(choice) - 1].name + " har checkat ut!");
        }
      } else {
        System.out.println("Du måste välja 1 - " + this.dogList.length + " eller Q!");
      }
    }
  }

  public boolean onlyDigitInString(String text){
    for (int i = 0; i < text.length(); i++) {
      if(!Character.isDigit(text.charAt(i))){
        return false;
      }
    }
    return true;
  }

  public void pickADogToRemoveFromList(){
    Scanner scan = new Scanner(System.in);
    boolean run = true;
    while (run) {
      for (int i = 0; i < this.dogList.length; i++) {
        System.out.println((i + 1) + ". " + this.dogList[i].toString());
      }
      System.out.println("\nQ. Gå tillbaka" +
              "\n\nVälj en siffra för att ta bort en hund från listan."
              + "\nVal -");
      String choice = scan.nextLine();

      if(choice.equalsIgnoreCase("q")){
        run = false;
      } else if(!onlyDigitInString(choice)) {
        System.out.println("Du måste välja 1 - " + this.dogList.length + " eller Q!");
      } else if (Integer.parseInt(choice) <= this.dogList.length && Integer.parseInt(choice) > 0){

        removeDogFromList(Integer.parseInt(choice) - 1);
      } else {
        System.out.println("Du måste välja 1 - " + this.dogList.length + " eller Q!");
      }
    }
  }

  public void removeDogFromList1(int removeDogIndex){
    Dog[] tempList = Arrays.copyOf(this.dogList, this.dogList.length - 1);

    for (int i = 0; i < tempList.length; i++) {
      if(i < removeDogIndex){
        tempList[i] = this.dogList[i];
      } else if (i >= removeDogIndex){
        tempList[i] = this.dogList[i+1];
      }
    }

    System.out.println(tempList + " >> " + tempList[0]);
    // Arrays.copyOf : create a new index on heap memory
    System.out.println(Arrays.copyOf(tempList, tempList.length) + " >> " + Arrays.copyOf(tempList, tempList.length)[0]);

    this.dogList = tempList;//Arrays.copyOf(tempList, tempList.length);
  }

  public void removeDogFromList(int removeDogIndex){
    Dog[] tempList = new Dog[this.dogList.length -1];
    int j = 0;
    //  should be length of dogList , not tempList
    for (int i = 0; i < this.dogList.length; i++) {
      // good to use exception -continue to keep the code clean
      if (i == removeDogIndex) continue;
      tempList[j++] = this.dogList[i];
    }
    this.dogList = tempList;
  }
}
