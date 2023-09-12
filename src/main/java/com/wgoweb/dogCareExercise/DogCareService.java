package com.wgoweb.dogCareExercise;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class DogCareService {
  Scanner input = new Scanner(System.in);
  private Boolean isContinue = true;
  Dog[] dogList = new Dog[0];

  public Boolean getContinue() {
    return isContinue;
  }

  public void menu(){
    System.out.println("\n\nLee's Dog School - Menu " +
            "\n   1. Register" +
            "\n   2. Check in/ Check out" +
            "\n   3. All Dogs" +
            "\n   4. Close program" +
            "\n    "
    );
  }
  public void doProcess(){
    System.out.print("Select : ");
    String choice = input.next();
    switch (choice) {
      case "1" -> register();
      case "2" -> checkInCheckOut();
      case "3" -> printAll();
      case "4" -> {
        System.out.println("End program !!");
        isContinue = false;
      }
      default -> System.out.println("Failed !!");
    }
  }

  private void register(){

    System.out.println(":::::::: register Dog(s) ::::::::");

    String code = "";
    String name = "";
    int age = 0;

    do {
      System.out.println("\n :::::: New Dog :::::: " +
              "\n   1. Code" + " " + code + " " +
              "\n   2. Name" + " " + name + " " +
              "\n   3. Age" + " " + age + " " +
              "\n   4. Save" +
              "\n   5. Cancel "
      );
      System.out.print("  Select a number : ");
      String command = input.next();

      switch (command) {
        case "1" -> {
          System.out.print("  > Code : ");
          code = input.next();
        }
        case "2" -> {
          System.out.print("  > Name : ");
          name = input.next();
        }
        case "3" -> {
          System.out.print("  > Age : ");
          age = input.nextInt();
        }
        case "4" -> {
          addDogToList(code, name, age);
          code = "";
          name = "";
          age = 0;
          System.out.println("registered  : " + code + " " + name);
        }
        case "5" -> {
        }
        default -> {
          System.out.print("  ** Wrong Command ");
        }
      }

      if (Objects.equals(command.toLowerCase(), "5")) break;

    } while (true);
  }

  private void checkInCheckOut(){
    System.out.println(":::::::: Check In / Check Out  ::::::::");
    Boolean isFound = false;
    printAll();

    System.out.print("  > Code : ");
    String code = input.next();

    for (Dog dog : dogList) {
      if (dog != null && dog.code.equals(code)) {
        dog.isHere = !dog.isHere;
        isFound = true;
        System.out.println(":: Updated "+ dog.name +" - " + dog.isHere+ " ::");
        break; // Exit the loop when a match is found
      }
    }

    if (!isFound)
      System.out.println(":: Not Found, try again!!! ::");
  }

  private void printAll() {
    System.out.println(":::::::: All Dogs ::::::::");

    for (int i = 0; i < dogList.length; i++) {
      // print all registered dogs.
      System.out.println(dogList[i]);
    }

  }


  private void addDogToList(String code, String name, int age){
    // do input dog
    Dog newDog = new Dog(code,name, age);
    // add to array
    Dog[] tempList = Arrays.copyOf(dogList, dogList.length + 1);
    tempList[tempList.length - 1] = newDog;
    dogList = tempList;
  }

}




//    do {
//      System.out.println("New Dog");
//      System.out.print("  > Code : ");
//      String code = input.next();
//      System.out.print("  > Name : ");
//      String name = input.next();
//      System.out.print("  > Age : ");
//      int age = input.nextInt();
//
//      addDogToList(code, name,age);
//
//      System.out.println("Any key -> input more dog , q -> no more dog : ");
//      String command = input.next();
//
//      if (Objects.equals(command.toLowerCase(), "q")) break;
//
//    } while (true);
