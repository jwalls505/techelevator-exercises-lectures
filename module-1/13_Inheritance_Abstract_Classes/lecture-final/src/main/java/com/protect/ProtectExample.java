package com.protect;

import com.techelevator.Cat;
import com.techelevator.FarmAnimal;

public class ProtectExample {

	public static void main(String[] args) {
		
		FarmAnimal myFarmAnimal = new Cat("Jorge Jr", "Meow");
		
//		myFarmAnimal.getTypeOfAnimal(); I cannot do this because getTypeOfAnimal is protected and in a different package.
	}
	
}
