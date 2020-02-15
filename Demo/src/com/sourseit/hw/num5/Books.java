package com.sourseit.hw.num5;

import java.util.Scanner;


public class Books {
	Scanner sc = new Scanner(System.in);
	int id;
	String name;
	String autor;
	String publishing_house;
	int years;
	int pages;
	double cost;
	String binding_type;
	
	public Books(int id, String name, String autor, String publishing_house, int years, int pages, double cost, String binding_type){
		this.autor = autor;
		this.binding_type = binding_type;
		this.cost = cost;
		this.id = id;
		this.name = name;
		this.pages = pages;
		this.publishing_house = publishing_house;
		this.years = years;
	}
	
	public static void autorBooks(Books arr[], int n) {
		System.out.print("Enter autor name: ");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		print();
		for(int i = 0; i < n; i++) {
			if(arr[i].autor.equals(name)) {
				System.out.println(arr[i].id+"  | "+arr[i].name+"  | "+arr[i].autor+" | "+arr[i].publishing_house+" |      "+arr[i].years+"     |   "+arr[i].pages+"  |  "+arr[i].cost+"  |   "+arr[i].binding_type+" "); 
				System.out.println("__________________________________________________________________________________________________________|");
			}
		}
	}
	
	public static void samePublish(Books arr[], int n) {
		System.out.print("Enter autor publishing house: ");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		String publ = sc.nextLine();
		print();
		for(int i = 0; i < n; i++) {
			if(arr[i].publishing_house.equals(publ)) {
				System.out.println(arr[i].id+"  | "+arr[i].name+"  | "+arr[i].autor+" | "+arr[i].publishing_house+" |      "+arr[i].years+"     |   "+arr[i].pages+"  |  "+arr[i].cost+"  |   "+arr[i].binding_type+" "); 
				System.out.println("__________________________________________________________________________________________________________|");
			}
		}
	}
	
	public static void youYears(Books arr[], int n) {
		System.out.print("Enter autor years: ");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		int years = sc.nextInt();
		print();
		for(int i = 0; i < n; i++) {
			if(arr[i].years > years) {
				System.out.println(arr[i].id+"  | "+arr[i].name+"  | "+arr[i].autor+" | "+arr[i].publishing_house+" |      "+arr[i].years+"     |   "+arr[i].pages+"  |  "+arr[i].cost+"  |   "+arr[i].binding_type+" "); 
				System.out.println("__________________________________________________________________________________________________________|");
			}
		}
	}
	
	public static void print() {
		System.out.println(" id \tBook title\t\tAutor\t\tPublishing\t Year of issue   Pages    Price    Binding type");
		System.out.println("__________________________________________________________________________________________________________|");
	}
	
	public static void menu() {
		System.out.println("   ***MENU***");
		System.out.println("1. Print list of books by a given author.");
		System.out.println("2. Print list of books published by a given publisher.");
		System.out.println("3. Print list of books released after a given year.");
		System.out.println("4. Exit.");
		System.out.print("  Your choice: ");
	}
	
}
