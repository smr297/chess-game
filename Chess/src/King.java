import java.awt.Color;
import java.util.HashSet;


public class King extends Piece {
	private static final Loc[] positions = {new Loc(1, 1), new Loc(-1, 1), new Loc(1, -1), new Loc(-1, -1), 
		new Loc(0, 1), new Loc(1, 0), new Loc(-1, 0), new Loc(0, -1)};
	
	public King(Color c, int x, int y) {
		super(c, x, y);
	}


	@Override
	public HashSet<Loc> getValidMoves(Board b, Team otherTeam) {
	  Piece p = null;
	  HashSet<Loc> moves = new HashSet<Loc>();
		for(Loc factor: positions){
			int newX = x+factor.getX();
			int newY = y+factor.getY();
			
			if(Board.onBoard(newX, newY)){
			  p = b.getPieceAt(newX, newY);
			}
			if(Board.onBoard(newX, newY) && !sameTeam(p) && !b.isAttackedBy(newX, newY, otherTeam)){
				moves.add(new Loc(newX, newY));
			}
		
		}
		return moves;
		
	
	}
	
	public HashSet<Loc> getPossibleMoves(Board b) {
		
			  HashSet<Loc> moves = new HashSet<Loc>();
				for(Loc factor: positions){
					int newX = x+factor.getX();
					int newY = y+factor.getY();
					
					if(Board.onBoard(newX, newY)){
					  moves.add(new Loc (newX, newY));
					}
				}
				return moves;
	}
	
	
	
	public boolean isCheckedBy(Board b, Team otherTeam){
	  return b.isAttackedBy(this.x, this.y, otherTeam);
	}
	
	public String toString(){
		return "KING   ";
	}

}
