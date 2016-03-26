import java.awt.Color;
import java.util.HashSet;

public class Pawn extends Piece {

	public Pawn(Color c, int x, int y) {
		super(c, x, y);
	}

	@Override
	public HashSet<Loc> getValidMoves(Board b, Team t) {
		if (this.getColor().equals(Color.BLACK))
			return getBlackPossibleMoves(b);
		else
			return getWhitePossibleMoves(b);
		
	}
	
	private HashSet<Loc> getBlackPossibleMoves(Board b) {
		HashSet<Loc> moves = new HashSet<Loc>();
		if(Board.onBoard(x, y-1) && b.isEmpty(x, y-1))
			moves.add(new Loc(x, y-1));
		if(Board.onBoard(x-1, y-1) && diffTeam(b.getPieceAt(x-1, y-1)))
			moves.add(new Loc(x-1, y-1));
		if(Board.onBoard(x+1, y-1) && diffTeam(b.getPieceAt(x+1, y-1)))
			moves.add(new Loc(x+1, y-1));
		
		return moves;
	}
	
	private HashSet<Loc> getWhitePossibleMoves(Board b){
		HashSet<Loc> moves = new HashSet<Loc>();
		if(Board.onBoard(x, y+1) && b.isEmpty(x, y+1))
			moves.add(new Loc(x, y+1));
		if(Board.onBoard(x-1, y+1) && diffTeam(b.getPieceAt(x-1, y+1)))
			moves.add(new Loc(x-1, y+1));
		if(Board.onBoard(x+1, y+1) && diffTeam(b.getPieceAt(x+1, y+1)))
			moves.add(new Loc(x+1, y+1));
		
		return moves;
	}

}
