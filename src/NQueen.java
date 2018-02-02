public class NQueen {

	class Position{
		int row, col;
		public Position(int row,int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public void printSolution(Position[] positions){
		for(Position pos : positions){
			System.out.println(pos.row+","+pos.col);
		}
	}
	
	public boolean NQueensUtil(int n,int row,Position[] positions){
		if(n==row){
			printSolution(positions);
			return true;
		}
		for(int col=0;col<n;col++){
			boolean foundSafe = true;
			
			for(int queen=0;queen<row;queen++){
				if(positions[queen].col == col || positions[queen].row - positions[queen].col == row - col
						|| positions[queen].row + positions[queen].col == row + col){
					foundSafe = false;
					break;
				}
			}
			
			if(foundSafe){
				positions[row] = new Position(row, col);
				if(NQueensUtil(n, row+1, positions)){
					return true;
				}
			}
		}
		return false;
	}
	
	public Position[] NQueens(int n){
		Position[] positions = new Position[n];
		boolean hasSolution = NQueensUtil(n, 0, positions);
		if(hasSolution){
			return positions;
		}else{
			return new Position[0];
		}
	}
	
	public static void main(String[] args) {
		NQueen nQueen = new NQueen();
		Position[] positions = nQueen.NQueens(4);
	}
	
}
