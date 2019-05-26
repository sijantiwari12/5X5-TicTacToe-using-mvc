
import java.util.Scanner;
public class Controller {
	public static Model model;
	public static View view;
	public Controller(Model model, View view) {
		this.model=model;
		this.view=view;
	 }
public static void startGame() {
		Scanner input= new Scanner(System.in);
		while(hasWon(view.board)==false) {
		//turn for x
		System.out.println("x, Enter row");
		int row= input.nextInt();
		System.out.println("x, Enter col");
		int col= input.nextInt();
		//check for spot
		if(view.board[row][col]==0) 
			view.board[row][col]=model.X;
			view.printBoard();
			
		//check if the move of x makes the win
		if(hasWon(view.board)==true){
			break;
		}
		System.out.print("O, enter row");
		 row=input.nextInt();
		System.out.print("O, enter col");
		col = input.nextInt();
		if(view.board[row][col]==0) 
			view.board[row][col]=model.O;
			view.printBoard();
		}
		System.out.println("Game over");
}
		
//domain logic to check win condition
public static boolean hasWon(int[][]matrix) {
		boolean haswonvalue=false;
		//first check horizontal win
		for(int row=0;row<matrix.length;row++) {
			int sum=0;
			for(int col=0;col<matrix[row].length;col++) {
				sum+=matrix[row][col];
			}
			//check to see if the sum will be 5 or -5
		if(sum==5) {
			System.out.println("x wins!!");
			haswonvalue=true;
		}
		else if(sum==-5) {
			System.out.println("O wins");
			haswonvalue=true;
		}
		}
		//check for vertical win 
		for(int col=0; col<matrix.length;col++) {
			int sum=0;
			for(int row=0; row<matrix[col].length;row++) {
				sum+=matrix[row][col];
			}
			if(sum==5) {
				System.out.println("x wins");
				haswonvalue=true;
			}
			else if(sum==-5) {
				System.out.println("O wins");
				haswonvalue=true;
			}
		}
		//check for diagonal win
		if(matrix[0][0]+matrix[1][1]+matrix[2][2]+matrix[3][3]+matrix[4][4]==5) {
			System.out.println("x wins");
			haswonvalue=true;
		}
		else if(matrix[0][0]+matrix[1][1]+matrix[2][2]+matrix[3][3]+matrix[4][4]==-5) {
			System.out.println("O wins");
			haswonvalue=true;
		}
		else if(matrix[0][4]+matrix[1][3]+matrix[2][2]+matrix[3][1]+matrix[4][0]==5) {
			System.out.println("X wins");
			haswonvalue=true;
		}
		else if(matrix[0][4]+matrix[1][3]+matrix[2][2]+matrix[3][1]+matrix[4][0]==-5) {
			System.out.println("O wins");
			haswonvalue=true;
		}
		//check for cat game
		boolean foundspace=false;
		for(int row=0;row<matrix.length;row++) {
			for(int col=0;col<matrix[row].length;col++) {
				if(matrix[row][col]==0) {
					foundspace=true;
				}
			}
		}
		if( foundspace == false ){
		       System.out.println("Ends in tie.");
		       haswonvalue = true;
		}
		return haswonvalue;
}
	

}
