package com.yogesh.chess;

import com.yogesh.chess.exception.*;
import com.yogesh.chess.strategy.*;

import java.util.*;

public class Game {
    private Board board;
    private Queue<Player> playerQueue;
    private GameStatus gameStatus;
    private static final int x = 8;
    private static final int y = 8;
    private GameStrategy gameStrategy;

    public void Game(final Board board, final GameStrategy gameStrategy) {
        this.playerQueue = new LinkedList<>();
        this.board = board;
        this.gameStatus = GameStatus.STARTED;
        this.gameStrategy = gameStrategy;
    }

    public void startGame() {
        if (playerQueue.size() < 2) {
            throw new NotEnoughPlayer("2 player should be present");
        }
        while (playerQueue.size() > 1) {
            Player player = playerQueue.poll();
            Position position = gameStrategy.getPostion();
            Position nextPosition = gameStrategy.getNextPosition();
            boolean ans = board.makeMove(position, nextPosition);
        }
    }

    public void addPlayer(final Player player) {
        if (this.playerQueue.size() >= 2) {
            throw new PlayerExceedException();
        }
        this.playerQueue.add(player);
    }
}
