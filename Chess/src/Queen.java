import java.awt.Color;
import java.util.HashSet;

public class Queen extends Piece {

	public Queen(Color c, int x, int y) {
		super(c, x, y); 
	}
	
	@Override
	public HashSet<Loc> getValidMoves(Board b, Team t) {
		HashSet<Loc> moves = new HashSet<Loc>();
		moves.addAll(horizontalCheck(b,1));
		moves.addAll(horizontalCheck(b, -1));
		moves.addAll(verticalCheck(b, 1));
		moves.addAll(verticalCheck(b, -1));
		moves.addAll(diagonalCheck(b,1,1));
		moves.addAll(diagonalCheck(b,1,-1));
		moves.addAll(diagonalCheck(b,-1,1));
		moves.addAll(diagonalCheck(b, -1, -1));
		return moves;
		
	}

	private HashSet<Loc> horizontalCheck(Board b, int i){
		HashSet<Loc> moves = new HashSet<Loc>();
		int newX = x+i;
		if(!Board.onBoard(newX, y))
			return moves;
		Piece p = b.getPieceAt(newX, y);
		
		if(p == null){
			moves.add(new Loc(newX, y));
			if (i > 0)
				moves.addAll(horizontalCheck(b, i+1));
			else
				moves.addAll(horizontalCheck(b, i-1));
				
		} else if (diffTeam(p)){
			moves.add(new Loc(newX, y));
		}
	
		return moves;
	}
	
	private HashSet<Loc> verticalCheck(Board b, int i){
		HashSet<Loc> moves = new HashSet<Loc>();
		int newY = y+i;
		if(!Board.onBoard(x, newY))
			return moves;
		Piece p = b.getPieceAt(x, newY);
		
		if(p == null){
			moves.add(new Loc(x, newY));
			if (i > 0)
				moves.addAll(verticalCheck(b, i+1));
			else
				moves.addAll(verticalCheck(b, i-1));
				
		} else if (diffTeam(p)){
			moves.add(new Loc(x, newY));
		}
	
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
		return "QUEEN  ";
	}

	

	
}
