package com.company;

import javafx.util.Pair;

import java.util.List;

public interface IPlayer {
    Pair<Integer, Integer> Move(int size);
    CellType getGameEntity();
    List<Pair<Integer, Integer>> getMarkedCells();
    int getSerialNumber();
}
