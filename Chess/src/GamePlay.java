import java.awt.Color;

public class GamePlay {
	Board b = new Board();
	Team whiteTeam = new Team(Color.white, b);
	Team blackTeam = new Team(Color.black, b);
	boolean whiteTurn = true;
	boolean blackTurn = false;
	boolean turnComp = false;

	public GamePlay() {
		initializeBoard();
	}
	
	private void initializeBoard(){
		for(Piece p: whiteTeam.getTeam()){
			p.setLocation(b, p.getX(), p.getY());
		}
		
		for(Piece p: blackTeam.getTeam()){
			p.setLocation(b, p.getX(), p.getY());
		} 
	}
	
	public void moveTest(String s){
		
		movePiece(b.getPieceAt(Character.getNumericValue(s.charAt(0)), 
				(Character.getNumericValue(s.charAt(1)))), (Character.getNumericValue(s.charAt(2))),
				(Character.getNumericValue(s.charAt(3))));
		
	}
	
	
	public void movePiece(Piece p, int x, int y){
		if (p == null){
			System.out.println("Select valid piece");
			
		}
		else if ((p.getColor() == Color.white) && whiteTurn){

			if(p.canMoveTo(b, blackTeam, x, y)){
				deletePiece(x,y);
				b.setPieceAt(null, p.getX(), p.getY());
				p.setLocation(b, x, y);
				turnComp = true;
				System.out.println("Reached 1");
			} else {
				System.out.println("Not a valid move 1");
			}
			
		} else if ((p.getColor() == Color.black) && blackTurn) {
			if(p.canMoveTo(b, whiteTeam, x, y)){
				deletePiece(x,y);
				b.setPieceAt(null, p.getX(), p.getY());
				p.setLocation(b, x, y);
				turnComp = true;
				System.out.println("Reached 2");
			} else {
				System.out.println("Not a valid move 2");
			}
			
		} else if ((p.getColor() == Color.white) && blackTurn){
			System.out.println("It is black's turn to move");
		} else {
			System.out.println("It is white's turn to move");
		}
	}
	
	private void deletePiece(int x, int y){
		Piece temp = b.getPieceAt(x, y);
		if(b.isEmpty(x, y)){
			return;
		} else { 
			if(temp.getColor() == Color.white){
				whiteTeam.setPieceNull(temp);
			} else {
				blackTeam.setPieceNull(temp);}
			b.setPieceAt(null, x, y);
		}
		
	}
	
	public void nextTurn(){
		turnComp = false;
		whiteTurn = !whiteTurn;
		blackTurn = !blackTurn;
	}
	
	public boolean gameOver(){
		return (whiteWin() || blackWin() || stalemate());
			
	}
	
	public boolean whiteWin(){
		return ((blackTeam.getKing().getValidMoves(b, whiteTeam).isEmpty()) && 
		 (blackTeam.getKing().isCheckedBy(b, whiteTeam)));
	}
	
	public boolean blackWin(){
		return ((whiteTeam.getKing().getValidMoves(b, blackTeam).isEmpty()) && 
				 (whiteTeam.getKing().isCheckedBy(b, blackTeam)));
		}
	public boolean stalemate(){
		return ((blackTeam.noMoves() && blackTurn) ||
				(whiteTeam.noMoves() && whiteTurn));
	}

}
