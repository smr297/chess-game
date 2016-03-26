import java.awt.Color;
import java.util.HashSet;


public class King extends Piece {
	
	private boolean check = false;
	private boolean moved = false;
	
	public King(Color c, int x, int y) {
		super(c, x, y);
	}


	@Override
	public HashSet<Loc> getValidMoves(Board b) {
		// TODO Auto-generated method stub
		return null;
	}

}
