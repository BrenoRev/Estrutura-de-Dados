package MergeSort;

import java.util.Arrays;
import java.util.Scanner;

public class Merge {
    // coded by
    // Breno Silva

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for (int indexI = 0; indexI <= size; indexI++) {
            int sizeOfArray = scanner.nextInt();
            int[] numbersArray = new int[sizeOfArray];
            for (int indexJ = 0; indexJ < sizeOfArray; indexJ++) {
                numbersArray[indexJ] = scanner.nextInt();
            }
            mergeSortArray(numbersArray, 0, numbersArray.length - 1);
            System.out.println(Arrays.toString(numbersArray));
        }
        scanner.close();
    }

    public static void mergeSortArray(int[] numbersArray, int left, int right) {
        int middle = (left + right) / 2;
        if (left < right) {
            mergeSortArray(numbersArray, left, middle);
            mergeSortArray(numbersArray, middle + 1, right);
            merge(numbersArray, left, right);
        }
    }

    public static void merge(int[] array, int left, int right) {
        int[] temporaryArray = new int[array.length];
        for (int index = left; index <= right; index++) {
            temporaryArray[index] = array[index];
        }
        int middle = (left + right) / 2;
        int i1 = left;
        int i2 = middle + 1;
        for (int current = left; current <= right; current++) {
            if (i1 == middle + 1) {
                array[current] = temporaryArray[i2++];
            } else if (i2 > right) {
                array[current] = temporaryArray[i1++];
            } else if (temporaryArray[i1] <= temporaryArray[i2]) {
                array[current] = temporaryArray[i1++];
            } else {
                array[current] = temporaryArray[i2++];
            }
        }
    }
}