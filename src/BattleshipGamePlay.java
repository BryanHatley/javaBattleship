package BSPackage;

import java.util.Scanner;

public class BattleshipGamePlay 
{
	private int[][] guessBoardP1;
	private int[][] guessBoardP2;
	private BattleshipPlayer p1;
	private BattleshipPlayer p2;
	private int[][] p1Board;
	private int[][] p2Board;
	private Scanner input;
	
	public BattleshipGamePlay()
	{
		input = new Scanner(System.in);
		guessBoardP1 = boardInitialize();
		guessBoardP2 = boardInitialize();
		p1 = new BattleshipPlayer(input);
		p2 = new BattleshipPlayer(input);
		p1Board = p1.getBoard();
		p2Board = p2.getBoard();
		gameStart();
		input.close();
	}
	
	private int[][] boardInitialize()
	{
		int[][] board = new int[10][10];
		for (int i =0; i < 10; i++)
		{
			for (int m = 0; m < 10; m++)
			{
				board[i][m] = 0;
			}
		}
		return board;
	}
	
	private void gameStart()
	{
		boolean win = false;
		System.out.println("The game is about to begin");
		while (win == false)
		{
			int n = 0;
			String s = "";
			char c = 'z';
			System.out.print("Player 1's turn, press enter to begin: ");
			input.nextLine();
			System.out.println();
			printBoard(guessBoardP1);
			System.out.print("Input guess (first letter then number): ");
			s = input.nextLine();
			n = input.nextInt();
			c = s.charAt(0);
			checkHit(c, n, 1, 2);
			if(winCheck(guessBoardP1) == true)
			{
				System.out.println("Player 1 won");
				break;
			}
			System.out.print("Player 2's turn, press enter to begin: ");
			input.nextLine();
			System.out.println();
			printBoard(guessBoardP2);
			System.out.print("Input guess (first letter then number): ");
			s = input.nextLine();
			n = input.nextInt();
			c = s.charAt(0);
			checkHit(c, n, 2, 1);
			if(winCheck(guessBoardP2) == true)
			{
				System.out.println("Player 2 won");
				break;
			}
		}
	}
	
	private  void checkHit(char c, int n, int gPlayer, int tPlayer)
	{
		int b;
		if (c >= 'A' && c <= 'J')
		{
			b = (c - 65);
		}
		else
		{
			b = (c - 97);
		}
		n = n - 1;
		if (gPlayer == 1)
		{
			if (p2Board[b][n] > 0 && p2Board[b][n] < 6)
			{
				guessBoardP1[b][n] = 1;
				System.out.println("It's a hit.");
			}
			else
			{
				guessBoardP1[b][n] = 2;
				System.out.println("It's a miss.");
			}
		}
		else
		{
			if (p1Board[b][n] > 0 && p1Board[b][n] < 6)
			{
				guessBoardP2[b][n] = 1;
				System.out.println("It's a hit.");
			}
			else
			{
				guessBoardP2[b][n] = 2;
				System.out.println("It's a miss.");
			}
		}
	}
	
	private boolean winCheck(int[][] board)
	{
		int count = 0;
		for (int i = 0; i < 10; i++)
		{
			for (int a = 0; a < 10; a++)
			{
				if (board[i][a] == 1)
				{
					count = count + 1;
				}
			}
		}
		if (count == 17)
		{
			return true;
		}
		return false;
	}
	
	private void printBoard(int[][] board)
	{
		System.out.println(" |1|2|3|4|5|6|7|8|9|0|");
		System.out.println(" ---------------------");
		for (int a = 0; a < 10; a++)
		{
			char c = (char)(a + 65);
			System.out.print(c);
			for (int i = 0; i < 10; i++)
			{
				System.out.print("|" + board[a][i]);	
			}
			System.out.print("|\n");
		}
		System.out.println(" ---------------------");	
	}
	

}
