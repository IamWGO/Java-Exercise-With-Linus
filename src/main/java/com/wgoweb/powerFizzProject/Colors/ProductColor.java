package com.wgoweb.powerFizzProject.Colors;

public class ProductColor extends Color{

  @Override
  String getText() {
    return "\u001B[35m"; //PURPLE
  }

  @Override
  String getBackground() {
    return "\u001B[45m"; //PURPLE
  }
}
