package test2;


import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
/**
 *
 * @author hazem
 */
public class SudokuGrid extends GridPane{

public static final int GRID_SIZE = 9;

public TextField[][] sudokuCells;
private int[][] solution;
	private int[][] initial;
	private int[][] player;


public SudokuGrid () {
    sudokuCells = new TextField[GRID_SIZE][GRID_SIZE];
   
    for (int row = 0; row < GRID_SIZE; row++) {
        for(int col = 0; col < GRID_SIZE; col++) {
            sudokuCells[row][col] = new TextField() {
                  @Override
                    public void replaceText(int start, int end, String text) {
                      
                        if (text.matches("[1-9]|\\s")) {
                            super.setText(text);
                        }
                    }
                };
            
            sudokuCells[row][col].setPrefSize(60, 60);
             add(sudokuCells[row][col], col, row);
           
        }
    }
    for (int row_offset = 0; row_offset < 9; row_offset+=3) { 
			
			for(int col_offset = 0; col_offset <9; col_offset+=3) { 
				
				int sum = 0;
				
				for (int row = 0; row < 3; row++) {
					
					for (int col = 0; col < 3; col++) {
					if ((row_offset+col_offset)%2==0)
                                             sudokuCells[row + row_offset][col + col_offset].setStyle("-fx-background-color: yellow;");
                                        else
                                             sudokuCells[row + row_offset][col + col_offset].setStyle("-fx-background-color: white;");  
                                            
					}
				}
                        }
    }

            
           
    setPrefSize(270, 270); 
    setGridLinesVisible(true);
}


public int[][] getPlayer(){
    int [][]player =new int[9][9];
  for (int row = 0; row < GRID_SIZE; row++) {
        for(int col = 0; col < GRID_SIZE; col++) {
        player[row][col]= Integer.parseInt(sudokuCells[row][col].getText());
        
        
        }
  }
return player;
 } 
public void setCells (int[][] player){
 for (int row = 0; row < GRID_SIZE; row++) {
        for(int col = 0; col < GRID_SIZE; col++) {
if (player[row][col]==0)
	   sudokuCells[row][col].setText("");
	else	
 	   sudokuCells[row][col].setText(String.valueOf(player[row][col]));

        
        }
 }

}
}