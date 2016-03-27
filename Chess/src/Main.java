import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner vReader = new Scanner(System.in);
		GamePlay gp = new GamePlay();
		String move = "";
		while(!gp.gameOver()){
			move = "";
			while(move.length() != 4 || (!gp.turnComp)){
			  System.out.println(gp.b);
			  System.out.print("Enter move: ");
			  move = vReader.next();
			  System.out.println(gp.b.isEmpty(2, 1));
			  System.out.println(gp.b.getPieceAt(2, 1));

			  gp.moveTest(move);
			}
			System.out.println("Reached");
			gp.nextTurn();

			}
			
			
		}
			
	}


