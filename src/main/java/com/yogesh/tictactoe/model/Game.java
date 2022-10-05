package com.yogesh.tictactoe.model;


import com.yogesh.tictactoe.exception.*;
import com.yogesh.tictactoe.strategy.*;

import java.util.*;

public class Game {
    private Board board;
    private int moveCount;
    private GameStrategy gameStrategy;
    private Queue<Player> players;

    public Game(final Board board, final GameStrategy gameStrategy) {
        this.board = board;
        this.gameStrategy = gameStrategy;
        this.moveCount = 0;
        players = new LinkedList<>();
    }

    public void addPlayer(final Player player) {
        players.add(player);
    }

    public void startGame() {
        if (players.size() < 2)
            throw new NotEnoughPlayer("2 player should be present");

        while (moveCount < Board.TOTAL_MOVES) {
            Player currentPlayer = players.poll();
            int[] newCor = gameStrategy.getNextPos();
            while (!board.isValid(newCor)) {
                newCor = gameStrategy.getNextPos();
            }
            boolean ans = board.makeMove(currentPlayer, newCor);
            if (ans) {
                System.out.println("winner is :" + currentPlayer.getClass());
                return;
            }
            moveCount++;
            players.add(currentPlayer);
        }
    }
}
