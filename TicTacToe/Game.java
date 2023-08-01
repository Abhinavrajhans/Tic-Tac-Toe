package TicTacToe;

public class Game implements Board {

    int size, currentPlayer, gameId;
    char gameType;
    int[] players;
    char[] currentBoard;
    boolean hasEnded = false;

    public Game(int size,int gameId, char gameType, char[] currentBoard, int currentPlayer) {

        this.size = size;
        this.currentPlayer = currentPlayer;
        this.gameId = gameId;
        this.currentBoard = currentBoard;
    }

    @Override
    public void makeMove(int move, char playerSymbol) {
        this.currentBoard[move] = playerSymbol;
        int winner = checkWinner();

        if(winner!=0) { //0, 1, 2
            hasEnded = true;
        }
        else {
            hasEnded = checkDraw();
        }
    }
    
    @Override
    public int getTurn() {
        return currentPlayer;
    }

    @Override
    public int[] getBoard(int boardId) {
        return this.currentBoard;
    }

    @Override
    public void draw() {
        System.output.println(currentBoard);
    }
    
    @Override
    public int[] getBoard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoard'");
    }

    @Override
    public boolean checkDraw() {
        for (int i=0; i<Math.pow(size, 2); i++) {
            if (currentBoard[i] == ' ') {
                return false;
            }
            
        }
        return true;
    }

    @Override
    public int checkWinner() {
        return 0;
    }
}
