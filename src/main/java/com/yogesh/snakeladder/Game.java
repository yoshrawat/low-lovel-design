package com.yogesh.snakeladder;

import com.yogesh.snakeladder.exception.*;

import java.util.*;

public class Game {
    private Board board;
    private Dice dice;
    private GameStatus gameStatus;
    private Queue<Player> players;

    public Game(final Board board, final Dice dice) {
        this.board = board;
        this.dice = dice;
        gameStatus = GameStatus.NOT_STARTED;
    }

    public void startGame() {
        this.gameStatus = GameStatus.RUNNING;
        board.printBoard();

        while (players.size() > 1) {
            Player currentPlayer = players.poll();
            makeMove(currentPlayer);
        }

    }

    public void makeMove(Player player) {
        System.out.println(player.getName());

        int rollValue = dice.roll();
        int currentPosition = player.getPosition();
        int targetPosition = currentPosition + rollValue;

        if (targetPosition > board.getDimension()) {
            throw new InValidMoveException("InValid Move");
        } else {
            if (board.getSpecialEntities().containsKey(targetPosition)) {
                targetPosition = board.getSpecialEntities().get(targetPosition).getEndPosition();
            }
            player.setPosition(targetPosition);
        }
    }

    public void addPlayers(List<Player> player) {
        if (gameStatus != GameStatus.NOT_STARTED) {
            throw new GameAlreadyStartedException("Game is already started");
        }
        players.addAll(player);
    }
}
