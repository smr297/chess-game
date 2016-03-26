import java.awt.Color;

public class GamePlay {
	Board b = new Board();
	Team whiteTeam = new Team(Color.white);
	Team blackTeam = new Team(Color.black);

	public GamePlay() {
		initializeBoard();
	}
	
	private void initializeBoard(){
		for(Piece p: whiteTeam.getTeam()){
			p.setLocation(b, p.getX(), p.getY());
		}
		
		for(Piece p: blackTeam.getTeam()){
			p.setLocation(b, p.getX(), p.getY());
		} 
	}
	
	private void movePiece(Piece p){
		
	}
	
	private void deletePiece(Piece p){
		p = null;
	}

}
