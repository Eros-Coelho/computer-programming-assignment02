/*
Name: Eros Lima Coelho
ID: 3151957
Date of Submission: 31/03/2024
 */

package griffith;

import java.util.Scanner;

//control + alt + L to indent the code

public class Lab {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        Task 1: A simple calculator using java

//        the user is presented with the 3 possible operations: adding, subtraction and division

        System.out.println("Operations (+, -, /): ");

//        First, the user chooses the operation, than the 2 operands

        System.out.println("Enter an operator then two numbers: ");
        char op = scanner.next().charAt(0);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

//        using switch for each of the 3 cases, plus the default; if an invalid symbol is added, show "invalid operand"

        switch (op) {
            case '+':
                System.out.println("Result: " + (num1 + num2));
                break;
            case '-':
                System.out.println("Result: " + (num1 - num2));
                break;
            case '/':
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                } else { // if 2nd number is zero, the program tells the user they cannot divide by zero
                    System.out.println("Cannot divide by zero!");
                }
                break;
        }
        if (op != '+' && op != '-' && op != '/') {
            System.out.println("Invalid operand: " + op);
        }


//        Task 3: Modifying the code on assignment one to work with entire words rather than just one character

        System.out.print("Enter the amount of positions to shift: ");
        int shift = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter the word ot be encoded: ");
        String word = scanner.nextLine();

        StringBuilder encodedWord = new StringBuilder();

//        Using for loop to encode each letter of the word put in by the user

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

//            if the encoded character would go beyond z or Z, do the encoding as normal but subtract 26, which will make the program start counting again form the beginning of the alphabet

            if (Character.isLetter(ch)) {
                char encodedChar = (char) (ch + shift);
                if ((Character.isLowerCase(ch) && encodedChar > 'z') ||
                        (Character.isUpperCase(ch) && encodedChar > 'Z')) {
                    encodedChar = (char) (ch + shift - 26);
                }
                encodedWord.append(encodedChar);
            } else { // if the character put in isn't a letter, just keep it as it is
                encodedWord.append(ch);
            }
        }

        System.out.println("The encoded word is: " + encodedWord.toString());


//        Task 4: Letter guessing game. The program generates a random letter and the user has unlimited guesses. If their guess is close, it's warm, very close is hot, and far from it is cold.

        char value = (char) ('a' + (int) (Math.random() * 26));

        System.out.print("Please enter a guess (lowercase letter: ");
        char guess = scanner.next().charAt(0);

        int count = 0;

//    As long as the guess is incorrect, the program will tell the user if the last guess was close or not, then ask for them to enter another guess

        while (guess != value) {
            if (Math.abs(guess - value) <= 4) {
                System.out.println("Hot");
            } else if (Math.abs(guess - value) <= 8) {
                System.out.println("Warm");
            } else {
                System.out.println("Cold");
            }
            System.out.print("Please enter a guess: ");
            guess = scanner.next().charAt(0);
            count++;
        }

        System.out.println("Correct! The letter was " + value);
        System.out.println("You guessed the letter in " + count + " tries");

//        Task 5: The program makes a pattern put in by the user to repeat how many times they desire in a triangle format

        System.out.print("Please enter a pattern: ");
        String pattern = scanner.nextLine();

        System.out.print("Please enter a start amount: ");
        int start = scanner.nextInt();

        System.out.print("Please enter an end amount: ");
        int end = scanner.nextInt();

//        start loop; the loop continues until the "row" reaches "end"
        int row = start;

        while (row <= end) {
            int spaces = end - row;
            int repetitions = row;

//      spaces increase with the loop to form the triangle shape
            int spaceCount = 0;
            while (spaceCount < spaces) {
                System.out.print(" ");
                spaceCount++;
            }
            int repetitionCount = 0;
            while (repetitionCount < repetitions) {
                System.out.print(pattern);
                repetitionCount++;
            }
            System.out.println();
            row++;
        }
        scanner.close();
    }
}