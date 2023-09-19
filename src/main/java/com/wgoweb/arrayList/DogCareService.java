package com.wgoweb.arrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DogCareService {

  ArrayList<Dog> dogList = new ArrayList<>();

  public void run(){
    dogList = getDogMembers();
    menu();
  }

  public void menu() {
    Scanner scan = new Scanner(System.in);
    boolean run = true;
    while (run) {
      printMenu();
      String choice = scan.nextLine();

      switch (choice) {
        case "1" -> registerDog();
        case "2" -> pickADogToRemoveFromList();
        case "3" -> printCheckInList();
        case "4" -> printAllDogs();
        case "5" -> {
          System.out.println("Programmet Avslutas! Ha en fortsatt trevlig dag :)");
          run = false;
        }
        default -> System.out.println("Du måste välja mellan 1, 2, 3 eller 4.");
      }
    }
  }

  private void printAllDogs(){
    Dog.output.printHeadLine();
    for (int i = 0; i < dogList.size(); i++) {
      System.out.println(dogList.get(i).printDogRow(i));
    }
  }

  private void registerDog(){
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
        case "1" -> {
          System.out.println("Name: ");
          name = scan.nextLine();
        }
        case "2" -> {
          System.out.println("Birth year: ");
          birthYear = scan.nextInt();
        }
        case "3" -> {
          System.out.println("Race: ");
          race = scan.nextLine();
        }
        case "4" -> {
          System.out.println("Color: ");
          color = scan.nextLine();
        }
        case "5" -> {
          System.out.println("Owner: ");
          owner = scan.nextLine();
        }
        case "6" -> specialNeeds = !specialNeeds;
        case "7" -> {
          System.out.println("Weight: ");
          weight = scan.nextInt();
        }
        case "8" -> {
          System.out.println("Bark: ");
          bark = scan.nextLine();
        }
        case "9" -> {
          Dog tempDog = new Dog(name, birthYear, race, color, owner, specialNeeds, weight, bark);
          addDogToDaycare(tempDog);
          run = false;
        }
        case "Q" -> run = false;
        default -> System.out.println("Måste välja 1 - 9 eller Q.");
      }
    }
  }

  private void addDogToDaycare(Dog newDog) {
    this.dogList.add(newDog);
  }

  private void pickADogToRemoveFromList() {
    Scanner scan = new Scanner(System.in);

    while (true) {
      printAllDogs();

      System.out.println("""

              Q. Gå tillbaka

              Välj en siffra för att ta bort en hund från listan.
              Val -""");
      String inputString = scan.nextLine();

      if(inputString.equalsIgnoreCase("q")){
        break;
      }

      try {
        int choice = Integer.parseInt(inputString);
        if (choice <= this.dogList.size() && choice > 0){
          removeDogFromList(choice - 1);
        } else {
          System.out.println("Du måste välja 1 - " + this.dogList.size() + " eller Q!");
        }
       } catch (NumberFormatException ex) {
        System.out.println("Du måste välja 1 - " + this.dogList.size() + " eller Q!");
      }

    }
  }

  private void printCheckInList(){
    Scanner scan = new Scanner(System.in);

    System.out.println();
    while (true) {
      printAllDogs();

      System.out.println("""

              Q. Gå tillbaka

              Välj en siffra för att ändra på en hunds isHere
              Val -""");
      String inputString = scan.nextLine();

      if(inputString.equalsIgnoreCase("q")){
        break;
      }

      try {
        int choice = Integer.parseInt(inputString);
        if (choice <= this.dogList.size() && choice > 0){
          this.dogList.get(choice - 1).checkInCheckOut();
        } else {
          System.out.println("Du måste välja 1 - " + this.dogList.size() + " eller Q!");
        }
      } catch (NumberFormatException ex) {
        System.out.println("Du måste välja 1 - " + this.dogList.size() + " eller Q!");
      }

    }
  }

  private  ArrayList<Dog> getDogMembers(){
    ArrayList<Dog> dogs = new ArrayList<>();

    String filename = "src/main/java/com/wgoweb/arrayList/DogMember.text";
    try (Scanner contentLines  = new Scanner(new File(filename))) {

      while (contentLines.hasNextLine()) {

        String[] parts = contentLines.nextLine().split(",");
        try {
          // Extract the values from the split parts and create a Dog object
          String name = parts[0];
          int birthDate = Integer.parseInt(parts[1]);
          String race = parts[2];
          String color = parts[3];
          String owner = parts[4];
          boolean specialNeeds = Boolean.parseBoolean(parts[5]);
          int weight = Integer.parseInt(parts[6]);
          String bark = parts[7];

          Dog newDog = new Dog(name, birthDate, race, color, owner, specialNeeds, weight, bark);
          dogs.add(newDog);
        } catch (NumberFormatException ex) {
          System.out.println(parts[0] + " > Invalid format" + ex);
        } catch (IllegalStateException ex) {
          System.out.println("Invalid input string. Expected 8 fields." + ex);
        }
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found " + ex);
    }
    return dogs;
  }


  public void removeDogFromList(int removeDogIndex){
    dogList.remove(removeDogIndex);
  }



  public void printMenu(){
    System.out.println("""

              Linus Hunddagis - Meny
              1. Registrera en ny hund
              2. Ta bort en hund
              3. Checka in / Checka ut
              4. Se alla registrerade hundar
              5. Stäng programmet

              Val:\s""");
  }



}