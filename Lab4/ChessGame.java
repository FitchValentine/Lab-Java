import java.util.Scanner;

public class ChessGame {

    public static void main(String[] args) {
        Board chessBoard = new Board();
        chessBoard.initializeBoard();

        Scanner scanner = new Scanner(System.in);

        while (!chessBoard.isGameOver()) {
            System.out.println(chessBoard);
            System.out.println("Ход " + (chessBoard.getCurrentPlayer() == Player.WHITE ? "белых" : "черных"));

            System.out.print("Введите координаты начальной и конечной клеток (например, e2 e4): ");
            String move = scanner.nextLine();

            try {
                chessBoard.makeMove(move);
            } catch (InvalidMoveException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

class Board {
    private Piece[][] board;
    private Player currentPlayer;

    public void initializeBoard() {
        board = new Piece[8][8];
        currentPlayer = Player.WHITE;

        // Расставляем фигуры на доске
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Player.WHITE);
            board[6][i] = new Pawn(Player.BLACK);
        }

        board[0][0] = new Rook(Player.WHITE);
        board[0][7] = new Rook(Player.WHITE);
        board[7][0] = new Rook(Player.BLACK);
        board[7][7] = new Rook(Player.BLACK);

        // Другие фигуры аналогично
    }

    public void makeMove(String move) throws InvalidMoveException {
        // Обработка хода
        int[] start = convertInput(move.substring(0, 2));
        int[] end = convertInput(move.substring(3, 5));

        Piece piece = board[start[0]][start[1]];

        if (piece == null || piece.getPlayer() != currentPlayer) {
            throw new InvalidMoveException("Неверная фигура для хода.");
        }

        if (!piece.isValidMove(start, end, board)) {
            throw new InvalidMoveException("Невозможный ход для этой фигуры.");
        }

        // Делаем ход
        board[end[0]][end[1]] = piece;
        board[start[0]][start[1]] = null;

        // Переключаем игрока
        currentPlayer = (currentPlayer == Player.WHITE) ? Player.BLACK : Player.WHITE;
    }

    public boolean isGameOver() {
        // Проверка на условия завершения игры (например, шах и мат)
        return false;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public String toString() {
        // Вывод текущего состояния доски
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    sb.append("- ");
                } else {
                    sb.append(board[i][j].toString()).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private int[] convertInput(String input) {
        int[] result = new int[2];
        result[0] = 8 - Character.getNumericValue(input.charAt(1));
        result[1] = input.charAt(0) - 'a';
        return result;
    }
}

class Piece {
    private Player player;

    public Piece(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    // Абстрактный метод для проверки правил хода
    public boolean isValidMove(int[] start, int[] end, Piece[][] board) {
        return false;
    }
}

class Pawn extends Piece {
    public Pawn(Player player) {
        super(player);
    }

    @Override
    public boolean isValidMove(int[] start, int[] end, Piece[][] board) {
        // Реализация правил хода для пешки
        return false;
    }

    @Override
    public String toString() {
        return getPlayer() == Player.WHITE ? "P" : "p";
    }
}

class Rook extends Piece {
    public Rook(Player player) {
        super(player);
    }

    @Override
    public boolean isValidMove(int[] start, int[] end, Piece[][] board) {
        // Реализация правил хода для ладьи
        return false;
    }

    @Override
    public String toString() {
        return getPlayer() == Player.WHITE ? "R" : "r";
    }
}

// Другие классы фигур аналогично

class Player {
    public static final Player WHITE = new Player();
    public static final Player BLACK = new Player();

    private Player() {
        // Приватный конструктор для создания объектов WHITE и BLACK
    }
}

class InvalidMoveException extends Exception {
    public InvalidMoveException(String message) {
        super(message);
    }
}
