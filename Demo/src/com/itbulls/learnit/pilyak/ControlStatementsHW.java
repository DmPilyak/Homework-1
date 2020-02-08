package com.itbulls.learnit.pilyak;

import java.util.Scanner;
import  java.util.Random;

public class ControlStatementsHW {
	public static void main(String[] args) {
		first();
		sortWords();
		pyramid();
		arrays();
		matrix();
	}
	
	public static void first() {
		System.out.print("Enter the value: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int k = 1;
		int a2 = a;
		
		//first cycle calculate number of digits in value, with help variable k
		while(a2 > 10) {
			a2 /= 10;
			k++;
		}
		
		//after calculating number of digits create an array of k elements
		int[] arr = new int[k];
		
		//fill the array
		for(int i = k - 1; i >= 0 ; i--) {
			arr[i] = a % 10;
			a /= 10;
		}
		
		//print array
		for(int i = 0; i < k; i++) {
		System.out.println(arr[i]);
		}
	}
	
	public static void sortWords() {
		System.out.print("Enter 7 words separated by space: ");
		Scanner sc = new Scanner(System.in);
		int size = 7;
		String[] arr = new String[size];
		for(int i = 0; i < size; i++) {
			arr[i] = sc.next();
		}
		String tmp;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1; j++) {
				if (arr[j].length() < arr[j + 1].length()) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
			
		}

		for(int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	
	
	public static void pyramid() {
		System.out.print("Enter the height of the pyramid: ");
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = height - 1; i > 0; i--) {
			for(int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	public static void arrays() {
		int n = 10;
		int[] firstMatrix = new int[n];
		int[] secondMatrix = new int[n*2];
		
		final Random rand = new Random();
		
		for(int i = 0; i < n; i++) {
			firstMatrix[i] = rand.nextInt(10);
			secondMatrix[i] = firstMatrix[i];
		}
		System.out.print("First array: ");
		for(int i = 0; i < n; i++) {
			System.out.print(firstMatrix[i] + "  ");
		}
		
		System.out.println();
		for(int i = n; i < n*2; i++) {
			secondMatrix[i] = (firstMatrix[i - n] * 2);
		}
		System.out.print("Second array: ");
		for(int i = 0; i < n*2; i++) {
			System.out.print(secondMatrix[i] + "  ");
		}
		
	}
	
	
	
	
	public static void matrix() {
		
		Scanner sc = new Scanner(System.in);
		double sum;
		int n = 5;
		double[][] orig_matrix = new double[n][n];
		
		for(int i = 1; i <= n; i++) {
			double b = 0.1;
			for(int j = 0; j < n; j++) {
				orig_matrix[i - 1][j] = i + b;
				b += 0.1;
			}
		}
		
		System.out.println("Your matrix: ");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(orig_matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		for(;;) {
			System.out.println("***MENU***");
			System.out.println("1.  rotate matrix to 90 degrees. ");
			System.out.println("2.  rotate matrix to 180 degrees.");
			System.out.println("3.  rotate matrix to 270 degrees.");
			System.out.println("4. Exit");
			System.out.println("Select: ");
			int ch = sc.nextInt();
			System.out.println();
			switch(ch) {
			case 1:
				sort90(orig_matrix, n);
				break;
			case 2:
				sort90(orig_matrix, n);
				break;
			case 3:
				System.out.println("Sorry, not today :(");
				break;
			case 4:
				System.exit(0);
				break;
			}
		}
		
	}
	
	public static void sort90(double[][] orig_matrix, int n) {
		double tmp;
		for(int i = 0; i < n / 2; i++) {
			for(int j = i; j < n - i - 1; j++) {
					tmp = orig_matrix[i][j];
					orig_matrix[i][j] = orig_matrix[n - j - 1][i];
					orig_matrix[n - j - 1][i] = orig_matrix[n - i - 1][n - j - 1];
					orig_matrix[n - i - 1][n - j - 1] = orig_matrix[i][n - i - 1];
					orig_matrix[j][n - i - 1] = tmp;
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(orig_matrix[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
	}
	
	public static void sort180(double[][] orig_matrix, int n) {
		double[][] matrix180 = new double[n][n];
		int i2 = 0;
		int j2 = 0;
		for(int i = n - 1 ; i >= 0; i--) {
			j2 = 0;
			for(int j = n - 1; j >= 0; j--) {
					matrix180[i2][j2] = orig_matrix[i][j];
					j2++;
				}
			i2++;
			System.out.println();
			}
		
		for(int i = n - 1 ; i >= 0; i--) {
			for(int j = n - 1; j >= 0; j--) {
					orig_matrix[i][j] = matrix180[i][j];
				}
			}
		
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(orig_matrix[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
	}
	
	
}
