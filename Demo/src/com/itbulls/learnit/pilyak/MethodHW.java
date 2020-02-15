package com.itbulls.learnit.pilyak;

import java.util.Scanner;
import java.util.Arrays;

public class MethodHW {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//task1
		maxValInt();
		//task2
		rectangle();
		//task3
		calculateWordsInText();
		//task4
		calcWordsMore3Char();
	}
	
	public static void maxValInt() {
		System.out.print("Enter the integers numbers separated by space: ");
		String[] arr = sc.nextLine().split(" ");
		int[] parsedArr = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			parsedArr[i] = Integer.parseInt(arr[i]);
		}
		int maxVal = searchMaxVallOfArr(parsedArr);
		System.out.print("Max element in your numbers is: " + maxVal);
	}
	public static int searchMaxVallOfArr(int[] parsedArr) {
		Arrays.parallelSort(parsedArr);
		return parsedArr[parsedArr.length - 1];
	}
	
	
	
	public static void rectangle() {
		System.out.print("Input the height of the rectangle: ");
		int height = sc.nextInt();
		System.out.print("Input the width of the rectangle: ");
		int width = sc.nextInt();
		buildRectangle(height, width);

	}
	public static void buildRectangle(int height, int width) {
		for(int i = 0; i < width; i++) {
			System.out.print("+");
		}
		System.out.println();
		for(int i = 0; i < height - 2; i++) {
			System.out.print("+");
			for(int j = 0; j < width - 2; j++) {
				System.out.print(" ");
			}
			System.out.println("+");
		}
		for(int i = 0; i < width; i++) {
			System.out.print("+");
		}
	}
	
	
	
	public static void calculateWordsInText() {
		System.out.print("Enter the text: ");
		String text = sc.nextLine();
		System.out.println(calcWords(text));
		
	}
	public static int calcWords(String text) {
		int count = 0;
		if(text.length() > 0) {
			count++;
			for(int i = 0; i < text.length(); i++) {
				if(text.charAt(i) == ' ') {
					count++;
				}
			}
		}else
			return count;
		
		if(text.charAt(text.length() - 1) == ' ') {
			count--;
			return count;
		}else
			return count;
	}
	
	
	
	public static void calcWordsMore3Char() {
		System.out.print("Enter thw words separated by space: ");
		String[] arr = sc.nextLine().split(" ");
		System.out.print("Words than length more than 3 characters: ");
		for(int i = 0; i < calcWords(arr).length; i++) {
			System.out.print(calcWords(arr)[i] + " ");
		}
	}
	public static String[] calcWords(String[] arr) {
		int k = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length() > 3) {
				k++;
			}
		}
		String[] sortArr = new String[k];
		k = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length() > 3) {
				sortArr[k] = arr[i];
				k++;
			}
		}
		
		return sortArr;
	}
	
}
