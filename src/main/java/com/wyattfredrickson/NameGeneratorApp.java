package com.wyattfredrickson;


import java.io.IOException;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/* 


I certify, that this computer program submitted by me is all of my own work, Wyatt Fredrickson.

Wyatt Fredrickson

09-08-2024

CSC 420 - Data Structures and Algorithms

Assigment Description: 

Random Name Generator App 

Sources: 

Introduction to Java Programming and Data Structures, Comprehensive Version, 12th Edition Y. Daniel Liang


*/ 


/**
 * Name Generator App - This program generates random names by combining first names and last names from files
 * Then it sorts the names by first name and last name and combines all names by first name
 */
public class NameGeneratorApp {
    

    /**
     * This method reads the first names from a file and loads them into an ArrayList collection
     * @return ArrayList<String> - A collection of first names
     * @throws IOException - An exception that occurs when reading the file
     */
    static ArrayList<String> fileLoadFirstNames() throws IOException {

        ArrayList<String> firstNames = new ArrayList<>(); // Create an ArrayList collection to store first names
        String fileName = "First-Names.txt"; // Create a string variable to store the file name

        // Use a try-with-resources block to read the file and load the first names into the ArrayList collection
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) { // Read each line of the file
                firstNames.add(line); // Add the first name to the ArrayList collection
            }
        } catch (FileNotFoundException e) { // Catch a FileNotFoundException exception
            System.out.println("File not found: " + fileName);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Opps! Something went wrong while reading the file: " + fileName);
            e.printStackTrace();
        }
        return firstNames; // Return the ArrayList collection of first names
        
    }


    /**
     * This method reads the last names from a file and loads them into an ArrayList collection
     * @return ArrayList<String> - A collection of last names
     * @throws IOException - An exception that occurs when reading the file
     */
    static ArrayList<String> fileLoadLastNames() throws IOException {
        ArrayList<String> lastNames = new ArrayList<>(); // Create an ArrayList collection to store last names
        String fileName = "Last-Names.txt"; // Create a string variable to store the file name

        // Use a try-with-resources block to read the file and load the first names into the ArrayList collection
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) { // Read each line of the file
                lastNames.add(line); // Add the first name to the ArrayList collection
            }
        } catch (FileNotFoundException e) { // Catch a FileNotFoundException exception
            System.out.println("File not found: " + fileName);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Opps! Something went wrong while reading the file: " + fileName);
            e.printStackTrace();
        }
        return lastNames; // Return the ArrayList collection of last names
    }


    /**
     * This method generates 20 random names by combining first names and last names
     * @return ArrayList<String> - A collection of generated names
     * @throws IOException - An exception that occurs when reading the file
     */
    static ArrayList<String> generateRandomNames() throws IOException{
        
        ArrayList<String> firstNames = fileLoadFirstNames(); // Load the first names from the file
        ArrayList<String> lastNames = fileLoadLastNames(); // Load the last names from the file

        // Create an ArrayList collection to store the generated names
        ArrayList<String> generatedNames = new ArrayList<>();

        // Create a Random object to generate random numbers
        Random random = new Random();

        // Generate the 20 random names
        while (generatedNames.size() < 20) {
            String firstName = firstNames.get(random.nextInt(firstNames.size())); // Get a random first name
            String lastName = lastNames.get(random.nextInt(lastNames.size())); // Get a random last name
            String fullName = firstName + " " + lastName; // Concatenate the first name and last name

            if (!generatedNames.contains(fullName)) { // Check if the full name is not in the ArrayList collection
                generatedNames.add(fullName); // Add the full name to the ArrayList collection
            }
        }
        return generatedNames; // Return the ArrayList collection of generated names
    }


    /**
     * This method sorts the names by first name and displays them to the console
     * @param generatedNames - A collection of generated names
     */
    static void sortNamesByFirstName(ArrayList<String> generatedNames) {
        // Sort by First Name and display to the console
        Collections.sort(generatedNames);

        System.out.println("Sorted by First Name");
        for (String name : generatedNames) {
            System.out.println(name); 
        }
    }


    /**
     * This method sorts the names by last name and displays them to the console
     * @param generatedNames - A collection of generated names
     */
    static void sortNamesByLastName(ArrayList<String> generatedNames) {
        Collections.sort(generatedNames, (name1, name2) -> {
            String lastName1 = name1.split(" ")[1]; 
            String lastName2 = name2.split(" ")[1]; 
            return lastName1.compareTo(lastName2); // Compare the last names
        });
        
        System.out.println("Sorted by Last Name"); 
        for (String name : generatedNames) { // Iterate through the generated names
            System.out.println(name); // Display the sorted names to the console
        }
    }


    /**
     * This method combines all names by first name and displays them to the console
     * @param generatedNames - A collection of generated names
     */
    static void combineNamesByFirstName(ArrayList<String> generatedNames) {
        // Map to store first name as key and list of full nammes
        Map<String, List<String>> map = new HashMap<>();
        
        for (String fullName : generatedNames) {
            String firstName = fullName.split(" ")[0]; // Extract the first name

            map.putIfAbsent(firstName, new ArrayList<>()); // Add the first name to the map if it does not exist
            map.get(firstName).add(fullName); // Add the full name to the list of full names
        }

        // Display the combined names by first name 
        System.out.println("Combine all names by First Name");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        
    }


    /**
     * Main method to run the Name Generator App 
     * @param args - Command line arguments
     * @throws IOException - An exception that occurs when reading the file
     */
    public static void main(String[] args) throws IOException {

        System.out.println("***Random Name Generator App***"); 
        System.out.println("Submitted by Wyatt Fredrickson - wfredric@csp.edu");
        System.out.println("I certify that this is my own work");


        // Generate 20 names by iterating through the first names and last names in the files
        System.out.println("Generated Names:");
        ArrayList<String> generatedNames = generateRandomNames();
        for (String name : generatedNames) {
            System.out.println(name);
        }


        // Sort by First Name
        sortNamesByFirstName(generatedNames);

        // Sort by Last Name
        sortNamesByLastName(generatedNames);

        // Combine all names by First Name
        combineNamesByFirstName(generatedNames);
    }
}