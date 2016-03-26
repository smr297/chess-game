import java.awt.Color;
import java.util.HashSet;

public abstract class Piece {
	
	protected Color c; //Black and White
	protected int x; //Between 0-7
	protected int y; //Between 0-7

	public Piece(Color c, int x, int y) {
		this.c = c;
		this.x = x;
		this.y = y;
	}
	
	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
		
	}
	
	public Loc getLocation(){
		return new Loc(x, y);
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
	
	public abstract HashSet<Loc> getValidMoves(Board b);
	
	public boolean canMoveTo(Board b, int x, int y){
		return getValidMoves(b).contains(new Loc(x, y));
	}

}
