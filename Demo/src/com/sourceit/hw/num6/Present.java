package com.sourceit.hw.num6;
import java.util.Scanner;

public class Present {
	public static void main(String[] args) {
		Candy[] arr = new Candy[20];
		int n = 5;
		Candy[] candyArr = new Candy[n];
		int kAdd = 0;
		double summ_weight = 0;
		Candy candy1 = new Candy("Snikers", "Bar", 100, 40);
		Candy candy2 = new Candy("Raffaello", "Wafer", 40, 20);
		Candy candy3 = new Candy("Tofix", "Jelly", 30, 20);
		Candy candy4 = new Candy("Baunty", "Bar", 110, 45);
		Candy candy5 = new Candy("Kontik", "Cookies", 170, 90);
		candyArr[0] = candy1;
		candyArr[1] = candy2;
		candyArr[2] = candy3;
		candyArr[3] = candy4;
		candyArr[4] = candy5;
		
		for(;;) {
			mainMenu();
			Scanner sc = new Scanner(System.in);
			System.out.print("   Your choice: ");
			int ch = sc.nextInt();
			System.out.println();
			switch(ch) {
			case 1:
				candyMenu();
				System.out.print("   Your choice: ");
				int chAddCandy = sc.nextInt();
				arr[kAdd] = chooseCandy(chAddCandy, candyArr);
				kAdd++;
				printPresent(arr, kAdd);
				//weight
				summ_weight = summ_weight + chooseCandy(chAddCandy, candyArr).getWeight();			
				break;
			case 2:
				candyMenu();
				System.out.print("   Your choice: ");
				int chDellCandy = sc.nextInt();
				arr[kAdd] = dellCandy(chDellCandy, candyArr, arr, kAdd);
				kAdd--;
				printPresent(arr, kAdd);
				//weight
				summ_weight = summ_weight - dellCandy(chDellCandy, candyArr, arr, kAdd).getWeight();		
				break;
			case 3:
				System.out.print("Enter sugar range for candy search (separated by space): ");
				int ot = sc.nextInt();
				int d0 = sc.nextInt();
				findSugarCandy(ot ,d0, candyArr, kAdd);
				break;
			case 4:
				System.out.println("Summ present weight: " + summ_weight+"g.");
				System.out.println();
				break;
			case 5:
				printPresent(arr, kAdd);
				break;
			case 6:
				Candy tmp;
				for (int i = 0; i < kAdd - 1; i++) {
					for (int j = 0; j < kAdd - 1; j++) {
						if (arr[j].getWeight() < arr[j + 1].getWeight()) {
							tmp = arr[j];
							arr[j] = arr[j + 1];
							arr[j + 1] = tmp;
						}
					}
					
				}
				printPresent(arr, kAdd);
				break;
			}
			
		}
		
		
	}
	
	
	public static void mainMenu() {
		System.out.println("  ***MENU***");
		System.out.println("1. Add candy in present.");
		System.out.println("2. Remove candy from a present.");
		System.out.println("3. Find candy for a range of sugar.");
		System.out.println("4. Weigh a present.");
		System.out.println("5. Show present contents.");
		System.out.println("6. Sort candys in a present by weight");
	
	}
	public static void candyMenu() {
		System.out.println("   Choose candy:");
		System.out.println("1. Snikers (100g.).");
		System.out.println("2. Raffaello (40g.).");
		System.out.println("3. Tofix (30g.).");
		System.out.println("4. Baunty (110g).");
		System.out.println("5. Kontik (170g.).");
	}
	public static Candy chooseCandy(int chCandy, Candy[] candyArr) {
		switch(chCandy) {
		case 1: return candyArr[0];
		case 2: return candyArr[1];
		case 3: return candyArr[2];
		case 4: return candyArr[3];
		case 5: return candyArr[4];
		default: System.out.println("nope(");
		break;
		}
		return candyArr[0];
	}
	public static Candy dellCandy(int chCandy, Candy[] candyArr, Candy[] arr, int kAdd) {
		for(int i = 0; i < kAdd; i++) {
			if(arr[i] == candyArr[chCandy - 1]) {
				switch(chCandy) {
				case 1: 
					return candyArr[0];
				case 2: 
					return candyArr[1];
				case 3: 
					return candyArr[2];
				case 4: 
					return candyArr[3];
				case 5: 
					return candyArr[4];
				default: System.out.println("nope(");
				break;
			}
				break;
		}
	}
		
		return candyArr[0];
	}
	
	public static void findSugarCandy(int ot, int d0, Candy[] arr, int kAdd) {
		System.out.println("-----------------------------------------------");
		for(int i = 0; i < kAdd; i++) {
			if((arr[i].getSugar() >= ot) || (arr[i].getSugar() <= d0)) {
				System.out.println(arr[i].getCandy_name() + "   " + arr[i].getCandy_type() + "   " + arr[i].getWeight() + "g.  " + arr[i].getSugar() + " (sugar g.)");
			}
		}
		System.out.println("-----------------------------------------------");
	}
	
	public static void printPresent(Candy[] arr, int kAdd) {
		System.out.println("Your present contains: ");
		System.out.println("-----------------------------------------------");
		for(int i = 0; i < kAdd; i++) {
			System.out.println(arr[i].getCandy_name() + "   " + arr[i].getCandy_type() + "   " + arr[i].getWeight() + "g.  " + arr[i].getSugar() + " (sugar g.)");
		}
		System.out.println("-----------------------------------------------");
		System.out.println();
	}
	

}
