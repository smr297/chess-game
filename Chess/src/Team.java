import java.awt.Color;
import java.util.ArrayList;

public class Team {
	
	private Color c;
	private ArrayList<Piece> pieces = new ArrayList<Piece>();

	public Team(Color c1) {
		int temp = 8;
		c = c1;
		if(c.equals(Color.WHITE)){
			temp = 1;
		}
		pieces.add(new Rook(c, temp, 0));
		pieces.add(new Rook(c, temp, 7));
		pieces.add(new Knight(c, temp, 1));
		pieces.add(new Knight(c, temp, 6));
		pieces.add(new Bishop(c, temp, 2));
		pieces.add(new Bishop(c, temp, 5));
		pieces.add(new King(c, temp, 3));
		pieces.add(new Queen(c, temp, 4));
		
		if (temp == 1)
			temp++;
		else
			temp--;
		for(int i = 0; i < 8; i++){
			pieces.add(new Pawn(c, temp, i));
		}
	}
		
}


