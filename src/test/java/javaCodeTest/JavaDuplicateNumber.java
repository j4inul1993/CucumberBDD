package javaCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class JavaDuplicateNumber {

	public static void main(String[] args) {
		// missingNum();
		// mainLast();
		// missingNumbers(null);
		// missingNinge();
		// mainTen();
		// missingEight();
		missingNumberThree();

	}

	public static void missingNum() {
		int[] input = { 1, 2, 3, 4, 5, 6, 8, 9 };
		int[] complete = new int[input[input.length - 1]]; // Gets the last item of input.length
		for (int i = 0; i < complete.length; i++) // Fills the array with ascending numbers 1-end
			complete[i] = i + 1;

		System.out.println(complete);
		System.out.println(input);
	}

	public static void missingNumTwo() {
		// 10 is missing
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12 };
		int N = 12;
		int idealSum = (N * (N + 1)) / 2;
		int sum = Arrays.stream(numbers).sum();

		int missingNumber = idealSum - sum;
		System.out.println(missingNumber);
	}

	public static void missingNumberThree() {
		int numbers[] = { 9, 6, 4, 5, 7, 0, 1 };
		Arrays.sort(numbers);
		int i = 1;

		while (i < numbers.length) {
			if (numbers[i] - numbers[i - 1] == 1) {
			} else {
				System.out.println("Missing number is " + (numbers[i - 1] + 1));
			}
			i++;
		}
	}

	public static void missingFour() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(9);
		numbers.add(6);
		numbers.add(4);
		numbers.add(5);
		numbers.add(7);
		numbers.add(0);
		numbers.add(1);
		Collections.sort(numbers);
		int i = 1;
		while (i < numbers.size()) {
			if (numbers.get(i) - numbers.get(i - 1) == 1) {

			} else {
				System.out.println("Missing number is " + (numbers.get(i - 1) + 1));
				numbers.add((numbers.get(i - 1) + 1));
				Collections.sort(numbers);
			}
			i++;
		}

	}

	public static void missingSix() {
		int[] numbers = { 11, 6, 4, 5, 7, 1 };
		Arrays.sort(numbers);
		int numbersArrayIndex = 0;
		for (int i = 0; i < numbers[numbers.length - 1]; i++) {
			if (i == numbers[numbersArrayIndex]) {
				numbersArrayIndex++;
			} else {
				System.out.println(i);
			}
		}
	}

	public static void missingEight() {
		int[] arr = { 10, 9, 8, 7, 5, 4, 3, 1, 2, 0, 6 };
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] + 1 != arr[i + 1]) {
				System.out.println(arr[i] + 1);
				break;
			}
		}
	}

	public static void missingNinge() {
		List<Integer> integerList = new LinkedList<Integer>();
		integerList.add(5);
		integerList.add(6);
		integerList.add(9);
		integerList.add(10);
		int first = integerList.get(0);
		int last = integerList.get(integerList.size() - 1);
		for (int i = first + 1; i < last; i++) {
			if (!integerList.contains(i))
				System.out.println("Number Not in List : " + i);
		}
	}

	public static void mainTen() {
		// given input
		int[] input = { 1, 1, 2, 3, 5, 5, 7, 9, 9, 9 }; // let's create another array with same length
		// by default all index will contain zero
		// default value for int variable
		int[] register = new int[input.length]; // now let's iterate over given array to
		// mark all present numbers in our register // array
		for (int i : input) {
			register[i] = 1;
		}
		// now, let's print all the absentees System.out.println("missing numbers in
		// given array");
		for (int i = 1; i < register.length; i++) {
			if (register[i] == 0) {
				System.out.println(i);
			}
		}
	}

	public static void mainLast() {
		int[] arr = { 7, 5, 6, 1, 4, 2 };
		System.out.println("Missing number from array arr: " + missingNumber(arr));
		int[] arr2 = { 5, 3, 1, 2 };
		System.out.println("Missing number from array arr2: " + missingNumber(arr2));

	}

	public static int missingNumber(int[] arr) {
		int n = arr.length + 1;
		int sum = n * (n + 1) / 2;
		int restSum = 0;
		for (int i = 0; i < arr.length; i++) {
			restSum += arr[i];
		}
		int missingNumber = sum - restSum;
		return missingNumber;
	}
	
	
}
