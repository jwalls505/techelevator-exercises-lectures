/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}


/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(firstParameter = 0, secondParameter = 0) {
  if (typeof firstParameter === Number && typeof secondParameter === Number) {
    return firstParameter * secondParameter;
  }
  return 0;
}

/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */



/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;

  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

/*
 *
const listOfQuirks = ['odd', 'crashes a lot', 'spills things'];
createSentenceFromUser('Walt', 20, listOfQuirks, '*');

Walt is currently 20 years old. Their quirks are odd*crashes a lot*spills things

*/

/**
 * Create a sentence describing the person and their quirks.
 * 
 * @param {String} name is the person's name
 * @param {number} age the person's age
 * @param {String[]} listOfQuirks their list of quirks
 * @param {String} separator the separator to join quirks on
 * @returns A sentence describing the person and their quirks.
 */
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 * 
 * [3, 1, 2, 5]
 * return (0) + 3;
 * return (3) + 1;
 * return (3 + 1) + 2;
 * return (3 + 1 + 2) + 5;
 */
function sumAllNumbers(numbersToSum) {
  return numbersToSum.reduce((accumulator, currentValue) => {
    return accumulator + currentValue;
  }, 0);
}

/* another way to do it, with more code.
 */

function sum(accumulator, currentValue) {
  return accumulator + currentValue;
}

function sumAllNumbers(numbersToSum) {
  const sum = numbersToSum.reduce(sum, 0);

  return sum;
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {

  return numbersToFilter.filter(x => x % 3 == 0);

}

function isDivisibleByThree(num) {
  if (num % 3 == 0) {
    return true;
  }

  return false;
}

function allDivisibleByThree(numbersToFilter) {
  const filteredArray = numbersToFilter.filter(isDivisibleByThree);
  return filteredArray;
}

/* map to squares
   [1, 2, 3] -> [1, 4, 9]
 */

function mapToSquares(numbersToSquare) {
  return numbersToSquare.map((theElement) => {
    const square = theElement * theElement;
    return square;
  });
}

function square(x) {
  return x * x;
}

function mapToSquares(numbersToSquare) {
  return numbersToSquare(square);
}

function sumAllPositivesInArray(numbers) {
  let sum = 0;
  for (let i = 0; i < numbers.length; i++) {
    if (numbers[i] > 0) {
      sum += numbers[i];
    }
  }
  return sum;
}

function sumAllPositivesInArray(numbers) {
  return numbers.filter(x => x > 0).reduce((acc, curr) => acc + curr, 0);
}

function iterate(numbers) {
  numbers.forEach((num) => {
    console.log(num);
  });
}