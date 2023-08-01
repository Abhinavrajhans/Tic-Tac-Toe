package TicTacToe;

public interface Board {

    void makeMove(int move, char playerSymbol);
    int getTurn();
    int[] getBoard();
    void draw();
    boolean checkDraw();
    int checkWinner();

}