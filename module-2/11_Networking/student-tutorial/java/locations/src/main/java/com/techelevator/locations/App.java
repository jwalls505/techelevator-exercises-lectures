package com.techelevator.locations;

import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

public class App {
  private static final String API_URL = "http://localhost:3000/locations";

  public static void main(String[] args) {
	run();
	Scanner s = new Scanner(System.in);
	printGreeting();
	int menuSelection = 0;
	try {
		menuSelection = Integer.parseInt(s.nextLine());
		}catch (NumberFormatException exception) {
			System.out.println("Error parsing the input for menu selection.");
	}
	System.out.println("");
	if (menuSelection == 1) {
		// list locations
		RestTemplate restTemplate = new RestTemplate();
		Location[] locations = restTemplate.getForObject(API_URL, Location[].class);
		printLocations(locations);
	} else if (menuSelection == 2) {
		s.close();
		System.exit(0);
	} else {
		System.out.println("Invalid Selection");
	}
	int id = 0;
	try {
	  id = Integer.parseInt(s.nextLine());
	} catch (NumberFormatException exception) {
	  System.out.println("Error parsing the input for location id.");
	}
	
	
   
  }

  private static void run() {
  }

  private static void printGreeting() {
    System.out.println("");
    System.out.println("Welcome to Tech Elevator Locations. Please make a selection: ");
    System.out.println("1: List Tech Elevator Locations");
    System.out.println("2: Exit");
    System.out.println("");
    System.out.print("Please choose an option: ");
  }

  private static void printLocations(Location[] locations) {
    System.out.println("--------------------------------------------");
    System.out.println("Locations");
    System.out.println("--------------------------------------------");
    for (Location location : locations) {
      System.out.println(location.getId() + ": " + location.getName());
    }
    System.out.println("");
    System.out.print("Please enter a locsation id to get the details: ");
  }

  private static void printLocation(Location location) {
    System.out.println("");
    System.out.println("--------------------------------------------");
    System.out.println("Location Details");
    System.out.println("--------------------------------------------");
    System.out.println("Id: " + location.getId());
    System.out.println("Name: " + location.getName());
    System.out.println("Address: " + location.getAddress());
    System.out.println("City: " + location.getCity());
    System.out.println("State: " + location.getState());
    System.out.println("Zip: " + location.getZip());
  }

}