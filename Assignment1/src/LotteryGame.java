import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class LotteryGame {
	public static void main(String[] argu){
		Scanner in = new Scanner(System.in);
		Random ran = new Random();
		int[] normal = new int[5];	// the 5 normal numbers
		int special = 0; // the special number
		for(int i=0; i<5; i++) {
			int ok = 0;	 // represent whether number is acceptable ( 1=> no repeating;  0=> is repeat) 
			while(ok==0){	
				ok = 1;	// pre-set ok to 1;
				normal[i] = ran.nextInt(100);	// random-produce a normal number
				for(int j=0; j<i; j++){
					if(normal[i]==normal[j]) ok = 0;	// if there's an exist repeat number, set ok to 0;
				}
			}
		}
		Arrays.sort(normal); // sort normal numbers
		
		System.out.print("The numbers are: ");		
		for(int i=0; i<5; i++){
			System.out.print(normal[i]+" ");	// print normal numbers out, each with a blank following
		}

		int ok=0;	// represent whether number is acceptable ( 1=> no repeating;  0=> is repeat) 
		while(ok==0){
			special = ran.nextInt(100);	// random-produce a special number
			ok = 1;	// pre-set ok to 1;
			for(int i=0; i<5; i++){
				if(special == normal[i]) ok=0;	// if there's an exist repeat number, set ok to 0;
			}
		}
		System.out.println(special); // print special number out and change the line
		
		while(true){	// an infinite loop
		
			System.out.print("Please enter 5 numbers: ");
			int[] user = new int[5];	// representing the 5 numbers user key in
			for(int i=0; i<5; i++) user[i] = in.nextInt();	// get the 5 numbers user key in
			Arrays.sort(user);	// sort user's number
			int same = 0;	// count the same numbers 
			int spesame = 0;	// 1 if there's a number same as special number
			int j=0;
			for(int i=0; i<5; i++){
				if(user[i] == special) spesame = 1;		// check if there's a number same as special number
				while(j<5){
					if(user[i] > normal[j]) j++;	// if the current number of user-array number is bigger then the one of award-array, check next array number
					else if(user[i] == normal[j]) {	// if they're the same, "same" add up and go to next number of user-array
						same++;
						j++;
						break;
					}else break;	// if the current number of user-array number is smaller, go to the next number of user-array
				}
			}
			
			if(same>=5) System.out.println("You win A prize!");	// A prize if 5 same number
			if(same>=4) System.out.println("You win B prize!");	// B prize if 4
			if(same>=3) System.out.println("You win C prize!");	// C prize if 4
			if(same>=1 && spesame>0) System.out.println("You win Special prize!");	// Special prize if special and at least on normal number are th same
			if(same==0  || (same<3 && spesame==0) ) System.out.println("Try again next time!");	// no prize otherwise
		}
	}
}
