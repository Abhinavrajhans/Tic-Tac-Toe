package hello;

import java.util.*;
public class Game implements Board {
	
	public Scanner obj=new Scanner(System.in);
    int size, currentPlayer, gameId;
    char gameType;
    int[] players;
    char[] currentBoard;
    boolean hasEnded = false;
    int winner=0;

    public Game(int size,int gameId, char gameType) {

        this.size = size;
        this.currentPlayer =0;
        this.gameId = gameId;
        currentBoard=new char[(size*size)];
        createBoard();
    }

    @Override
    public void makeMove(int move, char playerSymbol) {
        this.currentBoard[move] = playerSymbol;
        winner = checkWinner();
        if(winner!=0) { //0, 1, 2
            hasEnded = true;
        }
    }
    
    @Override
    public int getTurn() {
        return currentPlayer;
    }

   
    public void createBoard() {
    	    int sz=currentBoard.length;
            for(int i=0; i<sz; i++) {
                this.currentBoard[i] = '-';
            }
            for(int i=0;i<(size*size) && !hasEnded;i++)
            {
            	System.out.println("Enter the Index :");
            	int index=obj.nextInt();
            	if(i%2==0)
            	{
            		makeMove(index,'X');
            	}
            	else {
            		makeMove(index,'O');
            	}
            }
     }

    @Override
    public void draw() {
    	for(int i=0;i<9;i++)
    	{
    		System.out.print(currentBoard[i]+" ");
    		if(i==2 || i==5)System.out.println();
    	}
    	System.out.println();
    }
    
    @Override
    public int[] getBoard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoard'");
    }

   

    @Override
    public int checkWinner() {
    	
    	for(int i=0,j=0;i<currentBoard.length;i+=3,j+=1)
    	{
    		if(currentBoard[i]==currentBoard[i+1] && currentBoard[i+1]==currentBoard[i+2] && currentBoard[i]!='-')
    		{
    			if(currentBoard[i]=='X')return 1;
    			else return 2;
    		}
    		if(currentBoard[j]==currentBoard[j+size] && currentBoard[j+size]==currentBoard[j+(2*size)] &&  currentBoard[i]!='-')
    		{
    			if(currentBoard[i]=='X')return 1;
    			else return 2;
    		}
    	}
    	if(currentBoard[0]==currentBoard[4] && currentBoard[4]==currentBoard[8] && currentBoard[0]!='-')
		{
    		if(currentBoard[0]=='X')return 1;
			else return 2;
		}
    	if(currentBoard[2]==currentBoard[4] && currentBoard[4]==currentBoard[6] &&  currentBoard[2]!='-')
		{
    		if(currentBoard[4]=='X')return 1;
			else return 2;
		}
    	
    	return 0;
    }
}
