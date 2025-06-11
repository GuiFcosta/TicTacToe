package pt.isec.pa.tictactoe.model.data;

import java.io.Serial;
import java.io.Serializable;

public class Board implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final int size = 3; // Default size for a Tic Tac Toe board

    private char[][] board = new char[size][size]; // 2D array to represent the board
    public Board() {
        resetBoard();
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public boolean makeMove(int row, int col, char player) {
        if (!isCellEmpty(row, col)) {
            return false; // Invalid move
        }
        board[row][col] = player; // Place the player's mark on the board
        return true; // The Move was successful
    }

    public boolean isCellEmpty(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ';
    }

    public boolean checkWin(char player) {
        // Verificar linhas e colunas
        for (int i = 0; i < size; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Verificar diagonais
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' '; // Reset each cell to a space character
            }
        }
    }
}
