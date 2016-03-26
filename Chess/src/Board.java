import java.awt.Color;

public class Board {
	Tile[][] gameBoard = new Tile[8][8];

	public Board() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				gameBoard[i][j] = new Tile();
				if((i+j) % 2 == 1)
					gameBoard[i][j].setColor(Color.BLACK);	
			}
		}
	}
	
	public void setPieceAt(Piece p, int x, int y){
		getTileAt(x,y).setPiece(p);
	}
	
	public Piece getPieceAt(int x, int y){
		return getPieceOnTile(getTileAt(x, y));
	}
	
	public boolean isEmpty(int x, int y){
		return getPieceAt(x, y) == null;
			
	}
	
	public static boolean onBoard(int x, int y){
		return !(x < 0 || x > 7 || y < 0 || y > 7);
	}
	
	public boolean isAttackedBy(int x, int y, Team t){
		for (int i = 0; i < t.getTeam().length; i++){
			if (t.getTeam()[i].canMoveTo(this, t, x, y))
				return true;
		}
		return false;
	}
	
	
	/*public String toString(){
		String str = "";
	    for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				str += gameBoard[i][j] + " ";
			}
			str += "\n";
	    }
	    return str;
	}*/
	
	public String toString(){
		String str = "";
	    for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				str += getPieceAt(i, j);
			}
			str += "\n";
	    }
	    return str;
	}
	
	private Tile getTileAt(int x, int y){
		return gameBoard[x][y];
	}
	private Piece getPieceOnTile(Tile t){
		return t.getPiece();
	}
	


	
	public class Tile {
		private Color c;
		private static final int iLen = 3;
		private Piece p;
		
		public Tile(){
			c = Color.WHITE;
			p = null;
		}
		
		public void setPiece(Piece p){
			this.p = p;
		}
		
		public void setColor(Color c){
			this.c = c;
		}
		
		public Piece getPiece(){
			return p;
		}
		
		public Color getColor(){
			return c;
		}
		
		public int getLength(){
			return iLen;
		}
		
		public String toString(){
			if (c.equals(Color.WHITE))
				return "WHITE";
			else
				return "BLACK";
		}
	}
}
