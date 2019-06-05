/* Ava's Main Program
   Written by Joseph Rodriguez on 4/18/19

   Last Updated: 5/27/19
   UPDATE 1: Fixed the code format and code output to be a lot cleaner
             Updated Time format to be more readable
             Changed in class methods to public instead of private
             Switched 'if' statements determining choice to a 'switch' statement
             Added simpleMath method that answers simple math statements with user check for choices
             Added "Today's Date" as an option
*/
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

public class AvaMain {

    public static void main(String[] args) {

        int choice;
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Scanner input = new Scanner(System.in);

        System.out.println();
        displayGreeting();

        // displaying choices
        System.out.println("1 - What does AVA mean?");

        System.out.println("2 - Display the Time");

        System.out.println("3 - Basic Math");

        System.out.println("4 - Today's Date");

        System.out.println("*******************************");
        System.out.println();

        System.out.print("Your choice >> ");
        choice = input.nextInt();

        // space
        System.out.println();

        // determining the choice
        switch(choice) {
            case 1:
                System.out.println("AVA stands for Automated Virtual Assistant. \nMy creator came up with that name for me!");
                break;
            case 2:
                System.out.println("The time is currently " + now.format(formatter));
                break;
            case 3:
                simpleMath();
                break;
            case 4:
                System.out.println("It is the " + today.getDayOfMonth() + " of " + today.getMonth());
                break;
                // space for other cases
            default:
                System.out.println("Error: Invalid choice");
        }

    }

    // ********* methods ***********

    public static void displayGreeting() {
        System.out.println("Hello! My name is AVA!");
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



}
