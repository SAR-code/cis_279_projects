/*************************************************************
 * Program : Main.java
 * Purpose : This program demonstrates and displays how
 *           one dimensional arrays work
 *
 * Created : 9/27/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Declare an array of 10 integers
        int[] numbers = new int[10];

        // Invoke function to assign random values to the array
        assignRandomValues(numbers);

        // Display original (unsorted) array
        System.out.println("Before the sorting:");
        displayArray(numbers);

        // Sort the array using insertion sort
        insertionSort(numbers);

        // Display newly sorted array
        System.out.println("After the sorting:");
        displayArray(numbers);

        // Display results (max, min, sum, avg) using methods
        displayResults(numbers);

    }

    // Method to assign random values to each element of the array
    public static void assignRandomValues(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(300) + 1;
        }
    }

    // Method to display all elements of the array
    public static void displayArray(int[] arr) {
        System.out.println("*******************************************************");
        System.out.println("Array Elements");
        System.out.println("*******************************************************");

        // Display the array values
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println("\n");
    }

    // Method to sort the array using insertion sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Organizes it from least to greatest
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Method to find the index of the highest value in the array
    public static int indexOfMax(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // Method to find the index of the lowest value in the array
    public static int indexOfMin(int[] arr) {
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    // Method to calculate the sum of all array elements
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }

    // Method to calculate the average of array elements
    public static double averageArray(int[] arr) {
        int sum = sumArray(arr);
        return (double) sum / arr.length;
    }

    // Method to display results of array processing
    public static void displayResults(int[] arr) {
        // Declare required variables
        int maxIndex = indexOfMax(arr);
        int minIndex = indexOfMin(arr);
        int sum = sumArray(arr);
        double avg = averageArray(arr);

        // Outputs the results
        System.out.println("*******************************************************");
        System.out.println("Results of Array Processing");
        System.out.println("*******************************************************");
        System.out.println("The index of the highest value is " + maxIndex + ". It’s value is " + arr[maxIndex] + ".");
        System.out.println("The index of the lowest value is " + minIndex + ". It’s value is " + arr[minIndex] + ".");
        System.out.println("The sum of the array elements is " + sum + ".");
        System.out.println("The average of the array elements is " + avg + ".");
    }
}