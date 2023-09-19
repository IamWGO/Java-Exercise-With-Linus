package com.wgoweb.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileWithBufferedReader {
  public static void main(String[] args) {
    String filename = "src/ContentFile.text";
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
      String inputLine;
      while((inputLine = reader.readLine()) != null) {
        System.out.println("Content : " + inputLine);
      }

    } catch(FileNotFoundException ex) {
      System.out.println("File not found: " + filename);
    } catch(IOException ex) {
      System.out.println("Error - " + ex.getMessage());
    } catch(Exception ex) {
      System.out.println("Error processing file - " + ex.getMessage());
    }
  }
}