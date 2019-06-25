/* Ava's Main Program
   Written by Joseph Rodriguez on 4/18/19

   Last Updated: 6/24/19

   (5/27/19)
   UPDATE 1: Fixed the code format and code output to be a lot cleaner
             Updated Time format to be more readable
             Changed in class methods to public instead of private
             Switched 'if' statements determining choice to a 'switch' statement
             Added simpleMath() method that answers simple math statements with user check for choices
             Added "Today's Date" as an option

   UPDATE 2: Cleaned up previous code
             Created methods from old code to clean up main method and increase efficiency
             Added a newUser method that addresses new users by their name
             Took out statement in displayGreeting() that stated "Hi! My name is AVA." to accommodate name feature
             Added a returningUser method that recognizes the returning user if yes is inputted. (to an extent of course ;) )
             Added a new method that asks user if they have another question. If so, the program reprompts previous questions


*/
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;
import java.lang.*;

public class AvaMain {

    public static void main(String[] args) {

        System.out.println();

        // checks for returning user
        returningUser();

        // displays options and answers
        displayChoices();

    }

    // ********* methods ***********

    public static void displayGreeting() {
        System.out.println("I am your personal assistant");
        System.out.println("What would you like me to accomplish for you?");
        System.out.println("Your options are as follows");
        System.out.println("(Simply type the corresponding number)");
        System.out.println();
        System.out.println("*******************************");
    }

    public static void simpleMath() {

        int choice, num1, num2, answer;
        Scanner input = new Scanner(System.in);

        System.out.println("What operation do you need? \n1. Addition \n2. Subtraction \n3. Multiplication \n4. Division");

        System.out.print("Your choice >> ");

        // checks for incorrect choice input
        while(true) {
            choice = input.nextInt();
            if(choice > 0 && choice < 5)
                break;
            System.out.println();
            System.out.println("Error: Invalid choice");
            System.out.print("Your choice >> ");
        }

        System.out.println();

        System.out.println("What is the first number?");
        System.out.print("Your choice >> ");

        num1 = input.nextInt();

        System.out.println();

        System.out.println("What is the second number?");
        System.out.print("Your choice >> ");
        num2 = input.nextInt();

        System.out.println();

        // solves the problem based on user input
        switch (choice) {
            case 1:
                answer = num1 + num2;
                System.out.println("The answer is " + answer);
                break;
            case 2:
                answer = num1 - num2;
                System.out.println("The answer is " + answer);
                break;
            case 3:
                answer = num1 * num2;
                System.out.println("The answer is " + answer);
                break;
            case 4:
                answer = num1 / num2;
                int remainder = num1 % num2;
                System.out.println("The answer is " + answer + " with a remainder of " + remainder);
                break;
            default:
                System.out.println("Error: Invalid choice");
                break;
        }

    }

    public static void newUser() {

        String name;
        Scanner input = new Scanner(System.in);

        System.out.println("Hi there! What is your name?");
        System.out.print("Name: ");

        name = input.nextLine();

        System.out.println();

        System.out.println("Hi, " + name + "! My name is AVA.");
    }

    public static void returningUser() {

        String name;
        int returning;
        Scanner input = new Scanner(System.in);

        System.out.println();

        // asks if the user is new or returning
        System.out.println("Are you a returning user?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");

        System.out.print("Your choice >> ");
        returning = input.nextInt();

        System.out.println();

        // decides if user is returning or not
        while (true) {
            if (returning == 1) {

                // name is set to mine
                name = "Joseph";

                System.out.println("Welcome back, " + name + "!");
                System.out.println("What do you need?");
                System.out.println();
                break;

            } else if (returning == 2) {

                //If not, it calls newUser requesting a name and displays greeting
                newUser();
                displayGreeting();
                break;

            } else {
                System.out.println("Error: Invalid Choice");
                System.out.print("Your choice >> ");
                returning = input.nextInt();

                System.out.println();
            }
        }

    }

    public static void displayChoices() {

        int choice;
        Scanner input = new Scanner(System.in);

        // variables for time and date choice
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("1 - What does AVA mean?");

        System.out.println("2 - Display the Time");

        System.out.println("3 - Basic Math");

        System.out.println("4 - Today's Date");

        System.out.println("5 - End Program");

        System.out.println("*******************************");
        System.out.println();

        System.out.print("Your choice >> ");
        choice = input.nextInt();

        System.out.println();

        // determines what answer to give
        switch(choice) {
            case 1:
                System.out.println("AVA stands for Automated Virtual Assistant. \nMy creator came up with that name for me!");
                additionalQuestion();
                break;
            case 2:
                System.out.println("The time is currently " + now.format(formatter));
                additionalQuestion();
                break;
            case 3:
                simpleMath();
                additionalQuestion();
                break;
            case 4:
                System.out.println("It is the " + today.getDayOfMonth() + " of " + today.getMonth());
                additionalQuestion();
                break;
            // space for future cases
            default:
                System.out.println("Error: Invalid choice");
                break;
        }

    }

    public static void additionalQuestion() {

        int choice;
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("Is there anything else I can help you with?");
        System.out.println("** 1 for Yes or 2 for No **");
        System.out.println();
        System.out.print("Your choice >> ");
        choice = input.nextInt();

        System.out.println();

        switch(choice) {
            case 1:
                System.out.println();
                System.out.println("What else would you like to know?");
                System.out.println();
                displayChoices();
                break;
            case 2:
                System.out.println("Have a great day!");
                break;
            default:
                System.out.println("Error: Invalid Choice");
                additionalQuestion();
                break;


        }

    }
}



