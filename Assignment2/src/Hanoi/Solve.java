package Hanoi;

import java.util.Scanner;

public class Solve {
	public static void main(String[] argu){
		Scanner scan = new Scanner(System.in);
		Hanoi hanoi = new Hanoi(); 
		while(true){
			hanoi.setProblem(scan.nextInt());	/// get the size of problem from user
			hanoi.sol();
		}
	}
}
