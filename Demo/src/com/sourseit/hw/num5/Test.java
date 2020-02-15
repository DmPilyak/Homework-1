package com.sourseit.hw.num5;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int n = 7;
		Books[] arr = new Books[n];
		arr[0] = new Books(111, "Robinson Crusoe", "Daniel Defoe", "Paternoster Rowe", 24, 700, 20.5, "Hard cover");
		arr[1] = new Books(112, "Harry Potter", "Joanne Rowling", "Makhaon", 3, 630, 18.7, "Hard cover");
		arr[2] = new Books(113, "Sherlock Holms", "Arthur Conan Doyle", "First edition", 125, 1150, 30000, "Hard cover");
		arr[3] = new Books(114, "Robinson Crusoe", "Daniel Defoe", "Paternoster Rowe", 24, 700, 20.5, "Hard cover");
		arr[4] = new Books(115, "Captain Singleton", "Daniel Defoe", "Paternoster Rowe", 30, 370, 16.7, "Soft cover");
		arr[5] = new Books(116, "Hound of the Baskervilles", "Arthur Conan Doyle", "Paternoster Rowe", 35, 530, 13, "Soft cover");
		arr[6] = new Books(117, "Robinson Crusoe", "Daniel Defoe", "Paternoster Rowe", 15, 700, 20.5, "Hard cover");
		
		
		for(;;) {
			Books.menu();
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println();
				Books.autorBooks(arr, n);
				break;
			case 2:
				System.out.println();
				Books.samePublish(arr, n);
				break;
			case 3:
				System.out.println();
				Books.youYears(arr, n);
				break;
			case 4:
				System.exit(0);
				break;
			}
		}
		
		
		
	}
}
