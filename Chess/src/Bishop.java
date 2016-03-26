import java.awt.Color;
import java.util.HashSet;


public class Bishop extends Piece {

	public Bishop(Color c, int x, int y) {
		super(c, x, y);
	}

	@Override
	public HashSet<Loc> getValidMoves(Board b, Team t) {
		HashSet<Loc> moves = new HashSet<Loc>();
		moves.addAll(diagonalCheck(b,1,1));
		moves.addAll(diagonalCheck(b,1,-1));
		moves.addAll(diagonalCheck(b,-1,1));
		moves.addAll(diagonalCheck(b, -1, -1));
		return moves;
	}
	
	private HashSet<Loc> diagonalCheck(Board b, int i, int j){
		HashSet<Loc> moves = new HashSet<Loc>();
		int newX = x+i;
		int newY = y+j;
		if(!Board.onBoard(newX, newY))
			return moves;
		Piece p = b.getPieceAt(newX, newY);
		
		if(p == null){
			moves.add(new Loc(newX, newY));
			if ((i > 0) && (j > 0))
				moves.addAll(diagonalCheck(b, i+1, j+1));
			else if  ((i > 0) && (j < 0))
				moves.addAll(diagonalCheck(b, i+1, j-1));
			else if  ((i < 0) && (j > 0))
				moves.addAll(diagonalCheck(b, i-1, j+1));
			else 
				moves.addAll(diagonalCheck(b, i-1, j-1));
				
		} else if (diffTeam(p)){
			moves.add(new Loc(newX, newY));
		}
		return moves;
	}
	
	public String toString(){
		return "BISHOP ";
	}

}
