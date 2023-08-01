import java.util.Scanner;

class Cell {
    // You can define Cell properties here if needed.
}

class Board {
    private final Cell[] cells;

    public Board() {
        // Initialize the board with empty cells.
        cells = new Cell[9];
        for (int i = 0; i < 9; i++) {
            cells[i] = new Cell();
        }
    }

    public boolean placeMove(int position, char symbol) {
        // Validate the position (1-9).
        if (position < 1 || position > 9) {
            return false;
        }

        // Convert the position (1-9) to row and column indices (0-2).
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;


        return true;
    }

    public boolean checkWin(char symbol) {

        return false;
    }

    public boolean checkDraw() {

        return false;
    }


}

class Player {
    private final String name;
    private final char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}

class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private int currentPlayerIndex;
    private boolean gameOver;

    public Game(String player1Name, char player1Symbol, String player2Name, char player2Symbol) {
        board = new Board();
        player1 = new Player(player1Name, player1Symbol);
        player2 = new Player(player2Name, player2Symbol);
        currentPlayerIndex = 0;
        gameOver = false;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            printBoard();

            Player currentPlayer = currentPlayerIndex == 0 ? player1 : player2;
            System.out.println(currentPlayer.getName() + ", it's your turn.");
            System.out.println("Enter the cell number (1-9):");
            int cellNumber = scanner.nextInt();

            while (!board.placeMove(cellNumber, currentPlayer.getSymbol())) {
                System.out.println("Invalid move. Try again.");
                System.out.println("Enter the cell number (1-9):");
                cellNumber = scanner.nextInt();
            }

            if (board.checkWin(currentPlayer.getSymbol())) {
                printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                gameOver = true;
            } else if (board.checkDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                gameOver = true;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % 2;
        }

        scanner.close();
    }

    public void printBoard() {
        System.out.println("Current Board:");

    }


}

public class Play {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name for Player 1:");
        String player1Name = scanner.nextLine().trim();
        System.out.println("Enter symbol (X or O) for Player 1:");
        char player1Symbol = scanner.next().toUpperCase().charAt(0);
        scanner.nextLine();

        char player2Symbol = (player1Symbol == 'X') ? 'O' : 'X';
        System.out.println("Enter name for Player 2:");
        String player2Name = scanner.nextLine().trim();

        Game game = new Game(player1Name, player1Symbol, player2Name, player2Symbol);
        game.start();
    }
}
