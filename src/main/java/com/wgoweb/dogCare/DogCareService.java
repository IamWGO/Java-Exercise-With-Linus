package com.wgoweb.dogCare;

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
    dogList = dummy(); // Testing
    System.out.println("""

            Lee's Dog School - Menu\s
               1. Register
               2. Check in/ Check out
               3. All Dogs
               Q. Close program
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
    switch (choice.toUpperCase()) {
      case "1" -> {
        System.out.println(":::::::: register Dog(s) ::::::::");
        register();
      }
      case "2" -> {
        System.out.println(":::::::: Check In / Check Out  ::::::::");
        checkInCheckOut();
      }
      case "3" -> {
        System.out.println(":::::::: All Dogs ::::::::");
        printAll();
      }
      case "Q" -> {
        System.out.println(":::::::: End program !! ::::::::");
        isContinue = false;
      }
      default -> System.out.println("Failed input number 1,2,3 or 4!!");
    }
  }

  private void register(){
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
              "\n   Q. Cancel "
      );

      System.out.print("  Select a number : ");
      String command = input.next();

      switch (command.toUpperCase()) {
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
        case "Q" -> {
          System.out.print(":: Cancel ::");
        }
        default -> System.out.print("  ** Wrong Command ");
      }

      if (Objects.equals(command.toUpperCase(), "Q")) break;

    } while (true);
  }

  private Dog[] dummy() {
    System.out.println("\n:::::::: Set dummy data  ::::::::");
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
    boolean isFound = false;

    do {
      printAll();
      System.out.println("\n Q. Exit ");
      System.out.print("Code : ");
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
    //for (int i = 0; i < dogList.length; i++) {}
    for (int i = 0; i < dogList.length; i++) {
      // print all registered dogs.
      System.out.print((i + 1) + ". ");
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
