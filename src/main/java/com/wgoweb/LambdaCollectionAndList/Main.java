package com.wgoweb.LambdaCollectionAndList;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {

    var door = new Product("Wooden Door", 35);
    var floorPanel = new Product("Floor Panel", 25);
    var window = new Product("Glass Window", 10);

    Collection<Product> original = new ArrayList<>();
    original.add(door);
    original.add(floorPanel);
    original.add(window);


    Stream<Product> filterResult =  original.stream().filter(p -> p.height > 10);
    System.out.println("---------------Filter height > 10---------------------");
    for (Product product: filterResult.toList()) {
      System.out.println(product.name + "  > " + product.height);
    }


    Collection<Product> removeObjects = original;
    System.out.println("-----------------remove objects-------------------");
    // add extra products
    removeObjects.add(door);
    removeObjects.add(floorPanel);
    removeObjects.add(window);

    List<Product> toRemove = new ArrayList<>();
    toRemove.add(door);
    //Multiple objects
    removeObjects.removeAll(toRemove);

    //remove a object
    removeObjects.remove(floorPanel);
    for (Product product: removeObjects.stream().toList()) {
      System.out.println(product.name);
    }

    Collection<Product> removeContains = original;
    System.out.println("-----------------remove toRemove::contains-------------------");
    List<Product> toRemove1 = new ArrayList<>();
    toRemove1.add(window);

    //Remove if products contain  toRemove
    // products2.removeIf(product -> toRemove.contains(product));
    //Lambda Remove if products contain  toRemove
    removeContains.removeIf(toRemove1::contains);

    for (Product product: removeContains.stream().toList()) {
      System.out.println(product.name);
    }


    Collection<Product> flatMap = original;
    System.out.println("--------------flatMap---------------------");
    Pattern spaces = Pattern.compile("\\s+");
    flatMap.stream()
            .flatMap(product -> spaces.splitAsStream(product.name))
            .forEach(System.out::println);

    System.out.println("--------------flatMap 2---------------------");
    List<Product> listProduct = flatMap.stream().toList();
    Stream<String> stream = listProduct.stream()
                    .flatMap(product -> spaces.splitAsStream(product.name));
    for (String string: stream.toList()) {
      System.out.println(" >>" + string);
    }

    System.out.println("-----------------Map-------------------");
    flatMap
            .stream()
            .map(product -> String.format("The %s is %.2f", product.name, (double)product.height))
            .forEach(System.out::println);

    System.out.println("-----------------collection map to list-------------------");
    List<String> listToCollection = original
            .stream()
            .filter(product -> product.height > 10)
            .map(Product::getName)
            .toList();

    listToCollection.forEach(System.out::println);

  }
}
