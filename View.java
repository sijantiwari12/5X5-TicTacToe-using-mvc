public class View{
public static Model model;
public static int[][]board = new int[5][5];
public View(Model model) {
	this.model = model;
}
public static void printBoard() {
		for(int row=0; row<board.length;row++) {
			for(int col=0; col<board[row].length;col++) {
				if(board[row][col]==model.X) {
					System.out.print("X");
				}
				else if(board[row][col]==model.O) {
					System.out.print("0");
				}
				else
					System.out.print(".");
			}
			System.out.println("");
			
		}
		
	}

}
