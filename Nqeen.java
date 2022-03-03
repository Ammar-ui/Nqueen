
public class Nqeen {
private int  chesstable[][];
private int NumofQueens;
public Nqeen(int NumofQueens) {
	this.chesstable=new int [NumofQueens][NumofQueens];
	this.NumofQueens=NumofQueens;
}
// for print 
public void solve () {
	if(SetQueen(0)) {
		printQueen();
	}
	else {
		System.out.println("there is no Solution");
	}
	
}
	private boolean SetQueen(int colIndex) {
		if(colIndex==NumofQueens)
			return true;
		
	for(int rowIndex=0;rowIndex<NumofQueens;rowIndex++) {
		if(isPlaceVialied(rowIndex,colIndex)) {
		chesstable[rowIndex][colIndex]=1;
		
		if(SetQueen(colIndex+1)) {
			return true;
		}
		//BACKTRACKING
		chesstable[rowIndex][colIndex]=0;
		
	}
		
	}
	return false;
	}

	//checker for diagonals 
	private boolean isPlaceVialied(int rowIndex, int colIndex) {
		for(int i=0;i<colIndex;i++) {
			if(chesstable[rowIndex][i]==1)
				return false;
			
		}
		for(int i=rowIndex,j=colIndex;i>=0&&j>=0;i--,j--) {
			if(chesstable[i][j]==1)
				return false;
			
		}
		for(int i=rowIndex,j=colIndex;i<chesstable.length&&j>=0;i++,j--) {
			if(chesstable[i][j]==1)
				return false;
			
		}
		// TODO Auto-generated method stub
		return true;
	}
	private void printQueen() {
		for(int i=0;i<chesstable.length;i++) {
			for(int j=0;j<chesstable.length;j++) {
				if(chesstable[i][j]==1) {
					System.out.print("*");					
				}
				else {
					System.out.print("-");
				}
				
			}
			System.out.println();
		}
	
}
	

}
