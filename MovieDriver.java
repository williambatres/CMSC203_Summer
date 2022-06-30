/*
 * Class: CMSC203 
 * Instructor: Khandan Monsh
 * Description: Creates a driver class to the file Movie.java and uses the methods and 
 * Constructors to utilize the scanners defined in this driver and reads the user input
 * to later display the input. Then iterates the code once again if the user would
 * like to enter a new movie
 * Due: 2/14/2022
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: William Batres
*/


import java.util.Scanner;

public class MovieDriver {

	public static void main(String[] args) {
		// Char variable for switch structure used later in the code
		char yesOrNoDecision;
		//boolean variable set to false for the do-while loop
		boolean yesOrNoFlag = false;
		
		//All Scanner object definitions that take input from the keyboard
		Scanner movieInput = new Scanner(System.in);
		Scanner userInput = new Scanner(System.in);
		Scanner yesOrNoInput = new Scanner(System.in);
		Movie newMovie = new Movie();


		
		
		//do loop to iterate the loop once and asks the user 
		//if they would like to enter a new movie which will 
		//iterate the loop once again
		do 
		{
			//promps user for the movie title
			System.out.print("Please enter the name" +
					" of a movie \n");
			// gets input from user 
			newMovie.setTitle(movieInput.nextLine());

			//promps user for the movie rating
			
			System.out.println("Please enter the rating" +
					" of the movie");
			// gets input from user 
			newMovie.setRating(movieInput.nextLine()) ;
			
			//promps user for the sold tickets of the movie
			System.out.println("Please enter the amount" +
						" of tickets sold for this movie");
			// gets input from user 
			newMovie.setSoldTickets(movieInput.nextInt()) ;
			
			//displays all the information utilizing the "toString" method
			System.out.println(newMovie);
			
			System.out.println("Would you like to enter another?"+ 
							" (y or n)");
			//takes the users decision and assigns it to a char variable
			yesOrNoDecision = yesOrNoInput.next().charAt(0);
			switch(yesOrNoDecision)
			{
				case 'y':
				case 'Y':
				{
					yesOrNoFlag = true; // sets flag to true to enter a new movie
					break;
				}
				case 'n':
				case 'N':
				{
					yesOrNoFlag = false; // sets flag to false to terminate 
					break;
				}
			}
		movieInput.nextLine(); // to take the enter from the .nextInt()
								// and buffer for the next .nextLine()
		}while(yesOrNoFlag == true);
		
		System.out.println("Goodbye");
		System.out.println("Programmers name: William Batres");
		
		//closes all the scanner objects used 
		movieInput.close();
		userInput.close();
		yesOrNoInput.close();
	}

}
