package com.wgoweb.exception;

import java.io.*;

public class SampleException {
  public static void main(String[] args) {
    /*
    String fileName = "example.txt";
    file will save in root/example.text
    * */
    String filename = "src/main/java/com/wgoweb/exception/example.txt";

    try {
      File file = new File(filename);
      if (file.createNewFile()) {
        System.out.println("File created: " + file.getName());
        // You can also write content to the file if needed
        FileWriter writer = new FileWriter(file);
        writer.write("Hello, World!");
        writer.close();
        System.out.println("Content written to the file.");
      } else {
        System.out.println("File already exists.");

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
          String inputLine;
          while((inputLine = reader.readLine()) != null) {
            System.out.println("Content : " + inputLine);
          }
        } catch(IOException ex) {
          System.out.println("Error - " + ex.getMessage());
        } catch(Exception ex) {
          System.out.println("Error processing file - " + ex.getMessage());
        }
      }
//    } catch(FileNotFoundException ex) {
//      System.out.println("File not found: " + filename);
    } catch (IOException ex) {
      System.out.println("An error occurred." + ex);
    }

  }
}

/*
* import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFileExample {
    public static void main(String[] args) {
        String fileName = "example.txt";

        try {
            File file = new File(fileName);

            // Check if the file doesn't exist
            if (!file.exists()) {
                // Create a new file
                file.createNewFile();
                System.out.println("File created: " + file.getName());

                // You can also write content to the file if needed
                FileWriter writer = new FileWriter(file);
                writer.write("Hello, World!");
                writer.close();
                System.out.println("Content written to the file.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

* */