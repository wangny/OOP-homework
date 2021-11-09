import java.util.Random;
import java.util.Scanner;

public class NumberPuzzle {
	public static void main(String[] argu){
		Random ran = new Random();
		int[] puzzle = new int[9];
		
		int zero = 0;	// to know the place of the blank, for convenience 
		
		for(int i=0; i<9; i++) {
			int ok = 0;		// represent whether number is acceptable ( 1=> no repeating;  0=> is repeat) 
			while(ok == 0){
				puzzle[i] = ran.nextInt(9);	// random-produce a number
				ok = 1;			// pre-set ok to 1;
				for(int j=0; j<i; j++){
					if(puzzle[i]== puzzle[j]) ok = 0;	// if there's an exist repeat number, set ok to 0;
				}
			}
		}
		
		int total = 0;
		for(int i=0; i<9; i++){		// check if the puzzle has a solution 
			if(puzzle[i]==0) continue;
			int tmp = 0;
			for(int j=i+1; j<9; j++){	// sum up the number of blocs that every bloc is preceding 
				if(puzzle[j] < puzzle[i]) tmp ++;
			}
			total = total + tmp;
		}
		
		if(total%2 == 0) System.out.println("Having solution.");	// has a solution if is a multiple of 2
		else System.out.println("No solution.");	// no solution otherwise
		
		Scanner scan = new Scanner(System.in);
		
		while(true){
		
			for(int i=0; i<9; i++){		// print out the puzzle with every three blocs a line
				if(puzzle[i]==0) {
					System.out.print(" ");
					zero = i;
				}else System.out.print(puzzle[i]);
	
				if( (i+1)%3 == 0 ) System.out.println("");
			}
		
			System.out.print("Control via WASD: ");
			char ins = scan.next().charAt(0);		// scan the instruction user key-in in form of char
			if(ins == 'w' || ins == 'W'){
				if(zero < 6){	// make sure if it's practical
					puzzle[zero] = puzzle[zero+3];	// exchange the blank and the relative bloc
					puzzle[zero+3] = 0;
					zero = zero+3;	// the place of the blank has been changed
				}
			}else if(ins == 's' || ins == 'S'){
				if(zero > 2 ){
					puzzle[zero] = puzzle[zero-3];
					puzzle[zero-3] = 0;
					zero = zero-3;
				}
			}else if(ins == 'd' || ins == 'D'){
				if(zero%3 > 0 ){
					puzzle[zero] = puzzle[zero-1];
					puzzle[zero-1] = 0;
					zero = zero-1;
				}
			}else if(ins == 'a' || ins == 'A'){
				if(zero%3 < 2 ){
					puzzle[zero] = puzzle[zero+1];
					puzzle[zero+1] = 0;
					zero = zero+1;
				}
			}
			
		}
	}
	
}
