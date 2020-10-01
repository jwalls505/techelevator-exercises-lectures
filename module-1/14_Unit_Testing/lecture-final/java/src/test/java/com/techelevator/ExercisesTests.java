package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ExercisesTests {

	@Test
	public void loneSum_with_three_different_integers_returns_sum_of_all() {
		// Arrange
		Exercises myExercises = new Exercises();

		// Act
		int sum = myExercises.loneSum(1, 2, 3);

		// Assert
		Assert.assertEquals(6, sum);
	}

	@Test
	public void loneSum_with_two_identical_integers_returns_the_different_one() {
		// Arrange
		Exercises myExercises = new Exercises();

		// Act
		int sum = myExercises.loneSum(3, 2, 3);

		// Assert
		Assert.assertEquals(2, sum);
	}
	
	@Test
	public void loneSum_with_two_identical_integers_returns_the_different_one2() {
		// Arrange
		Exercises myExercises = new Exercises();

		// Act
		int sum = myExercises.loneSum(3, 3, 2);

		// Assert
		Assert.assertEquals(2, sum);
	}

	@Test
	public void loneSum_with_all_identical_integers_returns_zero() {
		// Arrange
		Exercises myExercises = new Exercises();

		// Act
		int sum = myExercises.loneSum(3, 3, 3);

		// Assert
		Assert.assertEquals(0, sum);
	}

}
