package logic;

public class Slot {
	
	private int state = 0;
		
	public Slot(){
		state=0;
	}
	
	public Boolean isEmpty(){
		if (state == 0) {
			return true;
		}
		else return false;
	}
	
	public void putPiece(String player){
		if (player=="RED"){
			state=1;
		}
		else {
			state=2;
		}
	}
	
	public String getColor(){
		if (this.isEmpty()){
			return "EMPTY";
		}
		else if (state == 1){
			return "RED";
		}
		else return "BLACK";
	}
}
