import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;

public class Team {
	
	private Color c;
	private Piece pieces[] = new Piece[16];
	private HashSet<Loc> moves = new HashSet<Loc>();

	public Team(Color c1, Board b) {
		int temp = 7;
		c = c1;
		if(c.equals(Color.WHITE)){
			temp = 0;
		}
		pieces[0] = (new Rook(c, temp, 0));
		pieces[1] = (new Knight(c, temp, 1));
		pieces[2] = (new Bishop(c, temp, 2));
		pieces[3] = (new King(c, temp, 3));
		pieces[4] = (new Queen(c, temp, 4));
		pieces[5] = (new Bishop(c, temp, 5));
		pieces[6] = (new Knight(c, temp, 6));
		pieces[7] = (new Rook(c, temp, 7));


		
		if (temp == 0)
			temp++;
		else
			temp--;
		for(int i = 0; i < 8; i++){
			pieces[i+8] = (new Pawn(c, temp, i));
		}
		
		for(Piece p: pieces){
			moves.addAll(p.getValidMoves(b, this));
		}
	}
	
	public boolean noMoves(){
		return moves.isEmpty();
	}
	
	public void setPieceNull(Piece p){
		for(int i = 0; i < pieces.length; i++){
			if (pieces[i] == p)
				pieces[i] = null;
				
		}
		
	}
	public void updateMoves(Board b){ 
		moves.clear();
		for(Piece p: pieces){
			moves.addAll(p.getValidMoves(b, this));
		}
	}
	public Piece[] getTeam(){
		return pieces;
	}
	
	public King getKing(){
		return (King) pieces[3];
			
	}
	
}


