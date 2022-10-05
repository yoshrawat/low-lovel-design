package com.yogesh.chess.strategy;

import com.yogesh.chess.*;

public interface GameStrategy {
    Position getPostion();
    Position getNextPosition();
}
