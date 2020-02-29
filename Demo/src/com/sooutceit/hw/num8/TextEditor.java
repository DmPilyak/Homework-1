package com.sooutceit.hw.num8;

import java.awt.List;
import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.sound.sampled.Line;

import com.itbulls.learnit.pilyak.MethodHW;

public class TextEditor {

	public static void main(String[] args) throws IOException {
		Path p = Paths.get("Text Editor.txt");
		if(!Files.exists(p)) {
			Files.createFile(p);
		}
		ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(p);
		for(;;) {
			System.out.print(Files.readString(p));
			Scanner sc = new Scanner(System.in);
			String message = sc.nextLine();
			for (int i = 0; i < 50; ++i) System.out.println();     //"clear console"
			lines.add(message);
			if(message.equals("exit")) {
				///exit
				System.out.println("=========================");
				System.out.println("1. File content");
			    System.out.println(Files.readString(p));
				
			    System.out.println();
			    System.out.println("2. Symbols in file: " + calcSym(lines));
			    System.out.println("3. Max vowels in : " + vowels(lines) + " line");
			    System.out.println("4. Words: " + calcWords(lines));
				System.exit(0);
			}else
				
				
			Files.write(p, "".getBytes());
			Files.write(p, lines, StandardOpenOption.APPEND);
		}
		
	}
	
	public static int calcSym(ArrayList<String> lines) {
		int count = 0;
		String str;
		for (int i = 0; i < lines.size(); i++) {
			str = lines.get(i).toString();
			for (int j = 0; j < str.length(); j++) {
				count++;
				if(str.charAt(j) == ' ') {
					count--;
				}
			}
		}
		//System.out.println(count);
		return count;
	}
	public static int vowels(ArrayList<String> lines) {
		char[] vowelsArray = {'a', 'A','e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
		String maxStr = "";
		String str = "";
		int maxCount = 0;
		int numberStr = 0;
		for (int i = 0; i < lines.size(); i++) {
			str = lines.get(i).toString();
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				for(int k = 0; k < vowelsArray.length; k++) {
					if(str.charAt(j) == vowelsArray[k]) {
						count++;
						break;
					}
			    }
	    	}
			if(count > maxCount) {
				maxCount = count;
				maxStr = str;
				numberStr = i + 1;
			}
		}
		return numberStr;
	}
	public static int calcWords(ArrayList<String> lines) {
		int count = 0;
		
		for (int i = 0; i < lines.size(); i++) {
			String[] spl = lines.get(i).split("[,!?\\.:;\\s]+");
			count += spl.length;
		}
		return count - 1;
	}
	
	
}