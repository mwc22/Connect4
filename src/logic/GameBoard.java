package logic;

import java.util.Observable;

public class GameBoard extends Observable {
	
	private Slot[][] game = new Slot[6][7];
	private Boolean win = false;
	private String player = "RED";
	
	public GameBoard() {
		for (int i=0; i<game.length; i++){
			for (int j=0; j<game[0].length; j++){
				game[i][j] = new Slot();
			}
		}
	}
	
	public void print(){
		System.out.println();
		for (int r=0; r<game.length; r++){
			System.out.println();
			for (int c=0; c<game[0].length; c++){
				if (game[r][c].isEmpty()){
					System.out.print("0 ");
				}
				else if (game[r][c].getColor()=="RED"){
					System.out.print("1 ");					
				}
				else {
					System.out.print("2 ");
				}
			}
		}
	}
	
	public Boolean placePiece(int col){
		int row = getRow(col, 5);
		if (row>=0&&!win){
			game[row][col].putPiece(player);
			win = win(row, col);
			if (!win){
				switchPlayer();
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	private void switchPlayer() {
		if (player == "RED"){
			player = "BLACK";
		}
		else{
			player = "RED";
		}
	}

	private int getRow(int col, int row) {
		if ((row<0)||(game[row][col].isEmpty())){
			return row;
		}
		else {
			return getRow(col,row-1);
		}
	}
	
	public String getPlayer(){
		return player;
	}
	
	public Boolean gameOver(){
		return win;
	}

	//determine if the last piece placement is a win
	private Boolean win(int row, int col){
		if ((horiz(row, col)>=4)||(vert(row, col)>=4)||(diag1(row, col)>=4)||(diag2(row, col)>=4)){
			return true;
		}
		else{
			return false;
		}
	}
	
	//check for a horizontal win
	private int horiz(int row, int col){
		if (game[row][col].getColor()==player){
			return (1 + horizL(row, col-1) + horizR(row, col+1));
		}
		else{
			return 0;
		}
	}
	
	//check to the left
	private int horizL(int row, int col){
		if ((col >= 0)&&(game[row][col].getColor()==player)){
			return (1 + horizL(row, col-1));
		}
		else {
			return 0;
		}
	}
	
	//check to the right
	private int horizR(int row, int col){
		if ((col < game[0].length)&&(game[row][col].getColor()==player)){
			return (1 + horizR(row, col+1));
		}
		else {
			return 0;
		}
	}
	
	//check for a vertical win
	private int vert(int row, int col){
		if (game[row][col].getColor()==player){
			return (1 + vertU(row-1, col) + vertD(row+1, col));
		}
		else{
			return 0;
		}
	}
	
	//check upwards
	private int vertU(int row, int col){
		if ((row >= 0)&&(game[row][col].getColor()==player)){
			return (1 + vertU(row-1, col));
		}
		else {
			return 0;
		}
	}
		
	//check downwards
	private int vertD(int row, int col){
		if ((row < game.length)&&(game[row][col].getColor()==player)){
			return (1 + vertD(row+1, col));
		}
		else {
			return 0;
		}
	}
	
	//check for a diagonal win
	private int diag1(int row, int col){
		if (game[row][col].getColor()==player){
			return (1 + diag1UL(row-1, col-1) + diag1DR(row+1, col+1));
		}
		else{
			return 0;
		}
	}
	
	//check up and left
	private int diag1UL(int row, int col){
		if ((row >= 0)&&(col>=0)&&(game[row][col].getColor()==player)){
			return (1 + diag1UL(row-1, col-1));
		}
		else {
			return 0;
		}
	}
	
	//check down and right
	private int diag1DR(int row, int col){
		if ((row < game.length)&&(col < game[0].length)&&(col>=0)&&(game[row][col].getColor()==player)){
			return (1 + diag1DR(row+1, col+1));
		}
		else {
			return 0;
		}
	}
	
	//check for a diagonal win
	private int diag2(int row, int col){
		if (game[row][col].getColor()==player){
			return (1 + diag2UR(row-1, col+1) + diag2DL(row+1, col-1));
		}
		else{
			return 0;
		}
	}
	
	//check up and left
	private int diag2UR(int row, int col){
		if ((row >= 0)&&(col>=0)&&(game[row][col].getColor()==player)){
			return (1 + diag2UR(row-1, col+1));
		}
		else {
			return 0;
		}
	}
	
	//check down and right
	private int diag2DL(int row, int col){
		if ((row < game.length)&&(col < game[0].length)&&(col>=0)&&(game[row][col].getColor()==player)){
			return (1 + diag2DL(row+1, col-1));
		}
		else {
			return 0;
		}
	}
}
