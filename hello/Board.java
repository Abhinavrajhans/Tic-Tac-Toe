package hello;


public interface Board {

    void makeMove(int move, char playerSymbol);
    int getTurn();
    int[] getBoard();
    void createBoard();
    void draw();
    int checkWinner();

}