//
/******************************************************************************
 *  @(#)NQueens.java
 *
 *  Generates an n-by-n chess board.
 *
 *	Compilation:  javac NQueens.java
 *  Execution:    java NQueens n
 *  Dependencies: Std2Draw.java
 *
 *	@author Dr. Abdulghani M. Al-Qasimi ,Ammar Yaser
 *  @version 2.00 2021/10/18
 *
 ******************************************************************************/

/******************************************************************************
 *                  I M P O R T A N T
 *
 * Do not modify any thing after this line until instructed below
 *
 ******************************************************************************/
public class NQueens {
	
    private int n;                  // dimension of chess board
    private String queen;			// the queen image file
	// The NQueens constructor
	// generate n x n chess board and displays it
    public NQueens(int n) {
        this.n = n;
        queen = "queen.png";
        Std2Draw.setXscale(0, n+1);
        Std2Draw.setYscale(0, n+1);
        
    }

    // draw the board
    public void draw() {
    	double m = (double)n/2;
        Std2Draw.setPenColor(Std2Draw.BLACK);
        Std2Draw.square(m+0.5, m+0.5, m);
        Std2Draw.setPenColor(Std2Draw.WHITE);
        Std2Draw.filledSquare(m+0.5, m+0.5, m);

        Std2Draw.setPenColor(Std2Draw.BRAWN);
    	for(int i=1; i<=n; i++) {
    		for(int j=1; j<=n; j++) {
    			if ((i + j) % 2 == 0)
    				Std2Draw.filledSquare(i, j, 0.5);
    		}
    	}
        Std2Draw.show();
        Std2Draw.pause(1000);
    }

	// draw the queen image in cell at the given coordinates
	public void drawQueen(int i, int j) {
		Std2Draw.picture(i, j, queen, 0.8, 0.8);
		Std2Draw.show();
	}

	// clear the queen image from cell at the given coordinates
	public void clearQueen(int i, int j) {
		if((i + j) % 2 == 0) {
			Std2Draw.setPenColor(Std2Draw.BRAWN);
			Std2Draw.filledSquare(i, j, 0.5);
		}
		else {
			Std2Draw.setPenColor(Std2Draw.WHITE);
			Std2Draw.filledSquare(i, j, 0.5);
		}
		Std2Draw.show();
	}

    // A main method to test the program
    public static void main(String[] args) {
       int n = Integer.parseInt(args[0]);
   
        NQueens nq = new NQueens(n);
        Std2Draw.enableDoubleBuffering();
        nq.draw();
        nq.solve();
    }

    // write the solve(n) method to show in animation on the generated
    // n x n chess board, how a recursive algorithm finds a solution
    // to the n-queens problem.
    // At every step the included queen image must appear or disappear
    // as the algorithm advances to its end.
    // use drawQueen() method to put the image at a cell
    // use clearQueen() method to erase the image from a cell
    
    
    public boolean solve() {
    	//create virtual board
    	int Chesstable[][] = new int[n][n];
    	if (RetryBlocking(Chesstable, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }
 

        return true;
    }
    	
    	

    	
    
//Check if it Possible to add queen or no
    
    
    
    
    public boolean isPossible(int board[][], int row, int col)
    {
        int i, j;
 
        // Check left horizontal diagonals
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
 
        // Check  above 
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
 
        //Check  under diagonals   
        for (i = row, j = col; j >= 0 && i < n; i++, j--)
            if (board[i][j] == 1)
                return false;
 
        return true;
    }
    // Recursive 
    public boolean RetryBlocking(int board[][], int col)
    {
        // Base case  
        if (col >= n)
            return true;
 
       
        for (int i = 0; i < n; i++) {
            // Check if block is safe 
            if (isPossible(board, i, col)) {
                // Place this queen 
                board[i][col] = 1;
                drawQueen(i+1,col+1);
                Std2Draw.pause(50);
 
                //Check  all for each rows  
                if (RetryBlocking(board, col + 1) == true)
                    return true;
 
                // if  it  still false  remove queen and try  
                board[i][col] = 0; // BACKTRACK
                clearQueen(i+1,col+1);
                Std2Draw.pause(50);
            }
        }
        return false;
    }
     
}
