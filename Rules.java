
package test2;

/**
 *
 * @author hazem
 */
public class Rules {


	private int[][] solution;
	
	private int[][] initial;
	
	private int[][] player;

	
	public Rules() {
		solution = new int[][]
		{
			{5,3,8,4,6,1,7,9,2},
			{6,9,7,3,2,5,8,1,4},
			{2,1,4,7,8,9,5,6,3},
			{9,4,1,2,7,8,6,3,5},
			{7,6,2,1,5,3,9,4,8},
			{8,5,3,9,4,6,1,2,7},
			{3,8,9,5,1,2,4,7,6},
			{4,2,6,8,9,7,3,5,1},
			{1,7,5,6,3,4,2,8,9}
		};

		initial = new int[][]
		{
			{0,0,0,4,0,0,0,9,0},
			{6,0,7,0,0,0,8,0,4},
			{0,1,0,7,0,9,0,0,3},
			{9,0,1,0,7,0,0,3,0},
			{0,0,2,0,0,0,9,0,0},
			{0,5,0,0,4,0,1,0,7},
			{3,0,0,5,0,2,0,7,0},
			{4,0,6,0,0,0,3,0,1},
			{0,7,0,0,0,4,0,0,0}

		};

		player = new int[9][9];
	}

	
        public void setPlayer(int [][]player ){
        this.player=player;
        
        }
	public int[][] getSolution() {
		return solution;
	}

	
	public int[][] getInitial() {
		return initial;
	}

	
	public int[][] getPlayer() {
		return player;
	}

	

	public boolean checkForSuccessGeneral() {
		
		int[][] combined = new int[9][9];
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col <9; col++) {
				if(initial[row][col]!=0) {
					combined[row][col] = initial[row][col];
				} else {
					combined[row][col] = player[row][col];
				}
			}
		}
		for(int row = 0; row<9; row++) {
			int sum = 0;
			for(int col = 0; col<9; col++) {
				sum = sum + combined[row][col];
			}
			if(sum!=45) {
				return false;
			}
		}
		
		
		for(int col = 0; col<9; col++) { 
			int sum = 0;
			
			for(int row = 0; row<9; row++) {
				sum = sum + combined[row][col];
			}
			
			if(sum!=45) {
				return false;
			}
		}
		
		
		for (int row_offset = 0; row_offset < 9; row_offset+=3) { 
			
			for(int col_offset = 0; col_offset <9; col_offset+=3) { 
				
				int sum = 0;
				
				for (int row = 0; row < 3; row++) {
					
					for (int col = 0; col < 3; col++) {
						sum = sum + combined[row + row_offset][col + col_offset];
					}
				}
				
				if(sum!=45) {
					return false;
				}
			}
		}
		
		return true;
	}

}