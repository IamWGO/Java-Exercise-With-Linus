package com.wgoweb.inheritance;

public class Main {
  public static void main(String[] args) {
    // Define Bird inherit Animal
    System.out.println(" -------------Tiger-------------- ");
    Tiger tiger = new Tiger();
    tiger.information();
    tiger.eat();

    // Define Bird inherit Animal
    System.out.println(" -------------bird-------------- ");
    Bird bird = new Bird();
    bird.information();
    bird.eat();

    // Define Snake inherit Animal
    System.out.println(" -------------Pet-------------- ");
    Snake snake = new Snake();
    snake.information();
    snake.eat();

    // Define elephant inherit Animal
    System.out.println(" -------------Wide-------------- ");
    Elephant elephant = new Elephant();
    elephant.information();
    elephant.eat();

    // We can define array with all animals
    System.out.println(" -------------Array-------------- ");
    Animal[] animals = new Animal[]{ tiger, snake, bird, elephant};

    for (Animal animal : animals) {
      System.out.println(" >> Name : " + animal.getName());
      animal.information();
      animal.eat();
    }

  }
}
