package BSPackage;

import java.util.Scanner;

public class BattleshipPlayer 
{
	private int[][] board;
	private Scanner input;
	
	public BattleshipPlayer(Scanner input)
	{
		//Initialize game board and guess board
		boardInitialize();
		this.input = input;
		pieceSetUp();
	}
	
	private void boardInitialize()
	{
		board = new int[10][10];
		for (int i =0; i < 10; i++)
		{
			for (int m = 0; m < 10; m++)
			{
				board[i][m] = 0;
			}
		}
	}
	
	private void pieceSetUp()
	{
		int startNum = 0;
		int endNum = 0;
		char startChar = 0;
		char endChar = 0;
		int pieceSize = 0;
		printBoard(board);
		System.out.println("You will now set up your pieces, input the letter first, followed by the number.");
		boolean valid = false;
		pieceSize = 5;
		while (!valid) 
		{
			System.out.print("Input the start postion of your carrier: ");
			String s = input.nextLine();
			startNum = input.nextInt();
			input.nextLine();
			startChar = s.charAt(0);
			System.out.print("Input the end postion of your carrier: ");
			s = input.nextLine();
			endNum = input.nextInt();
			input.nextLine();
			endChar = s.charAt(0);
			if(checkIfValid(startChar, startNum, endChar, endNum, pieceSize))
			{
			valid = true;
			}
			else
			{
				System.out.println("Piece in invalid postion, enter postion again.");
			}
		}
		placePiece(startChar, startNum, endChar, endNum, 1);
		printBoard(board);
		valid = false;
		pieceSize = 4;
		while (!valid) 
		{
			System.out.print("Input the start postion of your battleship: ");
			String s = input.nextLine();
			startNum = input.nextInt();
			input.nextLine();
			startChar = s.charAt(0);
			System.out.print("Input the end postion of your battleship: ");
			s = input.nextLine();
			endNum = input.nextInt();
			input.nextLine();
			endChar = s.charAt(0);
			if(checkIfValid(startChar, startNum, endChar, endNum, pieceSize))
			{
			valid = true;
			}
			else
			{
				System.out.println("Piece in invalid postion, enter postion again.");
			}
		}
		placePiece(startChar, startNum, endChar, endNum, 2);
		printBoard(board);
		valid = false;
		pieceSize = 3;
		while (!valid) 
		{
			System.out.print("Input the start postion of your cruiser: ");
			String s = input.nextLine();
			startNum = input.nextInt();
			input.nextLine();
			startChar = s.charAt(0);
			System.out.print("Input the end postion of your cruiser: ");
			s = input.nextLine();
			endNum = input.nextInt();
			input.nextLine();
			endChar = s.charAt(0);
			if(checkIfValid(startChar, startNum, endChar, endNum, pieceSize))
			{
			valid = true;
			}
			else
			{
				System.out.println("Piece in invalid postion, enter postion again.");
			}
		}
		placePiece(startChar, startNum, endChar, endNum, 3);
		printBoard(board);
		valid = false;
		pieceSize = 3;
		while (!valid) 
		{
			System.out.print("Input the start postion of your submarine: ");
			String s = input.nextLine();
			startNum = input.nextInt();
			input.nextLine();
			startChar = s.charAt(0);
			System.out.print("Input the end postion of your submarine: ");
			s = input.nextLine();
			endNum = input.nextInt();
			input.nextLine();
			endChar = s.charAt(0);
			if(checkIfValid(startChar, startNum, endChar, endNum, pieceSize))
			{
				valid = true;
			}
			else
			{
				System.out.println("Piece in invalid postion, enter postion again.");
			}
		}
		placePiece(startChar, startNum, endChar, endNum, 4);
		printBoard(board);
		valid = false;
		pieceSize = 2;
		while (!valid) 
		{
			System.out.print("Input the start postion of your destroyer: ");
			String s = input.nextLine();
			startNum = input.nextInt();
			input.nextLine();
			startChar = s.charAt(0);
			System.out.print("Input the end postion of your destroyer: ");
			s = input.nextLine();
			endNum = input.nextInt();
			input.nextLine();
			endChar = s.charAt(0);
			if(checkIfValid(startChar, startNum, endChar, endNum, pieceSize))
			{
			valid = true;
			}
			else
			{
				System.out.println("Piece in invalid postion, enter postion again.");
			}
		}
		placePiece(startChar, startNum, endChar, endNum, 5);
		printBoard(board);
		System.out.print("This is your final setup. Press enter to continue: ");
		input.nextLine();
		System.out.println();
		for (int i = 0; i < 40; i++)
		{
			System.out.println();
		}
	}
	
	public void printBoard(int[][] board)
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
	
	private void placePiece(char sC, int sN, char eC, int eN, int p)
	{
		if (sC == eC)
		{
			if (sC <= 90 && sC >= 65)
			{
				for (int i = (sN - 1); i <= (eN - 1); i++)
				{
					board[(sC - 65)][i] = p;
				}
			}
			else
			{
				for (int i = (sN - 1); i <= (eN - 1); i++)
				{
					board[(sC - 97)][i] = p;
				}
			}
			
		}
		else
		{
			if (sC <= 90 && sC >= 65)
			{
				for (int i = (sC - 65); i <= (eC - 67); i++)
				{
					board[i][sN - 1] = p;
				}
			}
			else
			{
				for (int i = (sC - 97); i <= (eC - 97); i++)
				{
					board[i][sN - 1] = p;
				}
			}
		}
	}
	
	private boolean checkIfValid(int sC, int sN, int eC, int eN, int pS)
	{
		if (sC <= 90 && sC >= 65)
		{
			if (sC > 74)
			{
				return false;
			}
			else
			{
				sC = sC - 65;	
			}
		}
		else
		{
			if (sC > 106 || sC < 97)
			{
				return false;
			}
			else
			{
				sC = sC - 97;
			}
		}
		if (eC <= 90 && eC >= 65)
		{
			if (eC > 74)
			{
				return false;
			}
			else
			{
				eC = eC - 65;	
			}
		}
		else
		{
			if (eC > 106 || eC < 97)
			{
				return false;
			}
			else
			{
				eC = eC - 97;
			}
		}
		if (sC > eC)
		{
			if((sC - eC) > pS)
			{
				return false;
			}
		}
		else
		{
			if((eC - sC) > pS)
			{
				return false;
			}
		}
		if (sN > eN)
		{
			if ((sN - eN) > pS)
			{
				return false;
			}
		}
		else
		{
			if ((eN - sN) > pS)
			{
				return false;
			}
		}
		if (sC > eC)
		{
			if (sN > eN)
			{
				if((sC - eC) > 0 && (sN - eN) > 0)
				{
					return false;
				}
			}
			else
			{
				if((sC - eC) > 0 && (eN - sN) > 0)
				{
					return false;
				}
			}
		}
		else 
		{
			if (sN > eN)
			{
				if((eC - sC) > 0 && (sN - eN) > 0)
				{
					return false;
				}
			}
			else
			{
				if((eC - sC) > 0 && (eN - sN) > 0)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public int[][] getBoard()
	{
		return board;
	}
}
