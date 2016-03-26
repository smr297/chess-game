import java.awt.Color;
import java.util.HashSet;

public class Knight extends Piece {
	private static final Loc[] positions = {new Loc(1, 2), new Loc(-1, 2), new Loc(1, -2), new Loc(-1, -2), 
			new Loc(2, 1), new Loc(-2, 1), new Loc(2, -1), new Loc(-2, -1)};

	public Knight(Color c, int x, int y) {
		super(c, x, y);
	}

	@Override
	public HashSet<Loc> getValidMoves(Board b, Team t) {
		HashSet<Loc> moves = new HashSet<Loc>();
		for(Loc factor: positions){
			int newX = x+factor.getX();
			int newY = y+factor.getY();
			Piece p = b.getPieceAt(newX, newY);
			
			if(Board.onBoard(newX, newY) && !sameTeam(p)){
				moves.add(new Loc(newX, newY));
			}
		
		}
		return moves;
		
	}
}
