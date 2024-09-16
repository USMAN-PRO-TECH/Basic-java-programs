import java.util.InputMismatchException;
import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Check if a number is a palindrome
            checkNumberPalindrome(scanner);

            // Check if a string is a palindrome
            checkStringPalindrome(scanner);

            // Check if an array is a palindrome
            checkArrayPalindrome(scanner);

        } finally {
            scanner.close(); // Ensure the scanner is closed to prevent resource leaks
        }
    }

    // Method to check if a number is a palindrome
    public static void checkNumberPalindrome(Scanner scanner) {
        try {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();
            if (number < 0) {
                System.out.println("Negative numbers cannot be palindromes. Please enter a positive number.");
            } else {
                if (isPalindrome(number)) {
                    System.out.println(number + " is a palindrome.");
                } else {
                    System.out.println(number + " is not a palindrome.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    // Method to check if a string is a palindrome
    public static void checkStringPalindrome(Scanner scanner) {
        System.out.print("Enter a string: ");
        String str = scanner.nextLine().trim();
        if (str.isEmpty()) {
            System.out.println("Empty string entered. Please enter a valid string.");
        } else {
            if (isPalindrome(str)) {
                System.out.println("\"" + str + "\" is a palindrome.");
            } else {
                System.out.println("\"" + str + "\" is not a palindrome.");
            }
        }
    }

    // Method to check if an array is a palindrome
    public static void checkArrayPalindrome(Scanner scanner) {
        try {
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();

            if (size <= 0) {
                System.out.println("Array size must be a positive integer. Please try again.");
                return;
            }

            int[] arr = new int[size];
            System.out.println("Enter the elements of the array:");

            for (int i = 0; i < size; i++) {
                try {
                    System.out.print("Element " + (i + 1) + ": ");
                    arr[i] = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter an integer.");
                    scanner.nextLine(); // Clear the invalid input
                    i--; // Decrement i to retry the current index
                }
            }

            if (isPalindrome(arr)) {
                System.out.println("The array is a palindrome.");
            } else {
                System.out.println("The array is not a palindrome.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Array size must be an integer.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    // Helper method to determine if an integer is a palindrome
    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reversed = 0;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return originalNumber == reversed;
    }

    // Helper method to determine if a string is a palindrome
    public static boolean isPalindrome(String str) {
        String cleanedStr = str.replaceAll("\\s+", "").toLowerCase();
        int length = cleanedStr.length();

        for (int i = 0; i < length / 2; i++) {
            if (cleanedStr.charAt(i) != cleanedStr.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Helper method to determine if an array is a palindrome
    public static boolean isPalindrome(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length / 2; i++) {
            if (arr[i] != arr[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
