package com.wgoweb.powerFizzProject.utility.Colors;

public class AdminColor extends Color{

  @Override
   String getText() {
    return "\u001B[34m"; //BLUE
  }

  @Override
   String getBackground() {
    return "\u001B[44m"; //BLUE
  }
}

