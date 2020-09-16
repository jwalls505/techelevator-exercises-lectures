package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int numberofRacoons = 3;
		int numberofDinners = 2;
		int leftOverRaccoons = numberofRacoons - numberofDinners;
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int numberOfLessBees = numberOfFlowers - numberOfBees;
		System.out.println(numberOfLessBees);
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int lonelyPigeon = 1;
		int anotherPigeon = 1;
		int addedPigeons = lonelyPigeon + anotherPigeon;
		System.out.println(addedPigeons);
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int sittingOwls = 3;
		int moreOwls = 2;
		int onTheFence = sittingOwls + moreOwls;
		System.out.println(onTheFence);

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int workingBeavers = 2;
		int wentForASwim = 1;
		int leftWorkingBeavers = workingBeavers - wentForASwim;
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int toucansOnTree = 2;
		int moreToucans = 1;
		int totalToucans = toucansOnTree + moreToucans;
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int numberOfSquirrels = 4;
		int numberOfNuts = 2;
		int lessNumberofNuts = numberOfSquirrels - numberOfNuts;
        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		float quarter = (float) .25;
		float dime = (float) .10;
		float nickel = (float) .05;
		float totalMoney = quarter + dime + (nickel + nickel);
		System.out.println(totalMoney);
        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int brierTotalMuffins = 18;
		int macAdamsTotalMuffins = 20;
		int flanneryTotalMuffins = 17;
		int totalNumberOfMuffins = brierTotalMuffins + macAdamsTotalMuffins + flanneryTotalMuffins;
		System.out.println(totalNumberOfMuffins);
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		float priceOfYoyo = (float).24;
		float priceOfWhistle = (float).14;
		float totalAmountSpent = priceOfYoyo - priceOfWhistle;
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		int totalNumberofMarshmallows = largeMarshmallows + miniMarshmallows;
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int snowAtHilts = 29;
		int snowAtSchool = 17;
		int totalNumberofInches = snowAtHilts + snowAtSchool;
		
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		int hiltTotalMoney= 10;
		int toyTruck = 3;
		int pencilCase = 2;
		int leftOverMoney = hiltTotalMoney - (toyTruck + pencilCase);
		System.out.println(leftOverMoney);
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int joshTotalMarbels = 16;
		int lostMarbels = 7;
		int totalMarbelslost = joshTotalMarbels - lostMarbels;
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int megansSeashells = 19;
		int wantedNumOfSeashells = 25;
		int missingSeashells = wantedNumOfSeashells - megansSeashells;
		System.out.println(missingSeashells);
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int totalNumberofBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = totalNumberofBalloons - redBalloons;
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int booksOnShelf = 38;
		int addedBooks = 10;
		int totalShelvedBooks = booksOnShelf + addedBooks;
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int legsofOneBee = 6;
		int numOfBees = 8;
		int totalNumOfBeeLegs = legsofOneBee * numberOfBees; 
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		float iceCreamCone = (float) .99;
		float twoIceCreamCones = iceCreamCone * 2;
		System.out.println(twoIceCreamCones);
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int currentRockBorder = 64;
		int completedRockBorder = 125;
		int neededRocks = completedRockBorder - currentRockBorder;
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int marblesOfHilt = 38;
		int lostMarbles = 15;
		int remainderMarbles = marblesOfHilt - lostMarbels;
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int totalMiles = 78;
		int milesDriven = 32;
		int milesLeft = totalMiles - milesDriven;
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		int minsOnSat = 90;
		int minsOnSun = 45;
		int totalMins = minsOnSat + minsOnSun;
		System.out.println(totalMins);
        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		float costOfHotDog = (float) .50;
		int numOfHotDogs = 6;
		float totalCostOfHotDogs = (float) numOfHotDogs * costOfHotDog;
		System.out.println(totalCostOfHotDogs);
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		float totalHiltMoney = (float) .50;
		float priceOfPencil = (float) .07;
		int numOfBoughtPencils = (int) (totalHiltMoney / priceOfPencil);
		System.out.println(numOfBoughtPencils);
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int numOfButterflies = 33;
		int orangeButterflies = 20;
		int totalRedButterflies = numOfButterflies - orangeButterflies;
		System.out.println(totalRedButterflies);
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		float katesMoney = (float) 1.00;
		float candyCost =  (float) .54;
		float katesChange = (int) katesMoney - candyCost;
		System.out.println(katesChange);
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int treesInBackyard = 13;
		int treesToPlant = 12;
		int totalNumTrees = treesInBackyard + treesToPlant;
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int oneDay = 24;
		int daysToGrandma = oneDay * 2;
		System.out.println(daysToGrandma);
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int cousinsOfKim = 4;
		int piecesOfGum = 5;
		int allTheGum = cousinsOfKim * piecesOfGum;
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double moneyForDan = 3.00;
		double candyBarCost = 1.00;
		double moneyLeftOver = moneyForDan - candyBarCost;
		System.out.println(moneyLeftOver);
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatsOnLake = 5;
		int peopleOnBoats = 3;
		int numOfPeople = boatsOnLake * peopleOnBoats;
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int totalLegos = 380;
		int legosLost = 57;
		int currentNumOfLegos = totalLegos - legosLost;
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int bakedMuffins = 35;
		int muffinsToBake = 83;
		int amountMuffinsNeeded = muffinsToBake - bakedMuffins;
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willyTotalCrayons = 1400;
		int lucyTotalCrayons = 290;
		int crayonsDifference = willyTotalCrayons - lucyTotalCrayons;
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickersOnPage = 10;
		int numOfPages = 22;
		int totalNumOfStickers = stickersOnPage * numOfPages;
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		int cupCakesTotal = 96;
		int childrenToShare = 8;
		int sharedCupCakes = cupCakesTotal / childrenToShare;
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int gingerBreadCookies = 47;
		int jarVolume = 6;
		int cookiesInJars = (int) 47 / 6;
		System.out.println(cookiesInJars);
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int croissantsPrepared = 59;
		int luckyNeighbors = 8;
		int croissantsLeft = 59 % 8;
		System.out.println(croissantsLeft);
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int oatmealBaked = 276;
		int numOfCookies = 12;
		int traysNeeded = oatmealBaked / numOfCookies;
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int biteSizedPretzels = 480;
		int oneServing = 12;
		int servingsPrepared = biteSizedPretzels / oneServing;
		System.out.println(servingsPrepared);
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int lemonCupCakes = 53;
		int cupCakesLeftAtHome = 2;
		int cupCakeBoxes = (lemonCupCakes - cupCakesLeftAtHome) / 3;
		System.out.println(cupCakeBoxes);
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int carrotSticks = 74;
		int peopleServicedCarrots = 12;
		int carrotsLeftOver = carrotSticks % peopleServicedCarrots;
		System.out.println(carrotsLeftOver);
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int allTeddyBears = 98;
		int maxShelfStorage = 7;
		int numOfShelvesNeeded = allTeddyBears / maxShelfStorage;
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int totalPictures = 480;
		int picturesPerAlbum = 20;
		int albumsNeeded = totalPictures / picturesPerAlbum;
		System.out.println(albumsNeeded);
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int tradingCards = 94;
		int boxCapacity = 8;
		int filledBoxes = (int) tradingCards / boxCapacity;
		int unfilledBox = tradingCards % boxCapacity;
		System.out.println(unfilledBox);
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int bookTotal = 210;
		int repairedShelves = 10;
		int booksOnShelves = bookTotal / repairedShelves;
		System.out.println(booksOnShelves);
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int croissantsBaked = 17;
		int guests = 7;
		int croissantperguest = (int) croissantsBaked / guests;
		System.out.println(croissantperguest);
        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		float billPaints = (float) 2.15;
		float jillPaints = (float) 1.90;
		int totalRoomFootage = 168;
		float timeForFiveRooms = totalRoomFootage / (billPaints + jillPaints);
		System.out.println(timeForFiveRooms);   
		                    
		
        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
		String myFirstName = "Jesse ";
		String myMiddleInit = "G.\"";
		String myLastName = "\"Walls, ";
		String fullName =  myLastName +  myFirstName + myMiddleInit;
		System.out.println(fullName);
        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
		int distBetweenCities = 800;
		int milesTravelled = 537;
		int percCompeleted =  (milesTravelled * 100) / distBetweenCities;
		System.out.println(percCompeleted);

	}

}
