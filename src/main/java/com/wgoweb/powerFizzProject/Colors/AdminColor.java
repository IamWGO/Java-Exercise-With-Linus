package com.wgoweb.powerFizzProject.Colors;

public class AdminColor extends Color{

  @Override
   String getText() {
    return "\u001B[34m";
  }

  @Override
   String getBackground() {
    return "\u001B[0m";
  }
}

/*
* System.out.println("\u001B[34m"
            + "This text is blue"
            + "\u001B[0m");
* */