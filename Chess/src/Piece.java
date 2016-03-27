import java.awt.Color;
import java.util.HashSet;
import java.util.Iterator;

public abstract class Piece {
	
	protected Color c; //Black and White
	protected int x; //Between 0-7
	protected int y; //Between 0-7

	public Piece(Color c, int x, int y) {
		this.c = c;
		this.x = x;
		this.y = y;
	}
	
	public void setLocation(Board b, int xLoc, int yLoc){
		x = xLoc;
		y = yLoc;
		
		b.setPieceAt(this, xLoc, yLoc);
		
	}
	
	public Loc getLocation(){
		return new Loc(x, y);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Color getColor(){
		return c;
	}
	
	public boolean isBlack(){
		return c.equals(Color.BLACK);
	}
	
	public boolean isWhite(){
		return c.equals(Color.WHITE);
	}
	
	public boolean sameTeam(Piece p){
		if(p == null)
			return false;
		return this.getColor().equals(p.getColor());
	}
	
	public boolean diffTeam(Piece p){
		if(p == null)
			return false;
		return !sameTeam(p);
	}
	
	public abstract HashSet<Loc> getValidMoves(Board b, Team t);
	
	public boolean canMoveTo(Board b, Team t, int x, int y){
		Iterator iterator = getValidMoves(b, t).iterator(); 
		while(iterator.hasNext()){
			Loc item = (Loc) iterator.next();
			if (item.getX() == x && item.getY() == y)
				return true;
		}
		
		return false;
	}
	
	public abstract String toString();
	
	

}
