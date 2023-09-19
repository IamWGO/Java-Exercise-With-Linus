package com.wgoweb.arrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DogCareService {

  ArrayList<Dog> dogList = new ArrayList<>();

  public void run(){
    dogList = getDogMembers();
    printAllDogs(dogList);
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

  private void printAllDogs(ArrayList<Dog> dogList){

    for (int i = 0; i < dogList.size(); i++) {
      System.out.println(i + ". Dog Name " + dogList.get(i).name);
    }

  }

  private void addNewDog(){

  }

  private void checkInCheckOutDog(){

  }

  private void deleteDog(){

  }




}