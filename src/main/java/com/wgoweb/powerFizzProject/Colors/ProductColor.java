package com.wgoweb.powerFizzProject.Colors;

public class ProductColor extends Color{

  @Override
  String getText() {
    return "\u001B[35m";
  }

  @Override
  String getBackground() {
    return "\u001B[0m";
  }
}
