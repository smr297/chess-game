import java.awt.Color;
import java.util.HashSet;


public class King extends Piece {
	private static final Loc[] positions = {new Loc(1, 1), new Loc(-1, 1), new Loc(1, -1), new Loc(-1, -1), 
		new Loc(0, 1), new Loc(1, 0), new Loc(-1, 0), new Loc(0, -1)};
	
	public King(Color c, int x, int y) {
		super(c, x, y);
	}


	@Override
	public HashSet<Loc> getValidMoves(Board b, Team t) {
	  HashSet<Loc> moves = new HashSet<Loc>();
		for(Loc factor: positions){
			int newX = x+factor.getX();
			int newY = y+factor.getY();
			Piece p = b.getPieceAt(newX, newY);
			
			if(Board.onBoard(newX, newY) && !sameTeam(p) && !b.isAttackedBy(this.x, this.x, t)){
				moves.add(new Loc(newX, newY));
			}
		
		}
		return moves;
		
	
	}
	
	public boolean isChecked(Board b, Team t){
	  return b.isAttackedBy(this.x, this.x, t);
	}
	
	public String toString(){
		return "KING ";
	}

}
