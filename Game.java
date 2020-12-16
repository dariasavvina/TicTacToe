package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {
    final private GameField gameField;
    final private IPlayer firstPlayer;
    final private IPlayer secondPlayer;
    final private int countWinItem;

    final static private List<Pair<Integer, Integer>> directions = new ArrayList<>();

    public Game(int sizeField, CellType first, CellType second,int countWinItem /*boolean isComputer*/){
        this.countWinItem = countWinItem;
        gameField = new GameField(sizeField);
        firstPlayer = new Player(first);
        secondPlayer = new Player(second);
        //secondPlayer = isComputer ? new ComputerPlayer(second, gameField) : new Player(second);
        directions.add(new Pair<>(-1,-1));
        directions.add(new Pair<>(-1, 0));
        directions.add(new Pair<>(-1, 1));
        directions.add(new Pair<>(0, 1));
    }

    public IPlayer getFirstPlayer() {
        return firstPlayer;
    }

    public IPlayer getSecondPlayer() {
        return secondPlayer;
    }

    public boolean isDraw(){
        return firstPlayer.getMarkedCells().size()
                + secondPlayer.getMarkedCells().size() == (gameField.getSize() * gameField.getSize());
    }

    public static boolean isCorrectEnteredIndex(int first, int second, int size){
        return first >= 0 && first < size
                && second >= 0 && second < size;

    }

    public GameField getGameField() {
        return gameField;
    }

    public void stepGame(IPlayer currentPlayer){
        System.out.println("Enter the address of the cell in space (1 - column number, 2 - line number)");
        Pair<Integer, Integer> indexes = currentPlayer.Move(gameField.getSize());
        gameField.setCell(indexes.getKey(), indexes.getValue(), currentPlayer.getGameEntity());
        GUI.printMap(gameField.getGameField(), gameField.getSize());
    }

    public boolean isWin(IPlayer currentPlayer){
        for (Pair<Integer, Integer> item : currentPlayer.getMarkedCells())
            if (scannerCells(item, currentPlayer.getGameEntity()))
                return true;
        return false;
    }


    private boolean scannerCells(Pair<Integer, Integer> indexes, CellType compareCell){
        int countMarkedCell = 1;
        for(Pair<Integer, Integer> direction: directions){
            countMarkedCell += countMarkedCellOnDirection(indexes, compareCell, direction, 1);
            countMarkedCell += countMarkedCellOnDirection(indexes, compareCell, direction, -1);
            if (countMarkedCell == countWinItem)
                return true;
            countMarkedCell = 1;
        }
        return false;
    }

    private int countMarkedCellOnDirection(Pair<Integer, Integer> indexes, CellType compareCell,
                                          Pair<Integer, Integer> direction, int signDirection){
        int countMarkedCell = 0;
        for(int i = 1; i < countWinItem; i++){
            int firstIndex = indexes.getKey() + (direction.getKey() * signDirection) * i;
            int secondIndex = indexes.getValue() + (direction.getValue() * signDirection) * i;
            if (isCorrectEnteredIndex(firstIndex, secondIndex, gameField.getSize()))
                if(gameField.getCell(firstIndex, secondIndex) == compareCell)
                    countMarkedCell++;
        }
        return countMarkedCell;
    }
}
