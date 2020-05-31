package study;

import java.util.ArrayList;
import java.util.Scanner;

public class Food {

	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		Scanner i2 = new Scanner(System.in);
		Scanner i3 = new Scanner(System.in);
		
		System.out.println("요리재료갯수는?");
		int count = i.nextInt();
		
		System.out.println("창고재고?");
		String s1 = i2.nextLine();
		
		System.out.println("필요갯수");
		String t = i3.nextLine();
		System.out.println(s1.split("//s"));
	}
}

	

