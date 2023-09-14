package com.wgoweb.dogCareExercise;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class DogCareService {
  Scanner input = new Scanner(System.in);
  private Boolean isContinue = true;
  private Dog[] dogList = new Dog[0];

  public Boolean getContinue() {
    return isContinue;
  }

  public void menu(){
    System.out.println("""

            Lee's Dog School - Menu\s
               1. Register
               2. Check in/ Check out
               3. All Dogs
               4. Close program
               \s"""
    );
  }
  public void doProcess(){
    System.out.print("Select : ");
    String choice = input.next();
    /*lambda to make the code short
    * switch (choice) {
    * case "1" : register(); break;
    * .....2,3.......
    * case "4" : {
    *   System.out.println("End program !!");
    *   isContinue = false;
    *   break;
    *   }
    * default : {
    *   System.out.println("Failed input number 1,2,3 or 4!!");
    *   break;
    *   }
    * }
    *
    * }
    * */
    switch (choice) {
      case "1" -> register();
      case "2" -> checkInCheckOut();
      case "3" -> printAll();
      case "4" -> {
        System.out.println("End program !!");
        isContinue = false;
      }
      default -> System.out.println("Failed input number 1,2,3 or 4!!");
    }
  }

  private void register(){

    System.out.println(":::::::: register Dog(s) ::::::::");

    String code = "";
    String name = "";
    int age = 0;

    do {
      /*
       * Explain :
       * ((code.isEmpty()) ? '-' : code)
       * -> lambda to make the code short
       * --------------------------------------------
         * String code = input.next();
         * String showCode;
         * if (code.isEmpty()) {
         *   showCode  = '-';
         * } else {
         *   showCode = code;
         * }
       * */

      System.out.println("\n :::::: New Dog :::::: " +
              "\n   1. Code" + " " + ((code.isEmpty()) ? '-' : code) + " " +
              "\n   2. Name" + " " + ((name.isEmpty()) ? '-' : name) + " " +
              "\n   3. Age" + " " + ((age == 0) ? "-" : String.valueOf(age)) + " " +
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
          System.out.println(":: registered  : " + code + " " + name + " :: ");
          code = "";
          name = "";
          age = 0;
        }
        case "5" -> System.out.print(":: Cancel ::");
        default -> System.out.print("  ** Wrong Command ");
      }

      if (Objects.equals(command.toLowerCase(), "5")) break;

    } while (true);
  }

  private Dog[] dummy() {
    return new Dog[] {
            new Dog("001", "Lee", 2),
            new Dog("002", "Lee-002", 2),
            new Dog("003", "Lee-003", 2),
            new Dog("004", "Lee-004", 2),
            new Dog("005", "Lee-005", 2),
            new Dog("006", "Lee-006", 2),
    };
  }

  private void checkInCheckOut(){
    System.out.println(":::::::: Check In / Check Out  ::::::::");
    boolean isFound = false;

    do {
      dogList = dummy(); // Testing
      printAll();

      System.out.print("\n Q to exit or Code : ");
      String code = input.next();

      if (Objects.equals(code, "q")) break;

      //for (int i = 0; i < dogList.length; i++) {}
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
    } while (true);
  }

  private void printAll() {
    System.out.println(":::::::: All Dogs ::::::::");
    //for (int i = 0; i < dogList.length; i++) {}
    for (Dog dog : dogList) {
      // print all registered dogs.
      System.out.println(dog);
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
