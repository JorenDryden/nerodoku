package org.nerodoku.nerodoku;

public class Model {

    private final Board liveBoard = new Board();

    public Model() {

    }

    public Board getLiveBoard() {
        return liveBoard;
    }
}
