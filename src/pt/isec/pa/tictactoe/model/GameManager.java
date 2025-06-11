package pt.isec.pa.tictactoe.model;

import pt.isec.pa.tictactoe.model.data.Board;

import java.util.Scanner;

public class GameManager {
    Board board;
    private Scanner sc;

    public GameManager() {
        board = new Board();
        sc = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Bem-vindo ao Jogo da Velha!");
        System.out.println("Jogador 1: X | Jogador 2: O");
        System.out.println("Para jogar, digite a linha e coluna (1-3) separadas por espaço (ex: 1 2)");

        while (true) {
            board.showBoard();
            makeMove();

            if (board.checkWin()) {
                board.showBoard();
                System.out.println("Jogador " + board.getCurrentPlayer() + " venceu! Parabéns!");
                break;
            }

            if (board.isDraw()) {
                board.showBoard();
                System.out.println("O jogo terminou em empate!");
                break;
            }

            board.switchPlayer();
        }

        sc.close();
    }

    public void makeMove() {
        boolean canMove = false;

        while (!canMove) {
            System.out.print("Jogador " + board.getCurrentPlayer() + ", faça sua jogada: ");
            int linha = sc.nextInt() - 1;
            int coluna = sc.nextInt() - 1;

            if (board.makeMove(linha, coluna)) {
                canMove = true;
            } else {
                System.out.println("Jogada inválida! Tente novamente.");
            }
        }
    }
}
