import java.awt.Color;
import java.util.ArrayList;

public class Team {
	
	private Color c;
	private Piece pieces[] = new Piece[16];

	public Team(Color c1) {
		int temp = 8;
		c = c1;
		if(c.equals(Color.WHITE)){
			temp = 1;
		}
		pieces[0] = (new Rook(c, temp, 0));
		pieces[7] = (new Rook(c, temp, 7));
		pieces[1] = (new Knight(c, temp, 1));
		pieces[6] = (new Knight(c, temp, 6));
		pieces[2] = (new Bishop(c, temp, 2));
		pieces[5] = (new Bishop(c, temp, 5));
		pieces[3] = (new King(c, temp, 3));
		pieces[4] = (new Queen(c, temp, 4));
		
		if (temp == 1)
			temp++;
		else
			temp--;
		for(int i = 0; i < 8; i++){
			pieces[i+8] = (new Pawn(c, temp, i));
		}
	}
	
	public void setPieceNull(Piece p){
		for(int i = 0; i < pieces.length; i++){
			if (pieces[i] == p)
				pieces[i] = null;
				
		}
		
	}
	
	public Piece[] getTeam(){
		return pieces;
	}
		
}


