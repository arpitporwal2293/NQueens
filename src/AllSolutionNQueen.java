
public class AllSolutionNQueen {

	public static int N;
	
	public void printSolution(int[][] matrix){
		System.out.println();
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean isSafe(int[][] matrix,int row,int col){
		int i, j;
		 
	    /* Check this row on left side */
	    for (i = 0; i < col; i++)
	        if (matrix[row][i]==1)
	            return false;
	 
	    /* Check upper diagonal on left side */
	    for (i=row, j=col; i>=0 && j>=0; i--, j--)
	        if (matrix[i][j]==1)
	            return false;
	 
	    /* Check lower diagonal on left side */
	    for (i=row, j=col; j>=0 && i<N; i++, j--)
	        if (matrix[i][j]==1)
	            return false;
	 
	    return true;
	}
	
	public boolean NQueenUtil(int[][] matrix,int col){
		if(col == N){
			printSolution(matrix);
			return true;
		}
		
		for(int i=0;i<N;i++){
			if(isSafe(matrix, i, col)){
				matrix[i][col] = 1;
				NQueenUtil(matrix, col+1);
				matrix[i][col] = 0;
			}
		}
		return false;
	}
	
	public void NQueen(int n){
		N = n;
		int[][] matrix = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				matrix[i][j] = 0;
			}
		}
		if(NQueenUtil(matrix, 0)){
			System.out.println("No solution exists");
		}
	}
	
	public static void main(String[] args) {
		AllSolutionNQueen nQueen = new AllSolutionNQueen();
		nQueen.NQueen(4);
	}
	
}
