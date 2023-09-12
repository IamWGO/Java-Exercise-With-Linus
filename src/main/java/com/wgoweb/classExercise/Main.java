package com.wgoweb.classExercise;

import java.util.Arrays;
public class Main {
  public static void main(String[] args) {

//    Intro person1 = new Intro("Lee", 44, "Software Engineer");
//    Intro person2 = new Intro("King", 47, "Head of department");
//
//    System.out.println(person1);
//    person1.setName("Lee Gottlieb");
//    System.out.println(person1);
//
//
//    System.out.println(person2);
//    person2.setName("Frederik Gottlieb");
//    System.out.println(person2);


    Person[] employees = new Person[0];
    Person person1 = new Person("Lee", 44, "Software Engineer");
    employees = addPersonToEmployeeList(person1, employees);

    System.out.println("Order from longest :  " + Arrays.toString(employees));

  }


  public static Person[] addPersonToEmployeeList(Person newPerson, Person[] employeeList){
    Person[] tempList = Arrays.copyOf(employeeList, employeeList.length + 1);
    tempList[tempList.length - 1] = newPerson;
    return tempList;
  }

}
