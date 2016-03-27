import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner vReader = new Scanner(System.in);
		GamePlay gp = new GamePlay();
		String move = "";
		while(!gp.gameOver()){
			move = "";
			System.out.println(gp.b);
			while(move.length() != 4 && !gp.turnComp){
			  System.out.print("Enter move: ");
			  move = vReader.next();
			  gp.moveTest(move);
			}
			
			gp.nextTurn();

			}
			
			
		}
			
	}


